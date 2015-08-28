/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/



public class Solution {
    //how to use heap, two ways of using comparator
    //1: insert all to heap, then get min, nlogn heap operation, plus loop
    //2: keep a heap of size list.len
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> minheap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val == n2.val) return 0;
                else if (n1.val > n2.val) return 1;
                else return -1;
            }
        }); 
        
        for (int i=0; i<lists.length; i++) {
            if (lists[i] != null) minheap.add(lists[i]);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode index = dummy;
        ListNode node = null;
        while (!minheap.isEmpty()) {
            node = minheap.poll();
            index.next = node;
            index = index.next;
            if (node.next != null)
                minheap.add(node.next);
        }
        
        return dummy.next;
        
    }
}