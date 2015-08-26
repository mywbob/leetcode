/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/


/*
idea:
Start by evaluating the widest container, using the first and the last line. All other possible containers are less wide, so to hold more water, they need to be higher. Thus, after evaluating that widest container, skip lines at both ends that don't support a higher height. Then evaluate that new container we arrived at. Repeat until there are no more possible containers left.
*/


public class Solution {
	public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int max = 0;
        while(start < end) {
            max = Math.max(max, (end-start) * Math.min(height[start], height[end]));
            if (height[start] < height[end]) {//equal, randomly pick one, why, this problem is hard to prove, like gas station...so just remember it
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
	
	//old
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            max = Math.max(max, (end - start) * Math.min(height[start], height[end]));
            if (height[start] <= height[end]) start++;
            else end--;
        }
        return max;
        
    }
}