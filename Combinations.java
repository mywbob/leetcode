/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/


public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> ares = new ArrayList<Integer>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,k,n);
        return res;
    }
    
    public void dfs(int index, int k, int n) {
        if (ares.size() == k) {
            res.add(new ArrayList<Integer>(ares));
            return;
        }
        
        for (int i=index; i<=n; i++) {
            ares.add(i);
            dfs(i+1, k, n);
            ares.remove(ares.size()-1);
        }
        
    }
}