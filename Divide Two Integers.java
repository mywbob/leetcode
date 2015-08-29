public class Solution {
	public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        boolean isPos = false;
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) isPos = true;
        long dd = Math.abs((long)dividend);
        long dr = Math.abs((long)divisor);
        long res = 0;
        while (dd >= dr) {
            long temp = 1;
            long tempdr = dr;
            while (dd > (tempdr << 1)) {
                temp = temp << 1;
                tempdr = tempdr << 1;
            }
            dd = dd - tempdr;
            res = res + temp;
            
        }
        
        if (isPos) {
            if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else return (int)res;
        } else {
            if (-res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else return (int)(-res);
        }
    }
	
	
	
	
	
	//old
    public int divide(int dividend, int divisor) {
        long dd = Math.abs((long)(dividend));
        long dr = Math.abs((long)(divisor));
        if (dr == 0) return Integer.MAX_VALUE;
        if (dd == 0) return 0;
        if (dd < dr) return 0;

        
        
        long res = 0;
        while (dd >= dr) {
            long tempdr = dr;
            long tempres =1;
            
            while (dd > (tempdr << 1)) {
                tempdr = tempdr << 1;
                tempres = tempres << 1;
            }
            
            dd = dd - tempdr;
            res = res + tempres;
        }

        //sign
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else return (int)res;
        } else {
            if (res > Math.abs((long)Integer.MIN_VALUE)) return Integer.MIN_VALUE;
            else return (int)(-res);
            
        }
        
    }
}