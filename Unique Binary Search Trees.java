/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public class Solution {
    //1: figure out this: f(n) = f(0)f(n-1) + f(1)f(n-2) .... + f(n-1)f(0)
    //2: figure out implementation
    public int numTrees(int n) {
        int[] table = new int[n+1];
        table[0] = 1;
        table[1] = 1;
        for (int i=2; i<=n ;i++) {
            for (int j=0; j<i; j++) {
                table[i] = table[i] + table[j] * table[i-j-1];
            }
            
        }
        
        return table[n];
    }
}