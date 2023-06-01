package com.dver.main;

public class Complex {
    private double a;
    private double b;
    public double getA (){
        return a;
    }
    public double getB () {
        return b;
    }
    Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }
    public Complex Plus (Complex second) {
        return new Complex(this.a + second.a, this.b + second.b);
    }
    public Complex Multiply(Complex second) {
        return new Complex(this.a * second.a - this.b * second.b, this.a * second.b - this.b * second.a);
    }
    public Complex Sub (Complex second) {
        return new Complex(this.a - second.a, this.b - second.b);
    }
    @Override
    public String toString() {
        if (b < 0) {
            return a + " - " + Math.abs(b) + "i";
        } else {
            return a + " + " + b + "i";
        }
    }
}
