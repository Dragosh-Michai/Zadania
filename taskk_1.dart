import 'dart:io';
import 'dart:math';

void main() {
  print('Введите номер задачи: ');

  int task_number = int.parse(stdin.readLineSync()!);

  switch(task_number){
    case 1:
      task1();
      break;
    case 2:
      task2();
      break;
    case 3:
      task3();
      break;
    case 4:
      task4();
      break;
    case 5:
      task5();
      break;
    case 6:
      task6();
      break;
    case 7:
      task7();
      break;
    case 8:
      task8();
      break;
    case 9:
      task9();
      break;
    case 10:
      task10();
      break;
    case 11:
      task11();
      break;
    case 12:
      task12();
      break;
    case 13:
      task13();
      break;
    case 14:
      task14();
      break;
    case 15:
      task15();
      break;
    case 16:
      task16();
      break;
    case 17:
      task17();
      break;
    case 18:
      task18();
      break;
    case 19:
      task19();
      break;
    case 20:
      task20();
      break;
    default:
      print('Неверный номер задачи.');
  }
}

void task1(){
  print('Введите число: ');
  int number_1 = int.parse(stdin.readLineSync()!);

  if (number_1 % 2 == 0){
    print('Число четное!');
  }
  else{
    print('Число не четное!');
  }
}

void task2(){

  print('Введите число');
  int number_2 = int.parse(stdin.readLineSync()!);

  print('Введите число');
  int number_3 = int.parse(stdin.readLineSync()!);

  print('Введите число');
  int number_4 = int.parse(stdin.readLineSync()!);

  int min_number = number_2;
  if(number_3 < number_2) min_number = number_3;
  if(number_4 < number_3) min_number = number_4;

  print('Минимальное число: $min_number');
}

void task3(){
  for(int i = 1; i <=10; i++){
    int res = 5 * i;
    print('5 * $i = $res');
  }
}

void task4(){
  print('Введите число: ');
  int number_5 = int.parse(stdin.readLineSync()!);
  int res1 = 0;

  for(int i = 1; i <=number_5; i++){
    res1 += i;
  }
  print('Число: $res1');
}

void task5() {
  print('Введите число N: ');
  int n = int.parse(stdin.readLineSync()!);

  if (n < 1) {
    print('Число N должно быть больше или равно 1.');
    return;
  }

  List<int> fibonacciNumbers = fib(n);
  print('Первые $n чисел Фибоначчи: $fibonacciNumbers');
}

List<int> fib(int n) {
  List<int> arr = [0, 1];

  for (int i = 2; i < n; i++) {
    arr.add(arr[i - 1] + arr[i - 2]);
  }

  if (n == 1) {
    return [0];
  } else {
    return arr.sublist(0, n);
  }
}

void task6(){
  print('Введите число: ');
  int number_6 = int.parse(stdin.readLineSync()!);

  if (number_6 < 2) {
    print('Число не является простым!');
    return;
  }

  bool p = true;

  for(int i = 2; i <=sqrt(number_6).toInt(); i++){
    if(number_6 % i == 0){
      p = false;
      break;
    }
  }
  if(p){
    print('Число простое!');
  }
  else{
    print('Число не простое!');
  }
}

void task7(){
  print('Введите число: ');
  int number_7 = int.parse(stdin.readLineSync()!);

  for(int i = number_7 ; i >= 1; i--){
    print(i);
  }
}

void task8(){
  print('Введите число A: ');
  int number_8 = int.parse(stdin.readLineSync()!);

  print('Введите число B: ');
  int number_9 = int.parse(stdin.readLineSync()!);

  int sum1 = 0;

  for(int i = number_9; i > number_8; i--){
    if(i % 2 == 0){
      sum1 += i;
    }
  }
  print('Сумма всех четных чисел: $sum1');
}

void task9(){
  print('Введите строку: ');
  String str = stdin.readLineSync()!;

  String reversed = str.split('').reversed.join();

  print('Строка в обратном порядке: $reversed');
}

void task10(){
  print('Введите число: ');
  int number_10 = int.parse(stdin.readLineSync()!);

  int count1 = 0;
  int res2 = number_10.abs();

  if(number_10 == 0){
    print('Цифр в числе: 1');
    return;
  }

  while(res2 > 0){
    res2 ~/= 10;
    count1++;
  }
  print('Цифр в числе: $count1');
}

void task11(){
  print('Введите число: ');
  int number_11 = int.parse(stdin.readLineSync()!);

  int res3 = 1;

  for(int i = number_11; i > 0; i--){
    res3 = res3 * i;
  }
  print('Факториал = $res3');
}

