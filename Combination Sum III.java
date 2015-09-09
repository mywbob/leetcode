/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList<Integer>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0) return res;
        dfs(1, k, n, n);
        return res;
    }
    
    public void dfs(int index, int k, int sum, int n) {
        if (temp.size() == k && sum == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        if (sum < 0 || temp.size() > k) return;
        
        for (int i=index; i<=9; i++) {
            temp.add(i);
            dfs(i+1, k, sum-i, n);
            temp.remove(temp.size()-1);
        }
    } 
}