/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/



public class Solution {
/*
key thing, we have unique solution
http://fisherlei.blogspot.com/2013/11/leetcode-gas-station-solution.html
have a diff = gas[i] - cost[i], if sum of diff > 0, we have solution
where is the solution?
say solution is i => sum(0,i) must < 0 and sum(i, n) must > 0 
*/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diff = 0;
        int startPoint = 0;
        int cursum = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            cursum += gas[i] -cost[i];
            total += gas[i] -cost[i];
            if (cursum < 0) {//sp can not before or at i
                cursum = 0;
                startPoint = i+1; 
            }
        }
        
        return total>=0? startPoint : -1;
        
    }
    
    
    /*
    //tle, o(n2)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] detla = new int[gas.length];
        for (int i=0; i<detla.length;i++) {
            detla[i] = gas[i] - cost[i];
        }
        int left = 0;
        for (int i=0; i<gas.length; i++) {
            //start from i
            left = left + detla[i];
            if (left < 0) {//cannot make it
                left = 0;
                continue;
            } else {
                //try if can go through all 
                int start = i;
                int j;
                for (j = (i+1) % detla.length; j != start ;j = (j+1) % detla.length) {
                    left = left + detla[j];
                    if (left < 0) {//cannot make it
                        left = 0;
                        break;
                    }
                }
                if (j == start) return j;
                
            }
        }
        return -1;
        
    }
    */
}





