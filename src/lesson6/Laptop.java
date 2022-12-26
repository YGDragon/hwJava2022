package lesson6;

public class Laptop {
    String article; // артикул
    String manufacturer; // производитель
    String colorCase; // цвет корпуса
    int screenDiagonal; // диагональ экрана
    int volumeRamMemory; // объем оперативной памяти
    int volumeHardMemory; // объем жесткого диска

    Laptop(String article,
           String manufacturer,
           String colorCase,
           int screenDiagonal,
           int volumeRamMemory,
           int volumeHardMemory) {
        this.article = article;
        this.manufacturer = manufacturer;
        this.colorCase = colorCase;
        this.screenDiagonal = screenDiagonal;
        this.volumeRamMemory = volumeRamMemory;
        this.volumeHardMemory = volumeHardMemory;
    }


    void laptopInfo() {
        System.out.printf("%s -> %s, %d\", RAM - %dГБ, HDD - %dГБ, цвет корпуса - %s\n",
                article, manufacturer, screenDiagonal, volumeRamMemory, volumeHardMemory, colorCase);
    }
}