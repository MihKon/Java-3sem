package pract21_22;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainWithFile implements ItemsStore{
    private String path = "src\\main\\java\\pract21_22\\data.json";
    private File file = new File(path);
    private Gson gson = new Gson();
    private FileWriter writer;

    public MainWithFile() {
        Scanner scan = new Scanner(System.in);
        int n;
        while (true) {
            System.out.println("\nВыберите действие:\n" +
                    "1 - получить все записи\n" +
                    "2 - получить одну запись\n" +
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
                    System.out.print("id - ");
                    int id = scan.nextInt();
                    System.out.print("data - ");
                    String data = scan.next();
                    System.out.print("isGood - ");
                    boolean isGood = scan.nextBoolean();
                    System.out.print("description - ");
                    String description = scan.next();
                    Item item = new Item(id, data, isGood, description);
                    System.out.print(gson.toJson(addItem(item)));
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
                    String s = scan.next();
                    if (s.contains("1")) {
                        System.out.print("id - ");
                        id = scan.nextInt();
                    }
                    if (s.contains("2")) {
                        System.out.print("data - ");
                        data = scan.next();
                    }
                    if (s.contains("3")) {
                        System.out.print("isGood - ");
                        isGood = scan.nextBoolean();
                    }
                    if (s.contains("4")) {
                        System.out.print("description - ");
                        description = scan.next();
                    }
                    Item item = new Item(id, data, isGood, description);
                    System.out.println(gson.toJson(editItem(id1, item)));
                    break;
                }
                case 5: {
                    System.out.println("Введите id записи, которую хотите удалить:");
                    int id = scan.nextInt();
                    deleteItem(get(id));
                    break;
                }
            }
        }
    }

    public List<Item> getAll() {
        List<Item> items = new ArrayList<>();
        Type type = new TypeToken<List<Item>>(){}.getType();
        try (FileReader reader = new FileReader(file)) {
             items = gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    public Item get(int id) {
        Item item = null;
        List<Item> items = getAll();
        for (Item i: items) {
            if (i.getId() == id)
                item = i;
        }
        return item;
    }

    public Item addItem(Item item) {
        List<Item> items = getAll();
        if (items == null)
            items = new ArrayList<>();
        items.add(item);
        try {
            writer = new FileWriter(file);
            writer.write("[\n");
            for (Item i: items) {
                if(items.indexOf(i)!=items.size()-1)
                    writer.write("\t"+gson.toJson(i)+",\n");
                else
                    writer.write("\t"+gson.toJson(i)+"\n");
            }
            writer.write("]");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

    public Item editItem(int id, Item item) {
        List<Item> items = getAll();
        for (int i=0; i<items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.remove(items.get(i));
            }
        }
        if (item.getId()==0)
            item.setId(items.get(items.size()-1).getId()+1);
        items.add(item);
        items.sort(new Comparator<Item>() {
            @Override
            public int compare(Item item, Item t1) {
                return item.getId()-t1.getId();
            }
        });
        try {
            writer = new FileWriter(file);
            writer.write("[\n");
            for (Item i: items) {
                if(items.indexOf(i)!=items.size()-1)
                    writer.write("\t"+gson.toJson(i)+",\n");
                else
                    writer.write("\t"+gson.toJson(i)+"\n");
            }
            writer.write("]");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

    public void deleteItem(Item item) {
        List<Item> items = getAll();
        for (int i=0; i<items.size(); i++){
            if (items.get(i).getId() == item.getId())
                items.remove(i);
        }
        try {
            writer = new FileWriter(file);
            writer.write("[\n");
            for (Item i: items) {
                if(items.indexOf(i)!=items.size()-1)
                    writer.write("\t"+gson.toJson(i)+",\n");
                else
                    writer.write("\t"+gson.toJson(i)+"\n");
            }
            writer.write("]");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
