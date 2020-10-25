package pract14;

import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static int N;
    private static String[] reg;
    private static String[] nWords;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        reg = new String[N];
        nWords = new String[N];
        for (int i = 0; i < N; i++) {
            reg[i] = scan.next();
            nWords[i] = scan.next();
        }
        String word = scan.next();
        StringBuilder regex = new StringBuilder();
        regex.append(reg[0]);
        for (int i = 1; i < N; i++) {
            regex.append("|");
            regex.append(reg[i]);
        }
        Pattern pattern = Pattern.compile(regex.toString());
        Matcher matcher = pattern.matcher(word);
        String nWord = "";
        nWord = matcher.replaceAll(new Function<MatchResult, String>() {
            @Override
            public String apply(MatchResult matchResult) {
                String s = "";
                for (int i = 0; i < N; i++) {
                    if (matchResult.group().equals(reg[i]))
                        s = nWords[i];
                }
                return s;
            }
        });
        System.out.println(nWord);
        changeWord(word);
    }

    public static void changeWord(String word) {
        int beginPos;
        int endPos;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            boolean f = false;
            for (int j = 0; j < N; j++) {
                beginPos = i;
                endPos = i + reg[j].length();
                if (endPos < word.length() && reg[j].equals(word.substring(beginPos, endPos))) {
                    s.append(nWords[j]);
                    i = endPos - 1;
                    f = true;
                    break;
                }
            }
            if (!f)
                s.append(word.charAt(i));
        }
        System.out.println(s);
    }
}
