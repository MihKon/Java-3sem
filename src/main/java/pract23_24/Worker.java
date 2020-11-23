package pract23_24;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Worker {
    private static HttpClient httpClient = HttpClient.newHttpClient();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Gson gson1 = new Gson();
    private final static String tasks = "http://gitlessons2020.rtuitlab.ru:3000/tasks";
    private final static String reports = "http://gitlessons2020.rtuitlab.ru:3000/reports";
    private static List<Task> taskList = new ArrayList<>();
    private static File file = new File("src\\main\\java\\pract23_24\\db.json");
    private BufferedReader reader;
    private FileWriter writer;

    {
        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Worker() {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(tasks)).build();

        getTaskList(request);

        //readFile();

        //int id = getIdOfTask();
        int id=1;

        double result = calculateExpression(taskList.get(id).getExpression());
        System.out.println(result);

        Report report = new Report(0, id, result);
        System.out.println(gson.toJson(report));
        String body = gson.toJson(report);
        request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(body)).uri(URI.create(reports)).build();
        //sendReport(request);
    }

    private void sendReport(HttpRequest request) {
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getTaskList(HttpRequest request) {
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            taskList = gson.fromJson(response.body(), new TypeToken<List<Task>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void readFile(){
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int getIdOfTask(){
        int j = 1;
        if (file!=null) {
            for (int i = 0; i < taskList.size(); i++) {
                String s = null;
                try {
                    s = gson1.toJson(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Task t = gson1.fromJson(s, new TypeToken<List<Task>>() {
                }.getType());
                if (!taskList.get(i).equals(t)) {
                    j = i;
                    try {
                        writer.write(gson1.toJson(t));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else {
            for (Task t: taskList) {
                try {
                    writer.write(gson1.toJson(t));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return j;
    }

    private double calculateExpression(String expression){
        String result;
        Pattern pattern = Pattern.compile("(?<sign1>\\W)\1 (?<number1>\\d+)\1 (?<operator>\\W)\1 (?<sign2>\\W)\1 (?<number2>\\d+)\1");
        Matcher matcher = pattern.matcher(expression);
        String sign1 = null;
        String num1 = null;
        String op = null;
        String sign2 = null;
        String num2 = null;
        if (matcher.find()){
            System.out.println(matcher.group());
             sign1 = matcher.group("sign1");
             num1 = matcher.group("number1");
             op = matcher.group("operator");
             sign2 = matcher.group("sign2");
             num2 = matcher.group("number2");
        }
        double a = 0, b = 0, res = 0;
        if (num1!=null) {
            if (sign1 != null && sign1.equals("-"))
                a = -Double.parseDouble(num1);
            else
                a = Double.parseDouble(num1);
        }
        if (num2!=null) {
            if (sign2 != null && sign2.equals("-"))
                b = -Double.parseDouble(num2);
            else
                b = Double.parseDouble(num2);
        }
        System.out.println(a + " " + op + " " + b);
        switch (op){
            case "+": {
                res = a + b;
                break;
            }
            case "-": {
                res = a - b;
                break;
            }
            case "/": {
                if (b!=0)
                    res = a/b;
                break;
            }
            case "*": {
                res = a*b;
                break;
            }
        }
        System.out.println(res);
        result = String.format("%.2f", res);
        res = Double.parseDouble(result);
        return res;
    }
}
