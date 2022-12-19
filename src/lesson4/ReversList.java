package lesson4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReversList {
    static LinkedList<String> myList = new LinkedList<String>(Arrays.asList(
            "рис",
            "рож",
            "пшеница",
            "кукуруза",
            "1",
            "2",
            "3",
            "4"));

    public static void main(String[] args) {
        System.out.printf("Исходный список -> %s\n", myList);
        System.out.printf("Перевернутый список -> %s", reversList());
    }

    public static LinkedList<String> reversList() {
        Queue<String> buffer = new LinkedList<>();
        int bufferSize = myList.size();

        int i = 0;
        while (i < bufferSize) {
            buffer.add(myList.pollLast());
            i++;
        }
        myList.addAll(buffer);
        return myList;
    }
}