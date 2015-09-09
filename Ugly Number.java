/*
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
*/

public class Solution {
	public boolean isUgly(int num) {
        if (num == 0) return false;
        while (num % 2 == 0) num = num / 2;
        while (num % 3 == 0) num = num / 3;
        while (num % 5 == 0) num = num / 5;
        
        return num == 1;
        
    }
	
	
	
	//old
    //1: bf, tle
    //2: keep divide 2,3,5 to get a new number. the new number must be an odd number. 2 cases: 1) new number is prime, return false. 2) new number is not a prime, then it must be the production of 2 odd numbers(the base factor 1,3,5,7,9 => 7 left). whatever still false... hard to prove..
    
    /*
    public boolean isUgly(int num) {
        if (num < 7) return true;
        for (int i = 7; i<= num; i++) {
            if (isPrime(i) && (num % i == 0)) return false;
        }
        
        return true;
    }
    
    public boolean isPrime(int i) {
        if (i == 1) return false;
        if (i == 2) return true;
        for (int j=3; j<= i; j++) {//to sqrt of i
            if (i % j == 0) return false;
        }
        return true;
    }
    */
    
    public boolean isUgly(int num) {
        if (num==0) return false;
        while (num % 2 ==0) num = num /2;
        while (num % 3 ==0) num = num /3;
        while (num % 5 ==0) num = num /5;
        if (num == 1) return true;
        return false;
    }
}