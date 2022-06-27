package com.company;

import java.util.Scanner;
//This program counts the number of correct bracket expressions
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Input a number of (): ");
            int n = in.nextInt();
            System.out.println(find_sum(n));
        }
    }

    //Denote by S(n) the number of correct bracket expressions with 2n brackets.
    // Then the number of elementary bracket expressions with 2n brackets is S(n-1).
    // Thus S(n)=(S(i-1)*S(n-i)).
    private static int find_sum(int n) {
        int sum = 0;
        if (n <= 0) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            sum += find_sum(i - 1) * find_sum(n - i);
        }
        return sum;
    }
}
