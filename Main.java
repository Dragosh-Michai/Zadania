

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Задача 1: Четное или нечетное число
        System.out.println("Задача 1: Четное или нечетное число");
        System.out.print("Введите целое число: ");
        int num1 = scanner.nextInt();
        if (num1 % 2 == 0) {
            System.out.println("Число четное");
        } else {
            System.out.println("Число нечетное");
        }

        // Задача 2: Минимальное из трех чисел
        System.out.println("\nЗадача 2: Минимальное из трех чисел");
        System.out.print("Введите три целых числа через пробел: ");
        int num2_1 = scanner.nextInt();
        int num2_2 = scanner.nextInt();
        int num2_3 = scanner.nextInt();
        int minNum = Math.min(num2_1, Math.min(num2_2, num2_3));
        System.out.println("Минимальное число: " + minNum);

        // Задача 3: Таблица умножения на 5
        System.out.println("\nЗадача 3: Таблица умножения на 5");
        for (int i = 1; i <= 10; i++) {
            System.out.println("5 x " + i + " = " + (5 * i));
        }

        // Задача 4: Сумма чисел от 1 до N
        System.out.println("\nЗадача 4: Сумма чисел от 1 до N");
        System.out.print("Введите целое число N: ");
        int n4 = scanner.nextInt();
        int sum4 = 0;
        for (int i = 1; i <= n4; i++) {
            sum4 += i;
        }
        System.out.println("Сумма чисел от 1 до " + n4 + ": " + sum4);

        // Задача 5: Числа Фибоначчи
        System.out.println("\nЗадача 5: Числа Фибоначчи");
        System.out.print("Введите количество чисел Фибоначчи N: ");
        int n5 = scanner.nextInt();
        for (int i = 0; i < n5; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();

        // Задача 6: Проверка простого числа
        System.out.println("\nЗадача 6: Проверка простого числа");
        System.out.print("Введите целое число: ");
        int num6 = scanner.nextInt();
        if (isPrime(num6)) {
            System.out.println("Число простое");
        } else {
            System.out.println("Число не простое");
        }

        // Задача 7: Обратный порядок чисел
        System.out.println("\nЗадача 7: Обратный порядок чисел");
        System.out.print("Введите целое число N: ");
        int n7 = scanner.nextInt();
        for (int i = n7; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Задача 8: Сумма четных чисел
        System.out.println("\nЗадача 8: Сумма четных чисел");
        System.out.print("Введите два целых числа A и B через пробел: ");
        int a8 = scanner.nextInt();
        int b8 = scanner.nextInt();
        int sum8 = 0;
        for (int i = a8; i <= b8; i++) {
            if (i % 2 == 0) {
                sum8 += i;
            }
        }
        System.out.println("Сумма четных чисел в диапазоне от " + a8 + " до " + b8 + ": " + sum8);


        // Задача 9: Реверс строки
        System.out.println("\nЗадача 9: Реверс строки");
        System.out.print("Введите строку: ");
        scanner.nextLine(); // Consume newline
        String str9 = scanner.nextLine();
        System.out.println("Реверс строки: " + new StringBuilder(str9).reverse().toString());


        // Задача 10: Количество цифр в числе
        System.out.println("\nЗадача 10: Количество цифр в числе");
        System.out.print("Введите целое число: ");
        int num10 = scanner.nextInt();
        System.out.println("Количество цифр в числе: " + String.valueOf(Math.abs(num10)).length());

        // Задача 11: Факториал числа
        System.out.println("\nЗадача 11: Факториал числа");
        System.out.print("Введите целое число N: ");
        int n11 = scanner.nextInt();
        long factorial = calculateFactorial(n11);
        System.out.println("Факториал числа " + n11 + ": " + factorial);

        // Задача 12: Сумма цифр числа
        System.out.println("\nЗадача 12: Сумма цифр числа");
        System.out.print("Введите целое число: ");
        int num12 = scanner.nextInt();
        int sum12 = 0;
        int temp = Math.abs(num12);
        while (temp > 0) {
            sum12 += temp % 10;
            temp /= 10;
        }
        System.out.println("Сумма цифр числа: " + sum12);

        // Задача 13: Палиндром
        System.out.println("\nЗадача 13: Палиндром");
        System.out.print("Введите строку: ");
        scanner.nextLine(); // Consume newline
        String str13 = scanner.nextLine();
        if (isPalindrome(str13)) {
            System.out.println("Строка является палиндромом");
        } else {
            System.out.println("Строка не является палиндромом");
        }

        // Задача 14: Найти максимальное число в массиве
        System.out.println("\nЗадача 14: Найти максимальное число в массиве");
        System.out.print("Введите размер массива: ");
        int size14 = scanner.nextInt();
        int[] array14 = new int[size14];
        System.out.print("Введите элементы массива через пробел: ");
        for (int i = 0; i < size14; i++) {
            array14[i] = scanner.nextInt();
        }
        int max14 = findMax(array14);
        System.out.println("Максимальное число в массиве: " + max14);

        // Задача 15: Сумма всех элементов массива
        System.out.println("\nЗадача 15: Сумма всех элементов массива");
        System.out.print("Введите размер массива: ");
        int size15 = scanner.nextInt();
        int[] array15 = new int[size15];
        System.out.print("Введите элементы массива через пробел: ");
        for (int i = 0; i < size15; i++) {
            array15[i] = scanner.nextInt();
        }
        int sum15 = sumArray(array15);
        System.out.println("Сумма всех элементов массива: " + sum15);

        // Задача 16: Количество положительных и отрицательных чисел
        System.out.println("\nЗадача 16: Количество положительных и отрицательных чисел");
        System.out.print("Введите размер массива: ");
        int size16 = scanner.nextInt();
        int[] array16 = new int[size16];
        System.out.print("Введите элементы массива через пробел: ");
        for (int i = 0; i < size16; i++) {
            array16[i] = scanner.nextInt();
        }
        int[] counts = countPosNeg(array16);
        System.out.println("Количество положительных чисел: " + counts[0]);
        System.out.println("Количество отрицательных чисел: " + counts[1]);


        // Задача 17: Простые числа в диапазоне
        System.out.println("\nЗадача 17: Простые числа в диапазоне");
        System.out.print("Введите два целых числа A и B через пробел: ");
        int a17 = scanner.nextInt();
        int b17 = scanner.nextInt();
        System.out.print("Простые числа в диапазоне от " + a17 + " до " + b17 + ": ");
        for (int i = a17; i <= b17; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();


        // Задача 18: Подсчет гласных и согласных в строке
        System.out.println("\nЗадача 18: Подсчет гласных и согласных в строке");
        System.out.print("Введите строку: ");
        scanner.nextLine(); // Consume newline
        String str18 = scanner.nextLine().toLowerCase();
        int[] vowelConsonantCount = countVowelsConsonants(str18);
        System.out.println("Количество гласных: " + vowelConsonantCount[0]);
        System.out.println("Количество согласных: " + vowelConsonantCount[1]);

        // Задача 19: Перестановка слов в строке
        System.out.println("\nЗадача 19: Перестановка слов в строке");
        System.out.print("Введите строку: ");
         String str19 = scanner.nextLine();
        String reversedWords = reverseWords(str19);
        System.out.println("Слова в обратном порядке: " + reversedWords);


         // Задача 20: Число Армстронга
        System.out.println("\nЗадача 20: Число Армстронга");
        System.out.print("Введите целое число: ");
        int num20 = scanner.nextInt();
        if (isArmstrong(num20)) {
            System.out.println("Число является числом Армстронга");
        } else {
            System.out.println("Число не является числом Армстронга");
        }
         scanner.close();
    }

     // Функция для вычисления числа Фибоначчи
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Функция для проверки, является ли число простым
     public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Функция для вычисления факториала числа
     public static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

     // Функция для проверки, является ли строка палиндромом
    public static boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversedStr = new StringBuilder(cleanStr).reverse().toString();
        return cleanStr.equals(reversedStr);
    }

    // Функция для поиска максимального числа в массиве
    public static int findMax(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Функция для вычисления суммы всех элементов массива
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

      // Функция для подсчета количества положительных и отрицательных чисел
    public static int[] countPosNeg(int[] arr) {
        int positiveCount = 0;
        int negativeCount = 0;
        for (int num : arr) {
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            }
        }
        return new int[]{positiveCount, negativeCount};
    }

      // Функция для подсчета гласных и согласных в строке
     public static int[] countVowelsConsonants(String str) {
        int vowels = 0;
        int consonants = 0;
        String strLower = str.toLowerCase();
        for (int i = 0; i < strLower.length(); i++) {
            char ch = strLower.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        return new int[]{vowels, consonants};
    }

      // Функция для перестановки слов в строке в обратном порядке
    public static String reverseWords(String str) {
          String[] words = str.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }
        return reversed.toString().trim();
    }


     // Функция для проверки, является ли число числом Армстронга
     public static boolean isArmstrong(int num) {
        String numStr = String.valueOf(num);
        int n = numStr.length();
        int sum = 0;
        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, n);
            temp /= 10;
        }
        return sum == num;
    }
}
