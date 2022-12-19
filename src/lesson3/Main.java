package lesson3;

import java.util.*;
import java.util.function.Predicate;


public class Main {
    // инииализация переменной класса
    static Random rand = new Random();

    public static void main(String[] args) {

        // вызов метода к задаче №1
        System.out.println("Задача №1 - удаление четных элементов из списка");
        removeEvenNum(getList());
        System.out.println("\n");

        // вызов метода к задаче №2
        System.out.println("Задача №2 - нахождение в списке максимального, минимального и среднего арифметического");
        getMinMaxAverage(getList());
    }

    // метод создания списка из массива рандомных чисел
    private static List<Integer> getList() {
        // создание массива рандомных чисел
        Integer[] arr = new Integer[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        // создание списка из массива с использованием интерфейса Collections
        List<Integer> numList = new ArrayList<>();
        Collections.addAll(numList, arr);
        return numList;
    }

    // метод задачи №1
    private static void removeEvenNum(List<Integer> numList) {
        System.out.printf("Исходный список %s\n", numList);

        // создание предиката четности элементов
        Predicate<Integer> predicate = i -> i % 2 == 0;

        // удаление четных элементов
        numList.removeIf(predicate);
        System.out.printf("Измененный список %s", numList);
    }

    // метод задачи №2
    private static void getMinMaxAverage(List<Integer> numList) {
        System.out.printf("Исходный список %s\n", numList);
        // получение максимального и минимального элементов используя методы Stream
        Optional<Integer> maxNum = numList.stream()
                                          .max(Integer::compare);
        Optional<Integer> minNum = numList.stream()
                                          .min(Integer::compare);
        System.out.printf("""
                Максимальный элемент списка -> %s
                Минимальный элемент списка -> %s
                """, maxNum.get(), minNum.get());

        // получение среднего арифметического
        double averageNum = numList.stream()
                                    .mapToInt(i -> i)
                                    .average().orElse(0);
        System.out.printf("Среднее арифметическое %s", averageNum);


    }
}