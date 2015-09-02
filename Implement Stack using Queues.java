class MyStack {
    
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (q1.isEmpty()) {
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        } 
           
        while (q1.size() != 1) {
            q2.add(q1.poll());
        }
        
        q1.poll();
        
    }

    // Get the top element.
    public int top() {
        if (q1.isEmpty()) {
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        } 
           
        while (q1.size() != 1) {
            q2.add(q1.poll());
        }
        
        return q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}