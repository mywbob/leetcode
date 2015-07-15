/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/




public class Solution {
    //1 bf, o(n*n)
    //2 trans to maxsubarray, o(n)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[] changes = new int[prices.length-1];
        for (int i=0; i< changes.length;i++) {
            changes[i] = prices[i+1] - prices[i];
        }
        
        int max = 0;
        int sum = 0;
        for (int i=0; i< changes.length; i++) {
            if (sum + changes[i] < 0) {
                sum = 0;
            } else {
                sum = sum + changes[i];
            }
            max = Math.max(max, sum);
        }
        
        return max;
        
    }
}