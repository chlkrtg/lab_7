package ex4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст на английском языке:");
        String text = scanner.nextLine();

        HashMap<String, Integer> freq = new HashMap<>();

        StringBuilder word = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                word.append(c);
            } else { //слово закончилось
                if (word.length() > 0) {
                    String w = word.toString();
                    freq.put(w, freq.getOrDefault(w, 0) + 1);
                    word.setLength(0);
                }
            }
        }

        if (word.length() > 0) {
            String w = word.toString();
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        System.out.println("\nЧастота слов:");
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}


