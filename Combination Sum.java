/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

/*
    //1 input no dup
    //2 not for 0 to n, for 0 to n case!, eg, first for 1, second for cannot be 0
    //3 for i to n, for i to n case!
*/

public class Solution {
    public List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> ares = new ArrayList<Integer>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target);
        return res;
    }
    
    public void dfs(int[] candidates, int i, int sum, int target) {
        if (sum == target) {
            //add a res
            res.add(new ArrayList<Integer>(ares));
            //ares.remove(ares.size() - 1);
            return;
        }
        
        if (sum > target) {//
            return;
        }

        for (int index = i; index < candidates.length ; index++) {
            ares.add(candidates[index]);
            dfs(candidates, index, sum + candidates[index], target);
            ares.remove(ares.size() - 1);
        }
    }
}