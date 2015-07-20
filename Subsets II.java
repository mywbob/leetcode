public class Solution {
    HashSet<List<Integer>> set = new HashSet<List<Integer>>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
            if (!set.contains(atemp)) {
                temp.add(new ArrayList<Integer>(atemp));
                set.add(new ArrayList<Integer>(atemp));//set of list<integer> size and value equal
            }
            return;
        }
        
        for (int i= k; i<nums.length; i++) {
            atemp.add(nums[i]);
            dfs(i+1, n, nums, temp, atemp);
            atemp.remove(atemp.size() - 1);
            
        }
    }
}