package EasyII;
import java.util.*;

public class MinStack {
    private Stack<Integer> numStack;
    private Stack<Integer> minStack;

    public MinStack()
    {
        numStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int data)
    {
        numStack.push(data);
        if(minStack.empty())
        {
            minStack.push(data);
        }
        else
        {
            minStack.push(Math.min(minStack.peek(), data));
        }
    }

    public int pop()
    {
        minStack.pop();
        return numStack.pop();
    }

    public int top()
    {
        return numStack.peek();
    }

    public int getMin()
    {
        return minStack.peek();
    }




    public static void main(String []args){
        MinStack st = new MinStack();

        st.push(12);
        st.push(45);
        st.push(50);
        st.push(15);
        System.out.println("Pop top element : " + st.pop());
        System.out.println("Top element : " + st.top());
        System.out.println("Min element : " + st.getMin());
    }
}
