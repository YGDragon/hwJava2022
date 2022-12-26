package lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    static Scanner filter = new Scanner(in);
    static int count = 0;

    public static void main(String[] args) {
        Laptop lt1 = new Laptop(
                "laptop№1", "LENOVO", "ЧЕРНЫЙ",
                15, 8, 512);
        Laptop lt2 = new Laptop(
                "laptop№2", "ASUS", "СЕРЫЙ",
                16, 8, 256);
        Laptop lt3 = new Laptop(
                "laptop№3", "APPLE", "СЕРЫЙ",
                13, 16, 512);
        Laptop lt4 = new Laptop(
                "laptop№4", "HP", "ЧЕРНЫЙ",
                15, 8, 512);
        Laptop lt5 = new Laptop(
                "laptop№5", "LENOVO", "СЕРЫЙ",
                16, 16, 1000);
        Laptop lt6 = new Laptop(
                "laptop№6", "HP", "БЕЛЫЙ",
                13, 8, 256);

        Laptop[] laptops = {lt1, lt2, lt3, lt4, lt5, lt6};
        ArrayList<Laptop> laptopList = new ArrayList<>(Arrays.asList(laptops));
        filterLaptop(laptopList);
    }

    public static void filterLaptop(ArrayList<Laptop> laptopList) {
        System.out.print("""
                Введите критерий поиска:
                - производитель
                - диагональ экрана, дюймы
                - объем оперативной памяти, ГБ
                - объем жесткого диска, ГБ
                - цвет корпуса
                """);
        String data = filter.nextLine().toUpperCase();
        while (count == 0) {
            for (Laptop lt :
                    laptopList) {
                if (data.contains(lt.manufacturer) ||
                        data.contains(lt.colorCase) ||
                        data.contains(String.valueOf(lt.screenDiagonal)) ||
                        data.contains(String.valueOf(lt.volumeRamMemory)) ||
                        data.contains(String.valueOf(lt.volumeHardMemory))) {
                    lt.laptopInfo();
                    count++;
                }
            }
            if (count == 0) {
                System.out.print("Неверный ввод!\nПовторите ввод критерия поиска -> ");
                data = filter.next().toUpperCase();
            }
        }
    }
}