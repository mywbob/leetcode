/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/


public class Solution {
    //1: keep a prev and curr list o(2k) space
    //2: backward, one list
    public List<Integer> getRow(int rowIndex) {//very clean 
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<=rowIndex; i++) {
            list.add(1);//nice
            for (int j = i-1; j>0; j--) {
                list.set(j, list.get(j) + list.get(j-1));
            }
        }
        return list;
        
    }
}