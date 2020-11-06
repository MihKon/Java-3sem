package pract17_18;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    //private static ArrayList<String> files = new ArrayList<>();
    private static Path path = Paths.get("src").toAbsolutePath();
    private static String basePath = path.toString();
    private static PrintWriter writer = null;

    static {
        try {
            String result = "projects.md";
            writer = new PrintWriter(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //System.out.println(path);
        //System.out.println(basePath);
        File file = new File(basePath);
        try {
            fileDirectory(file);
        } finally {
            writer.close();
        }
        /*String result = "projects.md";
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String s : files) {
            //System.out.println(s);
            try {
                try (BufferedReader reader = new BufferedReader(new FileReader(s))) {
                    if (writer != null)
                    {
                        writer.write("##" + s);
                        writer.write('\n');
                        writer.write("```java");
                        writer.write('\n');
                        String line = reader.readLine();
                        while (line != null) {
                            //System.out.println(line);
                            writer.write(line);
                            writer.write('\n');
                            line = reader.readLine();
                        }
                        writer.write("```");
                        writer.write('\n');
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        }*/
    }

    public static void fileDirectory(File file) {
        if (file.isDirectory()) {
            String[] s = file.list();
            for (int i = 0; i < s.length; i++) {
                //System.out.println(Paths.get(file.getPath(), s[i]).toAbsolutePath().toString());
                fileDirectory(new File(Paths.get(file.getPath(), s[i]).toString()));
            }
        }
        if (file.isFile()) {
            //System.out.println(file.getPath());
            //files.add(file.getPath());
            try {
                try (BufferedReader reader = new BufferedReader(new FileReader(file.getPath()))) {
                    if (writer != null) {
                        writer.write("## " + file.getPath());
                        writer.write('\n');
                        writer.write("```java");
                        writer.write('\n');
                        String line = reader.readLine();
                        //StringBuilder result = new StringBuilder();
                        while (line != null) {
                            /*result.append(line);
                            result.append('\n');*/
                            //System.out.println(line);
                            writer.write(line);
                            writer.write('\n');
                            line = reader.readLine();
                        }
                        /*writer.write(result.toString());
                        writer.write('\n');
                        System.out.println(result);*/
                        writer.write("```");
                        writer.write('\n');
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
