/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
*/

class MyQueue {
    Stack<Integer> st1 = new Stack<Integer>();
    Stack<Integer> st2 = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        st1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (st2.empty()) {
            pour();
            st2.pop();
            
        } else {
            st2.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if (st2.empty()) {
            pour();
            return st2.peek();
        } else {
            return st2.peek();  
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return st1.empty() && st2.empty();
    }
    
    public void pour() {
        while (!st1.empty()) {
            st2.push(st1.pop());
        }
    }
	
}