/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/


public class Solution {
	//no need the array
	public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        int[] temp = new int[rowIndex+1];
        temp[0] = 1;
        for (int i = 0; i<rowIndex; i++) {
            for (int j =i+1; j>0; j--) {
                temp[j] = temp[j] + temp[j-1];
            }
        }
        
        for (int i=0; i<temp.length; i++) {
            res.add(temp[i]);
        }
        return res;
    }
	
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