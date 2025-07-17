package org.example;

public class Encryption5 {
    public static void encrypt5() {
    String text = "Пример текста для шифрования с перестановкой символов";
    System.out.println("Исходный текст: " + text);

    String encryptedText = encrypt(text);
    System.out.println("Зашифрованный текст: " + encryptedText);

    String decryptedText = decrypt(encryptedText);
    System.out.println("Расшифрованный текст: " + decryptedText);
}

    public static String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 4) {
            if (i + 3 < text.length()) {
                result.append(text.charAt(i + 2)).append(text.charAt(i + 3));
                result.append(text.charAt(i)).append(text.charAt(i + 1));
            } else {
                result.append(text.substring(i));
            }
        }
        return result.toString();
    }

    public static String decrypt(String encryptedText) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i += 4) {
            if (i + 3 < encryptedText.length()) {
                result.append(encryptedText.charAt(i + 2)).append(encryptedText.charAt(i + 3));
                result.append(encryptedText.charAt(i)).append(encryptedText.charAt(i + 1));
            } else {
                result.append(encryptedText.substring(i));
            }
        }
        return result.toString();
    }
}
