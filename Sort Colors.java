/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
*/




public class Solution {
	//just do not forget count sort
    public void sortColors(int[] nums) {
        int red =0;
        int blue = nums.length-1;
        for (int i=0; i<nums.length && red<nums.length && blue>=0; i++) {
            if (nums[i]==0) {
                if (red<=i) {//important!
                    int temp;
                    temp = nums[i];
                    nums[i] = nums[red];
                    nums[red] = temp;
                    red++;
                    i--;
                }
                
            } else if (nums[i] == 2) {
                if (blue >= i) {
                    int temp;
                    temp = nums[i];
                    nums[i] = nums[blue];
                    nums[blue] = temp;
                    blue--;
                    i--;
                }
            } else {
                
            }
        }
    }
	
	
	//old
    public void sortColors(int[] A) {
        //1: count 0,1,2
        //2: swap and record red and blue index, but i cannot solve this in short time
        int redi = 0;
        int bluei = A.length - 1;
        for (int i=0; i< A.length && redi < A.length && bluei>= 0; i++) {
            if (A[i]==0) {
                if (redi <= i) {
                    int temp = A[redi];
                    A[redi] = A[i];
                    A[i] = temp;
                    redi++;
                    i--;
                }
            } 
            else if (A[i]==2) {
                if (bluei >= i) {
                    int temp1 = A[bluei];
                    A[bluei] = A[i];
                    A[i] = temp1;
                    i--;
                    bluei--;
                }
            }
            else {
                //skip
            }
        }
    }
}