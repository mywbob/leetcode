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
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> alist = new ArrayList<Integer>();
        if (numRows == 0) return list;
        alist.add(1);
        list.add(alist);
        for (int i=1; i<numRows;i++) {
            alist = new ArrayList<Integer>();
            for (int j=0; j<=i; j++) {
                if (j==0 || j==i) alist.add(1);
                else {
                    alist.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
            }
            list.add(alist);
        }
        
        
        return list;
    }
}