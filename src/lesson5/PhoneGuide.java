package lesson5;

import java.util.*;

import static java.lang.System.in;

public class PhoneGuide {
    static Map<String, ArrayList<String>> guide = new HashMap<>();
    static Scanner getData = new Scanner(in);
    static int quantity = 3; // количество номеров для одной записи

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    \nТелефонный справочник:
                    1. Записать номера телефонов
                    2. Найти запись по фамилии
                    3. Просмотреть все записи
                    4. Выход из программы
                    """);
            System.out.print("Выполнить действие 1 / 2 / 3 / 4 ? -> ");

            String action = getData.next();
            switch (action) {
                case "1" -> {
                    System.out.print("Введите фамилию -> ");
                    String secondName = getData.next();
                    guide.put(secondName, getListNumbers()); // записать номера телефонов
                }
                case "2" -> getEntryPhone(guide); // найти запись в справочнике
                case "3" -> printEntryGuide(guide); // просмотреть все записи
                case "4" -> System.exit(0);
                default -> System.out.println("Неверный номер действия -> требуется ввести 1 / 2 / 3 / 4 !");
            }
        }
    }

    public static ArrayList<String> getListNumbers() {
        ArrayList<String> phone = new ArrayList<>();
        System.out.println("Введите номера телефонов");
        for (int i = 1; i <= quantity; i++) {
            phone.add(getData.next());
        }
        return phone;
    }

    public static void getEntryPhone(Map<String, ArrayList<String>> phoneGuide) {
        System.out.print("Введите фамилию: ");
        String secondName = getData.next();
        if (!phoneGuide.containsKey(secondName)) {
            System.out.println("Запись отсутствует!");
            secondName = getData.next();
        }
        System.out.printf("Номера телефонов: %s\n", String.join(", ", phoneGuide.get(secondName)));
    }

    public static void printEntryGuide(Map<String, ArrayList<String>> phoneGuide) {
        if (guide.isEmpty()) {
            System.out.println("Записи отсутствуют!");
        } else {
            System.out.println("Перечень записей:");
            for (String key : guide.keySet()) {
                System.out.printf("\t\t\t\t\t%s: %s\n", key, String.join(", ", guide.get(key)));
            }
        }
    }
}
