package lesson1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//вызов методов к задаче №1
        System.out.println("Задача №1 - сумма в пределах от 10 до 20");
        System.out.println("Введите два целых числа: ");
        int num11 = getNum();
        int num12 = getNum();
        System.out.printf("Результат -> %s\n", checkSum(num11, num12));
        System.out.println();

//вызов методов к задаче №2
        System.out.println("Задача №2 - число положительное или отрицательное");
        System.out.println("Введите целое число: ");
        int num2 = getNum();
        numPosNeg1(num2);
        System.out.println();

//вызов методов к задаче №3
        System.out.println("Задача №3 - число положительное или отрицательное");
        System.out.println("Введите целое число: ");
        int num3 = getNum();
        System.out.printf("Результат -> %s\n", numPosNeg2(num3));
        System.out.println();

//вызов методов к задаче №4
        System.out.println("Задача №4 - печать строки указанное количество раз");
        System.out.println("Введите произвольный строку: ");
        String str = getString();
        System.out.println("Введите целое число: ");
        int num4 = getNum();
        numStrings(str, num4);
        System.out.println();

//вызов методов к задаче №5
        System.out.println("Задача №5 - високосны год ");
        System.out.println("Введите год: ");
        int num5 = getNum();
        System.out.printf("Результат -> %s\n", highYear(num5));
        System.out.println();

//вызов метода к задаче №6
        System.out.println("Задача №6 - в массиве заменить 0 на 1, 1 на 0");
        numArray1();
        System.out.println();

//вызов метода к задаче №7
        System.out.println("Задача №7 - заполнение массива 1...100");
        fullArray();
        System.out.println();

//вызов метода к задаче №8
        System.out.println("Задача №8 - умножение на 2 элемента массива < 6");
        numArray2();
        System.out.println();
        System.out.println();

//вызов метода к задаче №9
        System.out.println("Задача №9 - заполнение диагоналей двумерного массива");
        getQuadArray();
        System.out.println();

//вызов метода к задаче №10
        System.out.println("Задача №10 - массив len и initialValue");
        System.out.println("Введите длину массива: ");
        int num101 = getNum();
        System.out.println("Введите значение для массива: ");
        int num102 = getNum();
        int[] resultArray = getOneArray(num101, num102);
        System.out.println(Arrays.toString(resultArray));
        System.out.println();

//вызов метода к задаче №11
        System.out.println("Задача №11 - min и max элементы массива");
        arrayMinMax();
        System.out.println();
    }

    // метод получения числа из консоли
    private static int getNum() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    // метод получения строки из консоли
    private static String getString() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    // задача №1 - метод
    private static boolean checkSum(int num1, int num2) {
        int sum = num1 + num2;
        return (10 < sum & sum < 21);
    }

    // задача №2 - метод
    private static void numPosNeg1(int num) {
        if (num < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    // задача №3 - метод
    private static boolean numPosNeg2(int num) {
        return num < 0;
    }

    // задача №4 - метод
    private static void numStrings(String str, int num) {
        for (int i = 1; i <= num; i++) {
            System.out.println(str);
        }
    }

    // задача №5 - метод
    private static boolean highYear(int year) {
        if (year < 100) {
            return year % 4 == 0;
        } else {
            return year % 100 == 0 && year % 400 == 0;
        }
    }

    // задача №6 - метод
    private static void numArray1() {
        int[] arr = new int[11];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, 2);
        }
        System.out.printf("Исходный массив   -> %s\n", Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.printf("Измененный массив -> %s\n", Arrays.toString(arr));
    }

    // задача №7 - метод
    private static void fullArray() {
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] += i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    // задача №8 - метод
    private static void numArray2() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.printf("%s\n", Arrays.toString(arr));
        String line = "";

        for (int j : arr) {
            if (j < 6) {
                System.out.printf(" %d ", j * 2);
            } else {
                System.out.printf(" %d ", j);
            }
        }
    }

    // задача №9 - метод
    private static void getQuadArray() {
        int[][] twoArr = new int[5][5];
        int sizeRow = twoArr[0].length;
        int sizeCol = twoArr[1].length;

        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeCol; j++) {
                if (i == j | j == sizeRow - 1 - i)
                    twoArr[i][j] = 1;
            }
            System.out.println(Arrays.toString(twoArr[i]));
        }
    }

    // задача №10 - метод
    private static int[] getOneArray(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }

    // задача №11 - метод
    private static void arrayMinMax() {
        int[] arr = new int[11];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(5, 25);
        }
        System.out.printf("Исходный массив   -> %s\n", Arrays.toString(arr));
        int max = arr[0];
        int min = arr[1];
        for (int j : arr) {
            if (j > max) {
                max = j;
            } else if (j < min) {
                min = j;
            }
        }
        System.out.printf("Минимальный элемент -> %s\n", min);
        System.out.printf("Максимальный элемент -> %s", max);
    }
}
