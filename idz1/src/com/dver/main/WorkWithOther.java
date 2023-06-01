package com.dver.main;

import java.util.Scanner;

public class WorkWithOther {
    public Matrix InputMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размеры матрицы через пробел");
        String[] strings = scanner.nextLine().split(" ");
        int n = Integer.parseInt(strings[0]), m = Integer.parseInt(strings[1]);
        Complex[][] matrix = new Complex[n][m];
        System.out.println("Введите матрицу, где каждое число будет состоять из 2 чисел через запятую " +
                "например 1,0 (то есть вещественная часть и комплексная), а сами числа в строке разделены пробелами");
        for (int i = 0; i < n; i++) {
            strings = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = ParseComplex(strings[j]);
            }
        }
        return new Matrix(matrix);
    }
    public Complex InputComplex() {
        System.out.println("Введите комплексное число где части будут разделены запятой");
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(",");
        double a = Double.parseDouble(strings[0]), b = Double.parseDouble(strings[1]);
        return new Complex(a, b);
    }
    private static Complex ParseComplex(String s) {
        String[] strings = s.split(",");
        double a = Double.parseDouble(strings[0]), b = Double.parseDouble(strings[1]);
        return new Complex(a, b);
    }
}
