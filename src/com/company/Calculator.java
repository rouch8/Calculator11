package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("Ведите операнд. Пример: 1 + 1, I + I");
            String userInput = scanner.nextLine();
            char[] under_char = new char[20];
            // Определяем оператора
            for (int i = 0; i < userInput.length(); i++) {
                under_char[i] = userInput.charAt(i);
                if (under_char[i] == '+') {
                    operation = '+';
                }
                if (under_char[i] == '-') {
                    operation = '-';
                }
                if (under_char[i] == '*') {
                    operation = '*';
                }
                if (under_char[i] == '/') {
                    operation = '/';
                }
            }
            // определяем операнды
            String under_charString = String.valueOf(under_char);
            String[] blacks = under_charString.split(" ");
            String stable00 = blacks[0].trim();
            String stable01 = blacks[2].trim();
            checkSameType(stable00, stable01);
            // если римская система
            if (numberType(stable00).equals("roman") && numberType(stable01).equals("roman")) {
                number1 = Roman.toInt(stable00);
                number2 = Roman.toInt(stable01);
                if (number1 < 0 && number2 < 0) {
                    result = 0;
                } else {
                    try {
                        result = calc(number1, number2, operation);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String resultRoman = Roman.toRoman(result);
                    System.out.println(stable00 + " " + operation + " " + stable01 + " = " + resultRoman);
                }
            }
            // если арабская система
            if (numberType(stable00).equals("arabic") && numberType(stable01).equals("arabic")) {
                number1 = Arabic.toInt(stable00);
                number2 = Arabic.toInt(stable01);
                try {
                    result = calc(number1, number2, operation);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
            }
        }
    }
// Возвращает тип системы счисления
    public static String numberType(String num) throws Exception {
        if (Arabic.isArabic(num)) {
            return "arabic";
        }
        if (Roman.isRoman(num)) {
            return "roman";
        }
        throw new Exception("Error \"zero\"");
    }
    // проверка на тип операнда
    static void checkSameType(String n1, String n2) throws Exception {
        if (!numberType(n1).equals(numberType(n2))) {
            throw new Exception("Используются одновременно разные системы счисления");
        }
    }
    // основной метод для расчета
    public static int calc(int num1, int num2, char op) throws Exception {
        int result = 0;

        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new Exception("Не верный знак операции");
        }
        return result;
    }
}