package lesson4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MyQueue {
    static String[] initializeArray = {
    };
    static String[] menu = {
            "add",
            "top",
            "remove",
            "exit"};
    static LinkedList<String> queue = new LinkedList<String>(Arrays.asList(
            "men",
            "women",
            "boy",
            "girl"));
    static Scanner getData = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.printf("Инициализированная очередь:%s\n\n", queue);

        while (true) {
            String choice = actions();
            // вызов метода выбранного действия
            if (choice.equals(menu[0])) {
                add();
                System.out.printf("Очередь обновлена -> %s\n\n", queue);
            } else if (choice.equals(menu[1])) {
                String topEl = top();
                System.out.printf("%s -> %s\n", menu[1], topEl);
            } else if (choice.equals(menu[2])) {
                String removeEL = remove();
                System.out.printf("%s -> %s\n", menu[2], removeEL);
                System.out.printf("Очередь обновлена -> %s\n\n", queue);
            } else {
                System.exit(0);
            }
        }
    }

    // метод выволнения действий
    private static String actions() {

        System.out.printf("""
                Действия ->
                            %s - добавить в очередь;
                            %s - посмотреть первое в очереди;
                            %s - извлечь и вернуть первое в очереди;
                            %s - выход.
                """, menu[0], menu[1], menu[2], menu[3]);

        System.out.print("выполнить действие -> ");
        String action = getData.next();

        // проверка корректности ввода действия
        while (true) {
            if (!action.equals(menu[0]) &
                    !action.equals(menu[1]) &
                    !action.equals(menu[2]) &
                    !action.equals(menu[3])) {
                System.out.printf("""
                        Неверный ввод -> ведите %s, %s, %s, %s
                        выполнить действие ->\s""", menu[0], menu[1], menu[2], menu[3]);
                action = getData.next();
            } else {
                break;
            }
        }
        return action;
    }

    // метод добавления нового элемента в конец
    private static void add() {
        System.out.print("Добавить в очередь -> ");
        String text = getData.next();
        queue.add(text);
    }

    // метод вывода первого элемента
    private static String top() {
        return queue.getFirst();
    }

    // метод удаления и вывод первого элемента
    private static String remove() {
        return queue.pollFirst();
    }
}