package DSA.ListAll.Stack;

import DSA.ListAll.Node.NodeImpl;
import DSA.ListAll.Node.Node;

public class StackImplLinkedList implements Stack {
    private Node top = null;
    private int size = 0;


    public void push(int x){
        NodeImpl newTop = new NodeImpl(x, top);
        this.size++;
    }

    public void pop(){
        if(top==null){return;}
        if(top.hasNext()) {
            Node p = top;
            top = top.getNext();
            p.setNext(null);
            size--;
        }
    }

    public int size() {
        return size;
    }

    public int top(){
        return top.getValue();}

}
