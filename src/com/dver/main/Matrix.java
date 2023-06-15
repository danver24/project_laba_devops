package com.dver.main;


import java.util.Scanner;

public class Matrix {
    private Complex[][] complexArray;

    public Matrix(int n, int m) {
        this.complexArray = new Complex[n][m];
    }

    public Matrix(Complex[][] complexArray) {
        this.complexArray = complexArray;
    }

    public Matrix(Matrix other) {
        this.complexArray = other.complexArray;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < complexArray.length; i++) {
            for (int j = 0; j < complexArray[i].length; j++) {
                res = res + complexArray[i][j] + " ";
            }
            res = res + "\n";
        }
        return res;
    }
    public Matrix Plus(Matrix second) {
        Complex[][] res = new Complex[this.complexArray.length][second.complexArray[0].length];
        for (int i = 0; i < this.complexArray.length; i++) {
            for (int j = 0; j < this.complexArray[i].length; j++) {
                res[i][j] = this.complexArray[i][j].Plus(second.complexArray[i][j]);
            }
        }
        return new Matrix(res);
    }

    public Matrix Multiply(Matrix second) {
        if (this.complexArray[0].length != second.complexArray.length) {
            System.out.println("Умножение невозможно, неправильные размеры матриц");
            return new Matrix(0, 0);
        }
        Complex[][] result = new Complex[this.complexArray.length][second.complexArray[0].length];
        for (int i = 0; i < result.length; ++i) {
            for (int j = 0; j < result[i].length; ++j) {
                result[i][j] = new Complex(0, 0);
                for (int k = 0; k < this.complexArray[0].length; ++k) {
                    result[i][j] = result[i][j].Plus(this.complexArray[i][k].Multiply(second.complexArray[k][j]));
                }
            }
        }
        return new Matrix(result);
    }

    public Matrix Transpose() {
        Complex[][] res = new Complex[this.complexArray.length][this.complexArray[0].length];
        for (int i = 0; i < this.complexArray.length; i++) {
            for (int j = 0; j < this.complexArray[i].length; j++) {
                res[i][j] = this.complexArray[j][i];
            }
        }
        return new Matrix(res);
    }
    private void CreateNewMatrixForDeterminat(Complex[][] arrMatrix, Complex[][] determinant, int column, int n)
    {
        for (int i = 1; i < n; i++)
        {
            int flag = 0;
            for (int j = 0; j < n; j++)
                if (j == column)
                    flag = 1;
                else
                    determinant[i - 1][j - flag] = arrMatrix[i][j];
        }
    }
    public Complex Determinant() {
        if (this.complexArray[0].length != this.complexArray.length) {
            System.out.println("Нахождения определителя невозможно, неправильные размеры матриц");
            return new Complex(0, 0);
        }
        Complex determinant = new Complex(0, 0);
        if (this.complexArray.length > 2) {
            for (int i = 0; i < this.complexArray.length; i++) {
                Complex[][] newMatrix = new Complex[this.complexArray.length - 1] [this.complexArray.length -1];
                CreateNewMatrixForDeterminat(this.complexArray, newMatrix, i, this.complexArray.length);
                if (i % 2 != 0)
                    determinant = determinant.Sub(this.complexArray[0][i].Multiply(new Matrix(newMatrix).Determinant()));
                    else
                determinant = this.complexArray[0][i].Plus(new Matrix(newMatrix).Determinant());
            }
            return determinant;
        }
        if (this.complexArray.length == 1)
            return this.complexArray[0][0];
        return this.complexArray[0][0].Multiply(this.complexArray[1][1]).Sub(this.complexArray[0][1].Multiply(this.complexArray[1][0]));
    }
}
