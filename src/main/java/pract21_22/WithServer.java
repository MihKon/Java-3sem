package pract21_22;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class WithServer implements ItemsStore {
    private static HttpClient httpClient = HttpClient.newHttpClient();
    private static Gson gson = new Gson();

    public WithServer() {
        Scanner scan = new Scanner(System.in);
        int n;
        while (true) {
            System.out.println("Выберите действие:\n" +
                    "1 - получить все записи\n" +
                    "2 - получить одну записьт\n" +
                    "3 - добавить запись\n" +
                    "4 - редактировать запись\n" +
                    "5 - удалить запись");
            n = scan.nextInt();
            switch (n) {
                case 1: {
                    for (Item i : getAll()) {
                        System.out.println(gson.toJson(i));
                    }
                    break;
                }
                case 2: {
                    System.out.println("Введите id:");
                    int j = scan.nextInt();
                    System.out.println(gson.toJson(get(j)));
                    break;
                }
                case 3: {
                    System.out.println("Введите данные новой записи: ");
                    int id = scan.nextInt();
                    String data = scan.next();
                    boolean isGood = scan.nextBoolean();
                    String description = scan.next();
                    System.out.println(gson.toJson(addItem(new Item(id, data, isGood, description))));
                    break;
                }
                case 4: {
                    System.out.println("Введите id записи, которую хотите редактировать:");
                    int id1 = scan.nextInt();
                    int id = 0;
                    String data = null, description = null;
                    boolean isGood = false;
                    System.out.println("Выберите, что вы хотите изменить:\n" +
                            "1 - id\n" +
                            "2 - data\n" +
                            "3 - isGood\n" +
                            "4 - description\n" +
                            "Вводите последовательность: ");
                    String s = scan.nextLine();
                    if (s.contains("1"))
                        id = scan.nextInt();
                    if (s.contains("2"))
                        data = scan.next();
                    if (s.contains("3"))
                        isGood = scan.nextBoolean();
                    if (s.contains("4"))
                        description = scan.next();
                    System.out.println(gson.toJson(editItem(id1, new Item(id, data, isGood, description))));
                    break;
                }
                case 5: {
                    System.out.println("Введите id записи, которую хотите удалить:");
                    int id = scan.nextInt();
                    deleteItem(get(id));
                    break;
                }
            }
            System.out.println("\nЧтобы продолжить, нажмите 0");
            n = scan.nextInt();
        }
    }

    public List<Item> getAll() {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://80.87.199.76:3000/objects"))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            List<Item> list = gson.fromJson(response.body(), List.class);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Item get(int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://80.87.199.76:3000/objects?id=" + id))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            Item item = gson.fromJson(response.body(), Item.class);
            return item;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Item addItem(Item item) {
        String body = gson.toJson(item);
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("http://80.87.199.76:3000/objects"))
                .setHeader("Content-Type", "application/json")
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            Item newItem = gson.fromJson(response.body(), Item.class);
            return newItem;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Item editItem(int id, Item item) {
        String body = gson.toJson(item);
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("http://80.87.199.76:3000/objects/" + id))
                .setHeader("Content-Type", "application/json")
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            Item newItem = gson.fromJson(response.body(), Item.class);
            return newItem;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteItem(Item item) {
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create("http://80.87.199.76:3000/objects/" + item.getId()))
                .setHeader("Content-Type", "application/json")
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
