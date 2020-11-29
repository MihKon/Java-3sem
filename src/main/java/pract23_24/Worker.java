package pract23_24;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
    //private static Gson gson1 = new Gson();
    private final static String tasks = "http://gitlessons2020.rtuitlab.ru:3000/tasks";
    private final static String reports = "http://gitlessons2020.rtuitlab.ru:3000/reports";
    private static List<Task> taskList = new ArrayList<>();
    private static List<Report> reportList = new ArrayList<>();
    //private static List<Report> reportList2 = new ArrayList<>();
    private static String path = "src\\main\\java\\pract23_24\\db.json";
    //private static String path2 = "src\\main\\java\\pract23_24\\db2.json";
    private static File file = new File(path);

    public void doTasks() {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(tasks)).build();
        getTaskList(request);
        int id = readFile();
        System.out.println(id);
        if (showTruth(id)) {
            //System.out.println(id);
            double result = calculateExpression(taskList.get(getNumOfTaskInList(id)).getExpression());
            //System.out.println(result);

            Report report = new Report(0, id, result);
            reportList.add(report);
            //System.out.println(gson.toJson(report));

            writeInFile();

            String body = gson.toJson(report);
            request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(body)).uri(URI.create(reports)).setHeader("Content-Type", "application/json").build();
            sendReport(request);

            //write2();
        }
    }

    private boolean showTruth(int id){
        int count = 0;
        for (Report r : reportList) {
            if (r.getId() == id)
                count++;
        }
        return count == 0;
    }

    private void writeInFile() {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write("["+'\n');
            for (int i = 0; i < reportList.size(); i++) {
                writer.write(gson.toJson(reportList.get(i)));
                if (i!=reportList.size()-1)
                    writer.write(",");
                writer.write('\n');
            }
            writer.write("]");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int readFile() {
        int i = 0;
        if (file != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(path));
                String task = "";
                String text = reader.readLine();
                while (text != null) {
                    task += text;
                    task += '\n';
                    text = reader.readLine();
                }
                reader.close();
                //System.out.println(task);
                for (Task t : taskList) {
                    if (!(task.contains("\"taskId\": " + t.getId()))) {
                        i = t.getId();
                        break;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
            i = 1;
        return i;
    }

    private void sendReport(HttpRequest request) {
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            //reportList2.add(gson.fromJson(response.body(), new TypeToken<Report>() {}.getType()));
            //System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getTaskList(HttpRequest request) {
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            taskList = gson.fromJson(response.body(), new TypeToken<List<Task>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int getNumOfTaskInList(int id) {
        int i = 0;
        for (Task t : taskList) {
            if (t.getId() == id)
                i = taskList.indexOf(t);
        }
        //System.out.println(i);
        return i;
    }

    private double calculateExpression(String expression) {
        //String result;
        Pattern pattern = Pattern.compile("(?<number1>[-]*\\d+)\\s*(?<operator>[-+*/])\\s*(?<number2>[-]*\\d+)");
        Matcher matcher = pattern.matcher(expression);
        String num1 = null;
        String op = null;
        String num2 = null;
        if (matcher.find()) {
            //System.out.println(matcher.group());
            num1 = matcher.group("number1");
            op = matcher.group("operator");
            num2 = matcher.group("number2");
        }
        double a = 0, b = 0, res = 0;
        if (num1 != null) {
            a = Double.parseDouble(num1);
        }
        if (num2 != null) {
            b = Double.parseDouble(num2);
        }
        //System.out.println(a + " " + op + " " + b);
        if (op != null) {
            if (op.contains("+"))
                res = a + b;
            else if (op.contains("-"))
                res = a - b;
            else if (op.contains("*"))
                res = a * b;
            else if (op.contains("/") && b != 0)
                res = a / b;
        }
        //System.out.println(res);
        //result = String.format("%.2f", res);
        //res = Double.parseDouble(result);
        BigDecimal num = BigDecimal.valueOf(res);
        num = num.setScale(2, RoundingMode.HALF_UP);
        return num.doubleValue();
    }

    /*private void write2(){
        try {
            FileWriter writer = new FileWriter(path2);
            writer.write("["+'\n');
            for (int i = 0; i < reportList2.size(); i++) {
                writer.write(gson.toJson(reportList2.get(i)));
                if (i!=reportList2.size()-1)
                    writer.write(",");
                writer.write('\n');
            }
            writer.write("]");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
