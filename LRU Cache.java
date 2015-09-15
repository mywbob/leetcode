/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/



public class LRUCache {
    private int len;
    private int capacity;
    private HashMap<Integer, DoubleListNode> map;
    private DoubleList list;
    
    public LRUCache(int capacity) {
        this.len = 0;
        this.capacity = capacity;
        this.map =  new HashMap<Integer, DoubleListNode>();
        this.list = new DoubleList();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {//put to head, return
            list.removeNode(map.get(key));//!!!!!!!!!!
            list.setHead(map.get(key));//!!!!!! i split remove and setHead
            return map.get(key).getVal();
        }
        else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        DoubleListNode node = null;
        if (map.containsKey(key)) {//update val, move to head(remove this node)
            node = map.get(key);
            node.setVal(value);
            list.removeNode(node);
            list.setHead(node);
        }
        else {//full? not full?
            node = new DoubleListNode(key, value);
            if (len >= capacity) {//full, remove last, put node at head, remove it from hashtable too
                map.remove(list.getLastNodeKey());
                list.removeLast();
                list.setHead(node);
                map.put(key, node);//!!!!!fuck
            }
            else {//not full, put at head
                list.setHead(node);
                map.put(key, node);
                len++;
            }
            
        }
    }
}

class DoubleListNode {//need key value pair!! so i can remove it from map using key
    DoubleListNode prev;
    DoubleListNode next;
    int key;
    int val;
    public DoubleListNode(int k, int v) {
        this.prev = null;
        this.next = null;
        this.key = k;
        this.val = v;
    }
    
    public void setVal(int v) {
        this.val = v;
    }
    
    public int getVal() {
        return val;
    }
}

class DoubleList {//can not use public why
    private DoubleListNode head;
    private DoubleListNode tail;
    //private len;
    
    public void removeNode(DoubleListNode node) {
        DoubleListNode p = node.prev;
        DoubleListNode n = node.next;
        if (p == null && n != null) {//head
            head = node.next;
            head.prev = null;
        }
        else if (p != null && n == null){//tail
            removeLast();
        }
        else if (p == null && n == null) {//single node
            head = null;
            tail = null;
        }
        else {
            p.next = n;
            n.prev = p;
        }
        node.prev = null;//!!!!!better do this
        node.next = null;
        
    }
    
    public int getLastNodeKey() {
        if (tail == null) return Integer.MIN_VALUE;// node list, I think a len in list is better
        return tail.key;
    }
    
    public void removeLast() {
        if (tail != null) {
            if (tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
            }
            else {
                head = null;
                tail = null;
            }
        }
    }
    
    public void setHead(DoubleListNode node) {
        if (head == null) {
            head = node;
            tail = node;
        }
        else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }
}