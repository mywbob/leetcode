/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/


public class Solution {
    //need set to reduce dup
    //for i to n, i+i to n case
    //but be carefull who add 1
    HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ares = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        dfs(0, 0, target, res,ares, candidates);
        return res;
    }
    
    public void dfs(int index, int sum, int target, List<List<Integer>> res, List<Integer> ares, int[] candidates) {
        if (sum == target) {
            //set.add(new ArrayList<Integer>(ares));
           
            if (!set.contains(ares)) {
                res.add(new ArrayList<Integer>(ares));
                set.add(new ArrayList<Integer>(ares));
            } 

            return;
            
        }
        if (sum > target) return;
        
        for (int i=index; i<candidates.length; i++) {
            ares.add(candidates[i]);
            dfs(i+1, sum + candidates[i], target, res, ares, candidates);
            ares.remove(ares.size() - 1);
        }
    }
}