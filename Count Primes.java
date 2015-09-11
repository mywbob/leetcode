/*
Description:

Count the number of prime numbers less than a non-negative number, n.
*/

public class Solution {
	public int countPrimes(int n) {
        int cnt=0;
        for (int i=1; i<n; i= i+2) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        if (n>2) cnt++;//care
        return cnt;
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n==2 || n==3) return true;
        if (n % 2 == 0) return false;
        for (int i=3; i*i <=n; i= i+2) {//care
            if (n % i == 0) return false;
        }
        return true;
    }
	
	//old
	//bf. find prime. 1) to sqrt(n), 2)skip even number
    //mark off alg. space o(n), time do not know
    public int countPrimes(int n) {
        int cnt = 0;
        for (int i = 1; i<n; i=i+2) {
            if (isPrime(i)) cnt++;
        }
        if (n>2) cnt++;
        return cnt;
    }
    
    public boolean isPrime(int num) {
        if (num == 1) return false;
        if (num == 2) return true;
        if (num % 2== 0) return false;
        for (int i=3; i*i<=num;i=i+2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}