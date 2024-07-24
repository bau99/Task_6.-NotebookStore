import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class NotebookStore {
        public static void main(String[] args) {
        // Создание множества ноутбуков
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Dell", 8, 256, "Windows 10", "Black", 700.0));
        notebooks.add(new Notebook("HP", 16, 512, "Windows 10", "Silver", 1200.0));
        notebooks.add(new Notebook("Apple", 8, 256, "macOS", "Gray", 1500.0));
        notebooks.add(new Notebook("Asus", 4, 128, "Windows 10", "Blue", 500.0));
        notebooks.add(new Notebook("Lenovo", 16, 1024, "Linux", "Black", 900.0));

        Scanner scanner = new Scanner(System.in);
        
        // Определение критериев фильтрации
        Map<Integer, String> criteriaMap = new HashMap<>();
        criteriaMap.put(1, "ОЗУ");
        criteriaMap.put(2, "Объем ЖД");
        criteriaMap.put(3, "Операционная система");
        criteriaMap.put(4, "Цвет");
        criteriaMap.put(5, "Стоимость");

        while (true) {
            // Вывод меню для пользователя
            System.out.println("Выберите действие:");
            System.out.println("1 - Показать все ноутбуки");
            System.out.println("2 - Найти ноутбук по критериям");
            System.out.println("3 - Выход");

            int action = scanner.nextInt();
            scanner.nextLine(); // Поглощение символа новой строки

            if (action == 1) {
                // Вывод всех ноутбуков
                System.out.println("Все доступные ноутбуки:");
                for (Notebook notebook : notebooks) {
                    System.out.println(notebook);
                }
            } else if (action == 2) {
                // Запрос критериев фильтрации у пользователя
                Map<String, Object> filters = new HashMap<>();
                
                System.out.println("Введите цифру, соответствующую необходимому критерию:");
                for (Map.Entry<Integer, String> entry : criteriaMap.entrySet()) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }

                int criterion = scanner.nextInt();
                scanner.nextLine(); // Поглощение символа новой строки

                // Ввод значений для выбранного критерия
                switch (criterion) {
                    case 1:
                        System.out.print("Введите минимальный объем ОЗУ (в ГБ): ");
                        filters.put("ram", scanner.nextInt());
                        break;
                    case 2:
                        System.out.print("Введите минимальный объем ЖД (в ГБ): ");
                        filters.put("storage", scanner.nextInt());
                        break;
                    case 3:
                        System.out.print("Введите операционную систему: ");
                        filters.put("os", scanner.nextLine());
                        break;
                    case 4:
                        System.out.print("Введите цвет: ");
                        filters.put("color", scanner.nextLine());
                        break;
                    case 5:
                        System.out.print("Введите максимальную стоимость: ");
                        filters.put("price", scanner.nextDouble());
                        break;
                    default:
                        System.out.println("Неверный критерий");
                        continue;
                }

                // Фильтрация ноутбуков и вывод результатов
                Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filters);
                System.out.println("Ноутбуки, соответствующие фильтру:");
                for (Notebook notebook : filteredNotebooks) {
                    System.out.println(notebook);
                }
            } else if (action == 3) {
                // Выход из программы
                System.out.println("Выход из программы.");
                break;
            } else {
                // Обработка неверного выбора
                System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    // Метод для фильтрации ноутбуков по критериям
    public static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, Object> filters) {
        return notebooks.stream()
                .filter(notebook -> {
                    // Проверка каждого критерия
                    for (Map.Entry<String, Object> filter : filters.entrySet()) {
                        switch (filter.getKey()) {
                            case "ram":
                                if (notebook.getRam() < (int) filter.getValue()) return false;
                                break;
                            case "storage":
                                if (notebook.getStorage() < (int) filter.getValue()) return false;
                                break;
                            case "os":
                                if (!notebook.getOs().equalsIgnoreCase((String) filter.getValue())) return false;
                                break;
                            case "color":
                                if (!notebook.getColor().equalsIgnoreCase((String) filter.getValue())) return false;
                                break;
                            case "price":
                                if (notebook.getPrice() > (double) filter.getValue()) return false;
                                break;
                        }
                    }
                    return true;
                })
                .collect(Collectors.toSet());
    }
}
