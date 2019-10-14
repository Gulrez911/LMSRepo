package com.test.programs;

public class Toulier {

    // Function to return GCD of a and b 
    static int gcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
        return gcd(b % a, a); 
    } 
  
    // A simple method to evaluate 
    // Euler Totient Function 
    static int phi(int n) 
    { 
        int result = 1; 
        for (int i = 2; i < n; i++) 
            if (gcd(i, n) == 1) 
                result++; 
        return result; 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        int n = 9999999; 
  
       // for (n = 1000; n <= 15000; n++) 
            System.out.println("phi(" + n + ") = " + phi(n)); 
    } 
}
