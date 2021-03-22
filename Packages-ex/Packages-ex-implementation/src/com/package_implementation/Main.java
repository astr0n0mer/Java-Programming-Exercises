package com.package_implementation;

import com.mypackage.Series;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++)
            System.out.println("nSum(" + i + ") = " + Series.nSum(i));

        for (int i = 0; i < 11; i++)
            System.out.println("factorial(" + i + ") = " + Series.factorial(i));

        for (int i = 0; i < 11; i++)
            System.out.println("fibonacci(" + i + ") = " + Series.fibonacci(i));

    }
}
