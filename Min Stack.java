/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> stackmin = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if (stackmin.isEmpty() || stackmin.peek()>=x) stackmin.push(x);// = is important
    }

    public void pop() {
        int val = stack.pop();
        if (val == stackmin.peek()) stackmin.pop();
        
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackmin.peek();
    }
}

//old
class MinStack {
    Stack<Integer> stnormal = new Stack<Integer>();
    Stack<Integer> stmin = new Stack<Integer>();
    public void push(int x) {
        stnormal.push(x);
        if (stmin.empty()) {
            stmin.push(x);
        } else {
            if (x <= stmin.peek()) {
                stmin.push(x);
            }
        }
    }

    public void pop() {
        int top = stnormal.pop();
        if (top == stmin.peek()) {
            stmin.pop();
        }
    }

    public int top() {
        return stnormal.peek();
    }

    public int getMin() {
        if (stmin.empty()) {
            return Integer.MAX_VALUE;
        } else {
            return stmin.peek();
        }
    }
	
}