package org.example;

public class Complex {
    private final double real;
    private final double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(Complex other) {
        this.real = other.real;
        this.imaginary = other.imaginary;
    }

    public Complex add(Complex other) {
        return new Complex(
                this.real + other.real,
                this.imaginary + other.imaginary
        );
    }

    public Complex sub(Complex other) {
        return new Complex(
                this.real - other.real,
                this.imaginary - other.imaginary
        );
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Complex other = (Complex) obj;
        return Double.compare(real, other.real) == 0
                && Double.compare(imaginary, other.imaginary) == 0;
    }
}
class TestComplex {


    public static void main(String[] args) {
        Complex a = new Complex(1.33, 4.64);
        Complex b = new Complex(3.18, 2.74);
        Complex c = a.add(b);

        Complex[] arrayC = {a, b, c};

        System.out.println("c=a+b= " + c.getReal() + " " + c.getImaginary());

        Complex d = c.sub(a);
        System.out.println("d=c-a= " + d.getReal() + " " + d.getImaginary());

        System.out.println(d);

        Complex e = new Complex(d);

        System.out.println(searchForComplex(arrayC, e));

        replaceComplex(arrayC, c, e);
        displayArrayContent(arrayC);
    }

    static boolean searchForComplex(Complex[] arr, Complex target) {
        for (Complex c : arr) {
            if (c.equals(target)) {
                return true;
            }
        }
        return false;
    }

    static void replaceComplex(Complex[] arr, Complex oldValue, Complex newValue) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(oldValue)) {
                arr[i] = newValue;
            }
        }
    }

    static void displayArrayContent(Complex[] arr) {
        for (Complex c : arr) {
            System.out.println(c);
        }
    }
}
