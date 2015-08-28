/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
/*
combination idea
*/


public class Solution {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList<Integer>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        for (int i=1; i<=nums.length; i++) {
            combine(i, 0, nums);
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
    
    public void combine(int k, int j, int[] nums) {
        if (temp.size() == k) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for (int i= j; i<nums.length; i++) {
            temp.add(nums[i]);
            combine(k, i+1, nums);
            temp.remove(temp.size() - 1);
        }
    }
	
	
	
	
	
	//old
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        for (int i=1; i<= nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            List<Integer> atemp = new ArrayList<Integer>();
            res.addAll(combine(0, i, nums, temp, atemp));
        }
        return res;
    }
    
    public List<List<Integer>> combine(int k, int n, int[] nums, List<List<Integer>> temp, List<Integer> atemp) {
        dfs(k, n, nums, temp, atemp);
        return temp;
    }
    
    public void dfs (int k, int n, int[] nums, List<List<Integer>> temp, List<Integer> atemp) {
        if (atemp.size() == n) {
            temp.add(new ArrayList<Integer>(atemp));
            return;
        }
        
        for (int i= k; i<nums.length; i++) {
            atemp.add(nums[i]);
            dfs(i+1, n, nums, temp, atemp);
            atemp.remove(atemp.size() - 1);
            
        }
    }
}