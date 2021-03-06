/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

public class Solution {
    //too easy
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1;
        int index2 = n-1;
        int cur = m+n-1;
        while (index1>=0 && index2>=0) {
            if (nums1[index1] < nums2[index2]) {
                nums1[cur--] = nums2[index2--];
            } else {
                nums1[cur--] = nums1[index1--];
            }
        }
        
        while (index2>=0) {
            nums1[cur--] = nums2[index2--];  
        }
        
    }
}