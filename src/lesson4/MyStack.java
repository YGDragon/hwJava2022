package lesson4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MyStack {
    static String[] menu = {
            "push",
            "peek",
            "pop",
            "exit"};
    static LinkedList<String> stack = new LinkedList<String>(Arrays.asList(
            "folder1",
            "folder2",
            "folder3",
            "folder4"));
    static Scanner getData = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.printf("Инициализированный стек:%s\n\n", stack);

        while (true) {
            String choice = actions();
            // вызов метода выбранного действия
            if (choice.equals(menu[0])) {
                push();
                System.out.printf("Стек обновлен -> %s\n\n", stack);
            } else if (choice.equals(menu[1])) {
                String topEl = peek();
                System.out.printf("%s -> %s\n", menu[1], topEl);
            } else if (choice.equals(menu[2])) {
                String removeEL = pop();
                System.out.printf("%s -> %s\n", menu[2], removeEL);
                System.out.printf("Стек обновлен -> %s\n\n", stack);
            } else {
                System.exit(0);
            }
        }
    }

    // метод выволнения действий
    private static String actions() {

        System.out.printf("""
                Действия ->
                            %s - добавить в стек;
                            %s - посмотреть последнее в стеке;
                            %s - извлечь и вернуть последнее в стеке;
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
    private static void push() {
        System.out.print("Добавить в стек -> ");
        String text = getData.next();
        stack.add(text);
    }

    // метод просмотра последнего элемента
    private static String peek() {
        return stack.getLast();
    }

    // метод просмотра и удаление последнего эемента
    private static String pop() {
        return stack.pollLast();
    }

}
