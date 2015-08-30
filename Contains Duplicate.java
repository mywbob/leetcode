/*
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
*/


public class Solution {
	HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
    public boolean containsDuplicate(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        for (Integer i : map.keySet()) {
            if (map.get(i)>1) {
                return true;
            }
        }
        
        return false;
    }
	
    //set o(1) time, o(n) space
    //for loops, o(n^2) time
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}