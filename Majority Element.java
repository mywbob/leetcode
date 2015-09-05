/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class Solution {
	public int majorityElement(int[] nums) {
        int major = nums[0];
        int cnt = 1;
        for (int i=1; i<nums.length; i++) {
            if (major == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
            if(cnt<=0) {
                major = nums[i+1];
                cnt = 1;
                i = i+1;
            }
        }
        return major;
    }
	
	
	//old
    //1:easy count, o(n) space, o(n) time
    //2:bf, o(n*n)
    //3:o(logn), sort, the mid must be the res
    //4:bit, find the majority of each bit, then build the result bit by bit
    //5:dvide and conquer, hard, do not know the running time.
    //6: moore's voting alg. o(n) time, Basic idea of the algorithm is if we cancel out each occurrence of an element e with all the other elements that are different from e then e will exist till end if it is a majority element.
    public int majorityElement(int[] nums) {//moore's voting
        int count=0;
        int cand=0;
        for(int i=0;i<nums.length;i++)
        {
            if(count==0) {
                cand=nums[i];
            }
            
            if(nums[i]==cand) {
                count++;
            } else {
                count--;
            }
        }
        return cand;
    }
}