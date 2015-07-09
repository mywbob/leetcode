/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
*/

public class Solution {
    //k can be something > array length
    //1: o(n) space
    //2: o(1) space, reverse 3 times
    

    public void rotate1(int[] nums, int k) {
        int n=nums.length;
        int [] ret=new int [n];
        for(int i=0;i<n;i++) {
            ret[(i+k)%n]=nums[i];//cycle array key thing
        }
        for(int i=0;i<n;i++) {
            nums[i]=ret[i];
        }
    }
    
    public void rotate(int[] nums, int k) {
        
        k = k % nums.length;
        if (k == 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int nums[], int m, int n) {
        int temp;
        int index = 0;
        for (int i = m; i <= (m + n) / 2; i++) {
            temp = nums[i];
            nums[i] = nums[n - index];
            nums[n - index] = temp;
            index++;
        }
    }
}