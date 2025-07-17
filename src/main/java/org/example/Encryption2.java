package org.example;

public class Encryption2 {
    public static void encrypt2() {
        String message = "Пример текста для шифрования с перестановкой пар соседних символов";
        System.out.println("Исходное сообщение: " + message);

        String encryptedMessage = encrypt(message);
        System.out.println("Зашифрованное сообщение: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Расшифрованное сообщение: " + decryptedMessage);
    }

    public static String encrypt(String message) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length - 1; i += 2) {
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
        }
        return new String(chars);
    }

    public static String decrypt(String encryptedMessage) {
        char[] chars = encryptedMessage.toCharArray();
        for (int i = 0; i < chars.length - 1; i += 2) {
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
        }
        return new String(chars);
    }
}
