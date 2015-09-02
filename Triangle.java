/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/


public class Solution {
    //dp, build a triangle table, or only use o(n), update each row from back
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(triangle.get(0).get(0));
        
        for (int i=1; i<triangle.size(); i++) {
            row.add(row.get(i-1) + triangle.get(i).get(triangle.get(i).size()-1));
            for (int j= triangle.get(i).size()-2; j>=0; j--) {
                if (j==0) {
                    row.set(0, triangle.get(i).get(0) + row.get(0));
                } else {
                    row.set(j, triangle.get(i).get(j) + Math.min(row.get(j), row.get(j-1)));
                }
            }
        }
        
        int minval = Integer.MAX_VALUE;
        for (int i : row) {
            minval = Math.min(minval, i);
        }
        
        return minval;
        
    }
}