package lesson2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//вызов методов к задаче №1
        System.out.println("Задача №1 - определение полидрома строки");
        System.out.println("Введите строку для проверки:");
        String str = getString();
        System.out.printf("Результат -> %s\n", findPol(str));
        System.out.println();

//вызов методов к задаче №2
        System.out.println("Задача №2 - запись строки в файл");
        String string = "TEST";
        int repeat = 100;
        String string1 = stringGet(string, repeat);
        stringWriteToFile(string1);
    }

    // метод получения строки из консоли
    private static String getString() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    // метод определения палиндрома
    private static boolean findPol(String str) {
        // приведение строки
        String strCut = str.replaceAll(" ", "").toLowerCase();
        boolean result = true;

        for (int i = 0; i < strCut.length() / 2; i++) {
            char c = strCut.charAt(strCut.length() - 1 - i);
            if (strCut.charAt(i) != c) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static String stringGet(String string, int repeat) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (i < repeat + 1) {
            sb.append(string);
            i++;
        }
        return sb.toString();
    }

    private static void stringWriteToFile(String string) {
        try (PrintWriter pw = new PrintWriter("F:\\PROG\\Course Java\\hwJAVA\\lesson2\\src\\simple_file.txt")) {
            pw.print(string);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}