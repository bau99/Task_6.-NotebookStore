public class Notebook {
    private String brand; // Бренд ноутбука
    private int ram; // ОЗУ в ГБ
    private int storage; // Объем ЖД в ГБ
    private String os; // Операционная система
    private String color; // Цвет ноутбука
    private double price; // Стоимость ноутбука

    // Конструктор класса Notebook
    public Notebook(String brand, int ram, int storage, String os, String color, double price) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    // Геттеры для полей класса
    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    // Переопределение метода toString для вывода информации о ноутбуке
    @Override
    public String toString() {
        return "Notebook{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