void task12(){
  print('Введите число: ');
  int number_12 = int.parse(stdin.readLineSync()!);
  int sum2 = 0;

  while(number_12 > 0) {
    sum2 += number_12 % 10;
    number_12 ~/= 10;
  }
  print('Сумма цифр числа = $sum2');
}

void task13(){
  print('Введите строку: ');
  String str1 = stdin.readLineSync()!;
  bool palindrome = true;
  for(int i = 0; i < str1.length ~/2; i++){
    if(str1[i] != str1[str1.length - 1 - i]){
      palindrome = false;
      break;
    }
  }
  if(palindrome){
    print('Строка палиндром!');
  }
  else{
    print('Строка не палиндром!');
  }
}

void task14(){
  print('Введите размер массива:');
  int size1 = int.parse(stdin.readLineSync()!);
  int max1 = 0;

  List<int> arr1 = List.filled(size1, 0);

  for(int i = 0; i < arr1.length; i++){
    print('Элемент $i ');
    arr1[i] = int.parse(stdin.readLineSync()!);
  }

  for(int j = 0; j < arr1.length; j++ ){
    if(arr1[j] > max1){
      max1 = arr1[j];
    }
  }
  print('Максимально число: $max1');
}

void task15(){
  print('Введите размер массива: ');
  int size2 = int.parse(stdin.readLineSync()!);
  int sum = 0;

  List<int> arr2 = List.filled(size2, 0);

  for(int i = 0; i < arr2.length; i++){
    print('Элемент массива $i :');
    arr2[i] = int.parse(stdin.readLineSync()!);
  }

  for(int j = 0; j < arr2.length; j++){
    sum += arr2[j];
  }
  print('Сумма элемментов массива = $sum');
}

void task16(){
  print('Введите размер массива: ');
  int size = int.parse(stdin.readLineSync()!);
  int sum1 = 0;
  int sum2 = 0;

  List<int> arr = List.filled(size, 0);

  for(int i = 0; i < arr.length; i++){
    print('Элемент массива $i :');
    arr[i] = int.parse(stdin.readLineSync()!);
  }

  for(int j = 0; j < arr.length; j++){
    if (arr[j] > 0){
      sum1 += arr[j];
    }
    else{
      sum2 += arr[j];
    }
  }
  print('Сумма положительных элементов = $sum1');
  print('Сумма отрицательных элементов = $sum2');
}

bool isPrime(int number){
  if(number <= 1){
    return false;
  }
  for (int i = 2; i * i <= number; i++) {
    if (number % i == 0) return false;
  }
  return true;
}

void task17() {
  print('Введите число A: ');
  int a = int.parse(stdin.readLineSync()!);

  print('Введите число B: ');
  int b = int.parse(stdin.readLineSync()!);

  int c = 0;

  if (a > b){
    c = a;
    a = b;
    b = c;
  }

  print('Простые числа в диапазоне от $a до $b :');
  for(int i = a; i <= b; i++){
    if(isPrime(i)){
      print(i);
    }
  }
}

void task18(){
  print('Введите строку: ');
  String str = stdin.readLineSync()!.toLowerCase();


  Set<String> vowels = {'a', 'e', 'i', 'o', 'u', 'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};
  Set<String> consonants = {
    'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z',
    'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'
  };

  int count_1 = 0;
  int count_2 = 0;

  for (int i = 0; i < str.length; i++) {
    String char = str[i];
    if (vowels.contains(char)) {
      count_1++;
    }
    else if (consonants.contains(char)) {
      count_2++;
    }
  }

  print('Количество гласных: $count_1');
  print('Количество согласных: $count_2');
}

void task19(){
  print('Введите строку: ');
  String str = stdin.readLineSync()!;

  List<String> str_1 = str.split(" ");
  List<String> str_2 = str_1.reversed.toList();
  String str_3 = str_2.join(" ");

  print(str_3);
}

void task20(){
  print('Введрте число: ');
  int a = int.parse(stdin.readLineSync()!);

  int b = a;
  int count = 0;
  num sum_2 = 0;
  int res = a;

  while(b > 0) {
    count++;
    b ~/= 10;
  }

  while (a > 0){
    int sum_1 = 0;
    sum_1 = a % 10;
    a ~/= 10;
    num res_1 = 0;
    res_1 = pow(sum_1, count);
    sum_2 += res_1;

  }


  if(res == sum_2){
    print('Число является числом Амстронга');
  }
  else{
    print('Число не является числом Амстронга');
  }
}
