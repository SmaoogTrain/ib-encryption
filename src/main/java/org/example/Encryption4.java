package org.example;

import java.io.*;

public class Encryption4 {
    private static final int SHIFT = 10;

    public static void encrypt4() {
        String inputFile = "\\IB\\encryption4\\input.txt";
        String encryptedFile = "\\IB\\encryption4\\encrypted.txt";
        String decryptedFile = "\\IB\\encryption4\\decrypted.txt";

        encryptFile(inputFile, encryptedFile);

        decryptFile(encryptedFile, decryptedFile);
    }

    public static void encryptFile(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            int ch;
            while ((ch = reader.read()) != -1) {
                int encryptedChar = ch + SHIFT;
                writer.write(encryptedChar);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл успешно зашифрован: " + outputFile);
    }

    public static void decryptFile(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            int ch;
            while ((ch = reader.read()) != -1) {
                int decryptedChar = ch - SHIFT;
                writer.write(decryptedChar);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл успешно дешифрован: " + outputFile);
    }
}
