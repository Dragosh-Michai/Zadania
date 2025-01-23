import kotlin.math.sqrt

// 1. Функция для нахождения максимума
fun findMax(a: Int, b: Int): Int {
    if (a == b) {
        //Можно вернуть a, а можно и выбросить исключение
        return a
        //throw IllegalArgumentException("Числа равны, невозможно определить максимум.")
    }
    return if (a > b) a else b
}

// 2. Калькулятор деления
fun divide(a: Double, b: Double): Double {
    if (b == 0.0) {
        throw ArithmeticException("Деление на ноль недопустимо.")
    }
    return a / b
}

// 3. Конвертер строк в числа
fun stringToInt(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw NumberFormatException("Строка не может быть сконвертирована в целое число.")
    }
}

// 4. Проверка возраста
fun validateAge(age: Int) {
    if (age < 0 || age > 150) {
        throw IllegalArgumentException("Недопустимый возраст. Возраст должен быть в диапазоне от 0 до 150.")
    }
}

// 5. Нахождение корня
fun findSquareRoot(number: Double): Double {
    if (number < 0) {
        throw IllegalArgumentException("Нельзя извлекать корень из отрицательного числа.")
    }
    return sqrt(number)
}

// 6. Факториал
fun factorial(n: Int): Long {
    if (n < 0) {
        throw IllegalArgumentException("Факториал определен только для неотрицательных чисел.")
    }
    if (n == 0) {
        return 1
    }
    var result: Long = 1
    for (i in 1..n) {
        result *= i
    }
    return result
}

// 7. Проверка массива на нули
fun checkArrayForZeros(arr: IntArray) {
    if (arr.contains(0)) {
        throw IllegalArgumentException("Массив содержит нули.")
    }
}

// 8. Калькулятор возведения в степень
fun power(base: Double, exponent: Int): Double {
    if (exponent < 0) {
        throw IllegalArgumentException("Степень должна быть неотрицательной.")
    }
    if (exponent == 0) {
        return 1.0
    }

    var result = 1.0
    for (i in 1..exponent) {
        result *= base
    }
    return result

    // Или, если нужно использовать Math.pow:
    // return Math.pow(base, exponent.toDouble())
}

// 9. Обрезка строки
fun truncateString(str: String, numChars: Int): String {
    if (numChars > str.length) {
        throw IllegalArgumentException("Number of characters exceeds string length.")
    }
    return str.substring(0, numChars)
}

// 10. Поиск элемента в массиве
fun findElementInArray(arr: IntArray, element: Int): Int {
    val index = arr.indexOf(element)
    if (index == -1) {
        throw IllegalArgumentException("Element $element not found in the array.")
    }
    return index
}


fun main() {
    // Примеры использования.
    try {
        println("Max of 5 and 3: ${findMax(5, 3)}")
        println("Max of 0 and 0: ${findMax(0, 0)}")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    try {
        println("5 / 2 = ${divide(5.0, 2.0)}")
        divide(10.0,0.0)
    } catch (e: ArithmeticException) {
        println("Error: ${e.message}")
    }

    try {
        println("String to int: ${stringToInt("123")}")
        stringToInt("abc")
    } catch (e: NumberFormatException) {
        println("Error: ${e.message}")
    }

    try {
        validateAge(30)
        println("Age is valid")
        validateAge(-1)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    try {
        println("Square root of 9: ${findSquareRoot(9.0)}")
        findSquareRoot(-4.0)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    try {
        println("Factorial of 5: ${factorial(5)}")
        println("Factorial of 0: ${factorial(0)}")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    try {
        checkArrayForZeros(intArrayOf(1, 2, 3))
        println("Array does not contain zeros")
        checkArrayForZeros(intArrayOf(1,2,0,4))
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    try {
        println("2 to the power of 3: ${power(2.0, 3)}")
        println("2 to the power of 0: ${power(2.0, 0)}")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    try {
        println("Truncated string: ${truncateString("Hello World", 5)}")
        truncateString("Hello",10)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    try {
        println("Index of 3 in array: ${findElementInArray(intArrayOf(1, 2, 3, 4, 5), 3)}")
        findElementInArray(intArrayOf(1,2,3),4)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
