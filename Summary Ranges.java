/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/


public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums==null || nums.length==0) return res;
        for (int i=0; i< nums.length;) {
            //String temp=new String(nums[i]);
            String temp = Integer.toString(nums[i]);
            int next = i+1;
            int oldi = i;
            while (next < nums.length && nums[next] == nums[i]+1) {
                
                i = next;
                next = i+1;
            }
            if (oldi != i) {
                temp = temp + "->" + nums[i];
            }
            
            res.add(new String(temp));
            
            i = next;
        }
        return res;
    }
}