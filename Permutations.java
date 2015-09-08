/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/



public class Solution {
	//slow
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ares = new ArrayList<Integer>();
        if (nums.length == 0) return res;
        ares.add(nums[0]);
        res.add(new ArrayList<Integer>(ares));
        for (int i=1; i<nums.length; i++) {//pick num
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for (int j=0; j<res.size(); j++) {//pick list
                for (int k=0; k<=res.get(j).size(); k++) {//pick pos
                    List<Integer> atemp = new ArrayList<Integer>(res.get(j));
                    atemp.add(k, nums[i]);
                    temp.add(atemp);
                }
                
            }
            res = temp;
        }
        
        return res;        
        
    }
	
	//old
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(nums[0]);//init
        res.add(temp);
        for (int i=1; i< nums.length; i++) {//pick a number
            List<List<Integer>> tempres = new ArrayList<List<Integer>>();
            for (int j=0; j<res.size(); j++) {//pick list from res
                for (int index=0; index<=res.get(j).size(); index++) {//pick a position
                    temp = new ArrayList<Integer>(res.get(j));
                    temp.add(index, nums[i]);
                    tempres.add(temp);
                }
            }
            //reset new res
            res = tempres;
            
        }
        return res;
    }
}