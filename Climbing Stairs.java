public class Solution {
    //bf n^2
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n-2) + climbStairs(n-1);
    }

	//dp, or recursive and cache
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (map.containsKey(n)) return map.get(n);
        else {
            int n_2 = climbStairs(n-2);
            int n_1 = climbStairs(n-1);
            map.put(n, n_1 + n_2);
        }
        
        return map.get(n);
    }
    
}