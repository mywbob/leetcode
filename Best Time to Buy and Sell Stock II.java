/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/


public class Solution {
    //convert the array, add all positive numbers
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[] changes = new int[prices.length-1];
        for (int i=0; i< prices.length-1;  i++) {
            changes[i] = prices[i+1] - prices[i];
        } 
        int max = 0;
        for (int i=0; i< changes.length; i++) {
            if (changes[i] > 0) max = max + changes[i];
        }
        return max;
    }
}