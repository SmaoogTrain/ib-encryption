package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Encryption3 {
    private static final String TABLE_FILE_PATH = "IB\\encryption3\\table.txt";

    public static void encrypt3() {
        try {
            Map<Character, Character> replacementTable = loadReplacementTable(TABLE_FILE_PATH);

            String message = "Example of useless text message.";
            System.out.println("Исходное сообщение: " + message);

            String encryptedMessage = encrypt(message, replacementTable);
            System.out.println("Зашифрованное сообщение: " + encryptedMessage);

            String decryptedMessage = decrypt(encryptedMessage, replacementTable);
            System.out.println("Расшифрованное сообщение: " + decryptedMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<Character, Character> loadReplacementTable(String filePath) throws IOException {
        Map<Character, Character> table = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    table.put(parts[0].charAt(0), parts[1].charAt(0));
                }
            }
        }
        return table;
    }

    private static String encrypt(String message, Map<Character, Character> replacementTable) {
        StringBuilder result = new StringBuilder();
        for (String word : message.split("\\s+")) {
            StringBuilder encryptedWord = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (i % 2 != 0 && replacementTable.containsKey(ch)) {
                    encryptedWord.append(replacementTable.get(ch));
                } else {
                    encryptedWord.append(ch);
                }
            }
            result.append(encryptedWord).append(" ");
        }
        return result.toString().trim();
    }

    private static String decrypt(String encryptedMessage, Map<Character, Character> replacementTable) {
        Map<Character, Character> reverseTable = new HashMap<>();
        for (Map.Entry<Character, Character> entry : replacementTable.entrySet()) {
            reverseTable.put(entry.getValue(), entry.getKey());
        }
        return encrypt(encryptedMessage, reverseTable);
    }
}
