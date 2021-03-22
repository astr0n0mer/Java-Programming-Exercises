// This class will be used later in the Main class of Packages-ex-implementation project as an imported library
package com.mypackage;

public class Series {
    public static long nSum(int n) {
        n = Math.abs(n);
        return ((long) n * (n + 1) / 2);
    }

    public static long factorial(int n) {
        if (n == 0 | n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static long fibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1 | n == 2) return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
