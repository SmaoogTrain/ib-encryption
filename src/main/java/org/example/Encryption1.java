package org.example;

public class Encryption1 {
    public static void encrypt1() {
        String message = "Пример текста для шифрования с заменой символов";
        System.out.println("Исходное сообщение: " + message);

        String encryptedMessage = encrypt(message);
        System.out.println("Зашифрованное сообщение: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Расшифрованное сообщение: " + decryptedMessage);
    }

    public static String encrypt(String message) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i+1==chars.length)
                break;
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
            i++;
        }
        return new String(chars);
    }

    public static String decrypt(String encryptedMessage) {
        char[] chars = encryptedMessage.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (i < chars.length) {
                char temp = chars[i];
                chars[i] = chars[i - 1];
                chars[i - 1] = temp;
                i++;
            }
        }
        return new String(chars);
    }
}
