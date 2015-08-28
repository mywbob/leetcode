/*
Implement pow(x, n).
*/



/*
public class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 1;
        if (x == 1) return 1;
        if (n == 0) return 1;
        double half = myPow(x, n/2);
        
        if (x >= 0 && n >= 0) {
            if (n % 2 == 0) return half*half;
            else return half*half*x;
        } else if (x>0 && n< 0) {
            if (n % 2 == 0) return half*half;
            else return half*half*(1/x);
        } else if (x<0 && n > 0) {
            if (n % 2 == 0) return half*half;
            else return half*half*x;
        } else {
            if (n % 2 == 0) return half*half;
            else return half*half*(1/x);
        }
    }
}
*/



public class Solution {
	public double myPow(double x, int n) {
        if (n == 0) return 1;
        double half = myPow(x, n/2);
        if (n % 2 == 0) {
            return half*half;
        } else {
            if (n<0) return half*half /x;
            else return half * half * x;
        }
        
    }
	
	//old
    public double myPow(double x, int n) {
        if (x == 0) return 1;
        if (x == 1) return 1;
        if (n == 0) return 1;
        double half = myPow(x, n/2);
        
        if ( n >= 0) {
            if (n % 2 == 0) return half*half;
            else return half*half*x;

        } else {
            if (n % 2 == 0) return half*half;
            else return half*half*(1/x);
        }
    }
}