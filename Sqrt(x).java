/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class Solution {
	
	//overflow
    //bs: number and array, treat number as array, 1,2,3,4,->[0,1,2,3,4] index == value 
    public int mySqrt(int x) {
        return bs(0, x, x);
    }
    
    public int bs(int s, int e, int target) {
        if (s > e) return -1;// not possible
        int mid = s + (e-s)/2;
        if (mid == 0) return target;//mid == 0?
        if (mid <= target / mid && (mid + 1) > target / (mid+1)) {
            return mid;
        } else if (mid > target / mid) {
            return bs(s, mid-1, target);
        } else {
            return bs(mid+1, e, target);
        }
    }
	
	
	//old
    //overflow! use divide
    public int mySqrt(int x) {
        if (x == 0) return 0;
        return bs(1, x, x);
    }
    
    public int bs(int s, int e, int n) {
        int mid = s + (e-s)/2;
        //what if s > e, there must be a value so not possible

        if (mid <= n /mid &&  (mid+1) > n / (mid+1)) return mid;
        else if ( mid < n / mid) {
            return bs(mid+1, e, n);
        } 
        else {
            return bs(s, mid-1, n);
        }
    }
}