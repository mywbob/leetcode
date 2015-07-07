class MyStack {
    //keep one q empty
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (q1.isEmpty()) {
            put_n_1_backto1();
            q2.poll();
        } else {
            put_n_1_to2();
            q1.poll();
        }
    }

    // Get the top element.
    public int top() {
        int top;
        if (q1.isEmpty()) {
            put_n_1_backto1();
            top= q2.peek();
            q1.add(q2.poll());
        } else {
            put_n_1_to2();
            top= q1.peek();
            q2.add(q1.poll());
        }
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
    
    public void put_n_1_backto1() {
        while (q2.size() > 1) {
            q1.add(q2.poll());
        }
    }
    
    public void put_n_1_to2(){
        while (q1.size() >1) {
            q2.add(q1.poll());
        }
    }
}