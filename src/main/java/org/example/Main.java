package org.example;


import java.util.Scanner;

import static org.example.Encryption1.encrypt1;
import static org.example.Encryption2.encrypt2;
import static org.example.Encryption3.encrypt3;
import static org.example.Encryption4.encrypt4;
import static org.example.Encryption5.encrypt5;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while(true) {
            System.out.printf("Выберите шифр для шифровки/расшифровки:");
            System.out.printf("1) Простой шифр: четный символ заменяется на соседний слева, нечетный на соседний справа;");
            System.out.printf("2) Простой перестановочный шифр: перестановка пар соседних символов;");
            System.out.printf("3) Шифр по таблице, записанной в текстовом файле;");
            System.out.printf("4) Шифрование файла с заменой исходного символа на число, полученное суммой кодов символа в файлах+заданное число;");
            System.out.printf("5) Шифрование блоков по 4 символа перестановкой 1 и 3, 2 и 4 символа.");
            int nmbr = inp.nextInt();
            if(nmbr == 0) {
                break;
            }
            switch(nmbr) {
                case 1:
                    encrypt1();
                    break;
                case 2:
                    encrypt2();
                    break;
                case 3:
                    encrypt3();
                    break;
                case 4:
                    encrypt4();
                    break;
                case 5:
                    encrypt5();
                    break;


            }
        }

        inp.close();
    }
}