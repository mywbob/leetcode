/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/


public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res  = new ArrayList<List<Integer>>();
        if (numRows == 0) return res;
        
        for (int i=0; i<numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j=0; j<=i; j++) {
                if (j==0 || j== i) {
                    temp.add(1);
                } else {
                    temp.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            
            res.add(temp);
        }
        
        return res;
    }
}