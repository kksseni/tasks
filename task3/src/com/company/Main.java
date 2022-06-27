package com.company;

import java.math.BigInteger;
//This program counts the number of digits in the number 100!
public class Main {

    public static void main(String[] args) {
     int sum = 0;
     String str = String.valueOf(getFactorial(100));
        //Split the number into strings by one digit
         String[] num = str.split("");
         for(int j = 0; j < num.length; j++){
            sum+= Integer.valueOf(num[j]);
         }
        System.out.print(sum);
    }
    //Computes the factorial of large numbers using the BigInteger class, and
    // its multiply method, which returns the multiplication  of two numbers.
    public static BigInteger getFactorial(int f) {
        if (f <= 1) {
            return BigInteger.valueOf(1);
        }
        else {
            return BigInteger.valueOf(f).multiply(getFactorial(f - 1));
        }
    }
}
