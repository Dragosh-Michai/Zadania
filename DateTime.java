
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class DateAndTimeTasks {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // 1. Основы LocalDate и LocalTime
        System.out.println("\n--- 1. Текущая дата и время ---");
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        System.out.println("Текущая дата и время: " + currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " " + currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));


        // 2. Сравнение дат
        System.out.println("\n--- 2. Сравнение дат ---");
        LocalDate date1 = readDate("Введите первую дату (dd-MM-yyyy): ");
        LocalDate date2 = readDate("Введите вторую дату (dd-MM-yyyy): ");
        System.out.println("Результат сравнения: " + compareDates(date1, date2));


        // 3. Сколько дней до Нового года?
        System.out.println("\n--- 3. Дней до Нового года ---");
        System.out.println("Дней до Нового года: " + daysToNewYear());


        // 4. Проверка високосного года
        System.out.println("\n--- 4. Проверка високосного года ---");
        int yearToCheck = readInt("Введите год для проверки: ");
        System.out.println(yearToCheck + " - високосный год? " + isLeapYear(yearToCheck));


        // 5. Подсчет выходных за месяц
        System.out.println("\n--- 5. Подсчет выходных за месяц ---");
        int month = readInt("Введите месяц (число): ");
        int year = readInt("Введите год: ");
        System.out.println("Выходных в " + month + "/" + year + ": " + countWeekends(month, year));


        // 6. Расчет времени выполнения метода
        System.out.println("\n--- 6. Расчет времени выполнения метода ---");
        measureExecutionTime(() -> {
            long sum = 0;
            for (int i = 0; i < 1_000_000; i++) {
                sum += i;
            }
        });


        // 7. Форматирование и парсинг даты
        System.out.println("\n--- 7. Форматирование и парсинг даты ---");
        String dateString = readString("Введите дату в формате dd-MM-yyyy: ");
        formatAndParseDate(dateString);


        // 8. Конвертация между часовыми поясами
        System.out.println("\n--- 8. Конвертация между часовыми поясами ---");
        LocalDateTime dateTimeUtc = LocalDateTime.now();
        ZoneId fromZone = ZoneId.of("UTC");
        String toZoneString = readString("Введите целевой часовой пояс (например, Europe/Moscow): ");
        ZoneId toZone = ZoneId.of(toZoneString);
        convertTimeZone(dateTimeUtc, fromZone, toZone);


        // 9. Вычисление возраста по дате рождения
        System.out.println("\n--- 9. Вычисление возраста по дате рождения ---");
        LocalDate birthDate = readDate("Введите дату рождения (dd-MM-yyyy): ");
        System.out.println("Возраст: " + calculateAge(birthDate));

        // 10. Создание календаря на месяц
        System.out.println("\n--- 10. Создание календаря на месяц ---");
        int calendarMonth = readInt("Введите месяц для календаря (число): ");
        int calendarYear = readInt("Введите год для календаря: ");
        printCalendar(calendarMonth, calendarYear);


        // 11. Генерация случайной даты в диапазоне
        System.out.println("\n--- 11. Генерация случайной даты в диапазоне ---");
        LocalDate startDate = readDate("Введите начальную дату диапазона (dd-MM-yyyy): ");
        LocalDate endDate = readDate("Введите конечную дату диапазона (dd-MM-yyyy): ");
        System.out.println("Случайная дата: " + generateRandomDate(startDate, endDate));


        // 12. Расчет времени до заданной даты
        System.out.println("\n--- 12. Расчет времени до заданной даты ---");
         LocalDateTime eventDateTime = readDateTime("Введите дату и время события (dd-MM-yyyy HH:mm): ");
        calculateTimeToEvent(eventDateTime);


        // 13. Вычисление количества рабочих часов
        System.out.println("\n--- 13. Вычисление количества рабочих часов ---");
        LocalDateTime startWork = readDateTime("Введите начало рабочего дня (dd-MM-yyyy HH:mm): ");
        LocalDateTime endWork = readDateTime("Введите конец рабочего дня (dd-MM-yyyy HH:mm): ");
        System.out.println("Рабочих часов: " + calculateWorkingHours(startWork, endWork));


        // 14. Конвертация даты в строку с учетом локали
        System.out.println("\n--- 14. Конвертация даты в строку с учетом локали ---");
        LocalDate dateToFormat = readDate("Введите дату для форматирования (dd-MM-yyyy): ");
        String localeString = readString("Введите локаль (например, ru, en): ");
        Locale locale = Locale.forLanguageTag(localeString);
        formatDateWithLocale(dateToFormat, locale);


        // 15. Определение дня недели по дате
        System.out.println("\n--- 15. Определение дня недели по дате ---");
        LocalDate dateForDayOfWeek = readDate("Введите дату для определения дня недели (dd-MM-yyyy): ");
        System.out.println("День недели: " + getDayOfWeekName(dateForDayOfWeek));
        
        scanner.close();
    }

    // 2. Сравнение дат
    public static String compareDates(LocalDate date1, LocalDate date2) {
        if (date1.isAfter(date2)) {
            return "Первая дата позже второй.";
        } else if (date1.isBefore(date2)) {
            return "Первая дата раньше второй.";
        } else {
            return "Даты равны.";
        }
    }

    // 3. Сколько дней до Нового года?
    public static long daysToNewYear() {
        LocalDate today = LocalDate.now();
        LocalDate newYear = LocalDate.of(today.getYear() + 1, 1, 1);
        return ChronoUnit.DAYS.between(today, newYear);
    }

    // 4. Проверка високосного года
    public static boolean isLeapYear(int year) {
        return Year.isLeap(year);
    }

    // 5. Подсчет выходных за месяц
    public static int countWeekends(int month, int year) {
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());
        int weekends = 0;
        for (LocalDate date = firstDayOfMonth; !date.isAfter(lastDayOfMonth); date = date.plusDays(1)) {
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                weekends++;
            }
        }
        return weekends;
    }

    // 6. Расчет времени выполнения метода
    public static void measureExecutionTime(Runnable method) {
        long startTime = System.nanoTime();
        method.run();
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0; // in milliseconds
        System.out.println("Время выполнения: " + duration + " мс");
    }

    // 7. Форматирование и парсинг даты
    public static void formatAndParseDate(String dateString) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate date = LocalDate.parse(dateString, inputFormatter);
            LocalDate newDate = date.plusDays(10);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            System.out.println("Новая дата: " + newDate.format(outputFormatter));
        } catch (DateTimeParseException e) {
             System.out.println("Ошибка при парсинге даты, проверьте формат.");
        }
    }

    // 8. Конвертация между часовыми поясами
    public static void convertTimeZone(LocalDateTime dateTime, ZoneId fromZone, ZoneId toZone) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, fromZone);
        ZonedDateTime convertedDateTime = zonedDateTime.withZoneSameInstant(toZone);
        System.out.println("Из " + fromZone + " в " + toZone + ": " + convertedDateTime.toLocalDateTime());
    }


    // 9. Вычисление возраста по дате рождения
    public static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

     // 10. Создание календаря на месяц
    public static void printCalendar(int month, int year) {
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());

        System.out.println("Календарь на " + firstDayOfMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()) + " " + year);
        System.out.println("--------------------");

        for(LocalDate date = firstDayOfMonth; !date.isAfter(lastDayOfMonth); date = date.plusDays(1)) {
            System.out.print(date.getDayOfMonth() + " ");
            if(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.print("(выходной) ");
            } else {
                System.out.print("(рабочий) ");
            }
            System.out.println();
        }

        System.out.println("--------------------");
    }

    // 11. Генерация случайной даты в диапазоне
    public static LocalDate generateRandomDate(LocalDate startDate, LocalDate endDate) {
        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();
        long randomEpochDay = startEpochDay + new Random().nextLong(endEpochDay - startEpochDay + 1);
        return LocalDate.ofEpochDay(randomEpochDay);
    }

    // 12. Расчет времени до заданной даты
    public static void calculateTimeToEvent(LocalDateTime eventDateTime) {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, eventDateTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();

        System.out.println("Времени до события: " + hours + " ч " + minutes + " мин " + seconds + " сек");
    }

    // 13. Вычисление количества рабочих часов
     public static long calculateWorkingHours(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        return duration.toHours();
    }


    // 14. Конвертация даты в строку с учетом локали
    public static void formatDateWithLocale(LocalDate date, Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", locale);
        System.out.println("Дата в формате " + locale + ": " + date.format(formatter));
    }

    // 15. Определение дня недели по дате
      public static String getDayOfWeekName(LocalDate date) {
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru"));
    }

    private static LocalDate readDate(String prompt) {
        while(true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Пожалуйста, введите дату в формате dd-MM-yyyy.");
            }
        }
    }
    
    private static LocalDateTime readDateTime(String prompt) {
       while(true) {
           System.out.print(prompt);
           String input = scanner.nextLine();
           try {
               return LocalDateTime.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
           } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты/времени. Пожалуйста, введите дату и время в формате dd-MM-yyyy HH:mm.");
           }
       }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                 System.out.println("Неверный формат числа. Пожалуйста, введите целое число.");
            }
        }
    }


    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
