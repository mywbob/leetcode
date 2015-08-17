/*
Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/



public class Solution {
    //label visited
    Set<String> hs = new HashSet<String>();
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        int cnt = 1;
        Queue<Set<String>> queue = new LinkedList<Set<String>>();
        Queue<Set<String>> next = new LinkedList<Set<String>>();
        Queue<Set<String>> t;
        Set<String> temp = oneEditSet(beginWord, wordDict);
        Set<String> temp1;
        queue.add(temp);
        
        while (!queue.isEmpty()) {
            temp = queue.poll();
            for (String s : temp) {
                if (s.equals(endWord)) {
                    return cnt + 1;
                } else {
                    temp1 = oneEditSet(s, wordDict);
                    next.add(temp1);
                }
            }
            
            if (queue.isEmpty()) {
                t = queue;
                queue = next;
                next = t;
                cnt++;
            }
        }
        
        return 0;
        
    }
    
    public Set<String> oneEditSet(String w, Set<String> wordDict) {
        Set<String> set = new HashSet<String>();
        
        for (int i=0; i<w.length(); i++) {
            char[] warr = w.toCharArray();//string to char array faster
            for (char j='a'; j<='z'; j++) {
                if (j != w.charAt(i)) {//remove itself
                    warr[i] = j;
                    String news = new String(warr);
                    if (wordDict.contains(news) && !hs.contains(news)) {
                        hs.add(news);//label visited
                        set.add(news);
                    }
                }
            }
            
        }
        return set;
    }
}