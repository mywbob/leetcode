/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

public class Solution {
    //1： sort
    //2: heap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(k);
        
        for (int i=0; i<k; i++) {
            minheap.add(nums[i]);
        }
        
        for (int i=k; i<nums.length; i++) {
            minheap.add(nums[i]);
            minheap.poll();
        }
        
        return minheap.peek();
    }
}