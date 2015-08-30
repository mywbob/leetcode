/*
Given an array of integers and an integer k, find out whether there there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
*/


public class Solution {
	HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
                else map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
	
	
	
	//old
    //o(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
                else map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
    
    
    //o(nk) 
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i=0; i<nums.length; i++) {
            for (int j=1; j<=k; j++) {
                if (i+j < nums.length && nums[i] == nums[i+j]) return true;
            }
        }
        return false;
    }
}