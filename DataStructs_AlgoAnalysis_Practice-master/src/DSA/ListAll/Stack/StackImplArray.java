package DSA.ListAll.Stack;

public class StackImplArray implements Stack{
    private final int max = 200000;
    public int[] stack;
    private int size;
    private int top = stack[size];

    public void StackImplArray(){
        stack = new int[max];
        size = 0;
    }

    @Override
    public void push(int value) {
        stack[size] = value;
        size++;
    }

    @Override
    public void pop() {
        int x = stack[size];
        stack[size] = 0;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int top() {
        return top;
    }
}
