/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 /*
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/
 /*
 tricky method O(n) * 3
 The idea is: Step 1: create a new node for each existing node and join them together eg: A->B->C will be A->A'->B->B'->C->C'

Step2: copy the random links: for each new node n', n'.random = n.random.next

Step3: detach the list: basically n.next = n.next.next; n'.next = n'.next.next
*/

/*
bf1: build a copy use next, then connect the random ptr for each point. o(n) + o(n2)
bf2: using hashmap to reduce the time o(n) * 2
*/
public class Solution {
    //can i dfs or bfs like clone graph? if all the nodes have diff value maybe we can?
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode index = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode index1 = dummy;
        while (index != null) {
            RandomListNode node = new RandomListNode(index.label);
            map.put(index, node);
            index1.next = node;
            index = index.next;
            index1 = index1.next;
        }
        
        index = head;
        index1 = dummy.next;
        while (index != null) {
            RandomListNode ran = map.get(index.random);
            index1.random = ran;
            index = index.next;
            index1 = index1.next;
        }
        return dummy.next;
    }
}