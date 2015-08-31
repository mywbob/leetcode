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
    Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList<Integer>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, k, n);
        return res;
    }
    
    public void dfs(int index, int k, int n) {
        if (temp.size()==k && n==0) {
            if (!set.contains(temp)) {
                res.add(new ArrayList<Integer>(temp));
                set.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (temp.size()>k) return;
        
        for (int i=index; i<=9; i++) {
            temp.add(i);
            dfs(i+1, k, n-i);
            temp.remove(temp.size()-1);
        }
    } 
}