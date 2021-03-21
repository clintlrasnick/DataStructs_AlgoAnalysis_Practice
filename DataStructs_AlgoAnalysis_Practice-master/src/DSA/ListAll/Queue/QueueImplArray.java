package DSA.ListAll.Queue;

public class QueueImplArray implements Queue{
    private final int max = 200000;
    public int[] queue;
    public int head = queue[0];
    private int size;
    public int tail = queue[size];





    @Override
    public boolean enq(int x) {
        if(size<max)
        size++;
        queue[size] = x;
        return true;
    }

    @Override
    public void deq() {

    }

    @Override
    public int top() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }
}
