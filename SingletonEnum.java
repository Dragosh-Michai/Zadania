import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingletonEnum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Проверить Singleton для базы данных");
            System.out.println("2. Проверить Singleton для логирования");
            System.out.println("3. Работать со статусами заказов");
            System.out.println("4. Работать с сезонами года");
            System.out.println("0. Выход");
            System.out.print("Ваш выбор: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    testDatabaseSingleton();
                    break;
                case 2:
                    testLoggerSingleton();
                    break;
                case 3:
                    handleOrderStatuses(scanner);
                    break;
                case 4:
                    handleSeasons(scanner);
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        } while (choice != 0);

        scanner.close();
    }


    // Задача 1: Singleton для подключения к базе данных
    static class DatabaseConnector {
        private static DatabaseConnector instance;

        private DatabaseConnector() {
            System.out.println("Создаем подключение к базе данных.");
        }

        public static DatabaseConnector getInstance() {
            if (instance == null) {
                instance = new DatabaseConnector();
            }
            return instance;
        }
    }

    private static void testDatabaseSingleton() {
        DatabaseConnector db1 = DatabaseConnector.getInstance();
        DatabaseConnector db2 = DatabaseConnector.getInstance();
        System.out.println("Экземпляры базы данных одинаковы: " + (db1 == db2));
    }

    // Задача 2: Singleton для логирования
    static class Logger {
        private static Logger instance;
        private List<String> logs;

        private Logger() {
            logs = new ArrayList<>();
        }

        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        public void log(String message) {
            logs.add(message);
        }

        public void displayLogs() {
            for (String log : logs) {
                System.out.println(log);
            }
        }
    }

    private static void testLoggerSingleton() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First log message");
        logger2.log("Second log message");
        logger1.displayLogs();

        System.out.println("Logger instances are the same: " + (logger1 == logger2));
    }

    // Задача 3: Enum для статусов заказа
    enum OrderStatus {
        NEW, IN_PROGRESS, DELIVERED, CANCELLED
    }

    static class Order {
        private OrderStatus status;

        public Order(int orderId) {
            this.status = OrderStatus.NEW;
        }

        public void changeStatus(OrderStatus newStatus) {
            if (status == OrderStatus.DELIVERED && newStatus == OrderStatus.CANCELLED) {
                System.out.println("Невозможно отменить доставленный заказ!");
                return;
            }
            this.status = newStatus;
        }

        public OrderStatus getStatus() {
            return status;
        }
    }

    private static void handleOrderStatuses(Scanner scanner) {
        System.out.print("Введите id заказа: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();

        Order order = new Order(orderId);
        System.out.println("Заказ " + orderId + " статус: " + order.getStatus());

        while (true) {
            System.out.println("\nВыберите действие для заказа " + orderId + ":");
            System.out.println("1. Изменить статус на IN_PROGRESS");
            System.out.println("2. Изменить статус на DELIVERED");
            System.out.println("3. Изменить статус на CANCELLED");
            System.out.println("4. Посмотреть текущий статус");
            System.out.println("0. Назад");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    order.changeStatus(OrderStatus.IN_PROGRESS);
                    System.out.println("Заказ " + orderId + " статус: " + order.getStatus());
                    break;
                case 2:
                     order.changeStatus(OrderStatus.DELIVERED);
                    System.out.println("Заказ " + orderId + " статус: " + order.getStatus());
                   break;
                case 3:
                     order.changeStatus(OrderStatus.CANCELLED);
                    System.out.println("Заказ " + orderId + " статус: " + order.getStatus());
                    break;
                case 4:
                    System.out.println("Заказ " + orderId + " статус: " + order.getStatus());
                    break;
                 case 0:
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    // Задача 4: Enum для времен года
    enum Season {
        WINTER, SPRING, SUMMER, AUTUMN
    }

    public static String getSeasonName(Season season) {
        switch (season) {
            case WINTER:
                return "Зима";
            case SPRING:
                return "Весна";
            case SUMMER:
                return "Лето";
            case AUTUMN:
                return "Осень";
            default:
                return "Неизвестное время года";
        }
    }

    private static void handleSeasons(Scanner scanner) {
        while (true) {
            System.out.println("\nВыберите сезон для просмотра:");
            System.out.println("1. Зима");
            System.out.println("2. Весна");
            System.out.println("3. Лето");
            System.out.println("4. Осень");
             System.out.println("0. Назад");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Season of WINTER: " + getSeasonName(Season.WINTER));
                    break;
                case 2:
                    System.out.println("Season of SPRING: " + getSeasonName(Season.SPRING));
                    break;
                case 3:
                     System.out.println("Season of SUMMER: " + getSeasonName(Season.SUMMER));
                    break;
                case 4:
                     System.out.println("Season of AUTUMN: " + getSeasonName(Season.AUTUMN));
                    break;
                 case 0:
                      return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }
}
