package com.dver.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        String s;
        do {
            System.out.println("Введите 1 чтобы поработать с комплексными числами, введите 2 чтобы поработать с матрицами");
            s = scanner.nextLine();
            if (s != null && s.equals("1")) {
                workWithComplex();
            } else if (s != null && s.equals("2")){
                workWithMatrix();
            } else {
                System.out.println("Вы ввели что-то не то");
            }
            System.out.println("Введите 0 чтобы завершить программу, иначе введите любой другой символ");
            s = scanner.nextLine();
            if (s != null && s.equals("0"))
                flag = false;
        } while (flag);
    }

    public static void workWithComplex() {
        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.println("Введите 1 чтобы сложить два комплексных числа");
        System.out.println("Введите 2 чтобы умножить два комплексных числа");
        s = scanner.nextLine();
        WorkWithOther work = new WorkWithOther();
        if (s != null && s.equals("1")) {
            Complex first = work.InputComplex();
            Complex second = work.InputComplex();
            Complex res = first.Plus(second);
            System.out.println("Ваш результат");
            System.out.println(res);
        } else if (s != null && s.equals("2")) {
            Complex first = work.InputComplex();
            Complex second = work.InputComplex();
            Complex res = first.Multiply(second);
            System.out.println("Ваш результат");
            System.out.println(res);
        } else {
            System.out.println("Вы ввели что-то не то");
        }
    }
    public static void workWithMatrix() {
        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.println("Введите 1 чтобы сложить две матрицы");
        System.out.println("Введите 2 чтобы умножить две матрицы");
        System.out.println("Введите 3 чтобы найти определитель");
        System.out.println("Введите 4 чтобы транспонировать матрицу");
        s = scanner.nextLine();
        WorkWithOther work = new WorkWithOther();
        if (s != null && s.equals("1")) {
            Matrix first = work.InputMatrix();
            Matrix second = work.InputMatrix();
            Matrix res = first.Plus(second);
            System.out.println("Ваш результат");
            System.out.println(res);
        } else  if (s != null && s.equals("2")) {
            Matrix first = work.InputMatrix();
            Matrix second = work.InputMatrix();
            Matrix res = first.Multiply(second);
            System.out.println("Ваш результат");
            System.out.println(res);
        } else  if (s != null && s.equals("3")) {
            Matrix first = work.InputMatrix();
            Complex res = first.Determinant();
            System.out.println("Ваш результат");
            System.out.println(res);
        } if (s != null && s.equals("4")) {
            Matrix first = work.InputMatrix();
            Matrix res = first.Transpose();
            System.out.println("Ваш результат");
            System.out.println(res);
        } else {
            System.out.println("Вы ввели что-то не то");
        }
    }
}
