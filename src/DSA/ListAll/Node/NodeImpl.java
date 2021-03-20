package DSA.ListAll.Node;

import DSA.ListAll.Node.Node;

public class NodeImpl implements Node {

    private int _value;
    private Node _next;
    private Node _last;

    public NodeImpl(int value, Node next) {
        _value = value;
        _next = next;
    }

    @Override
    public int getValue() {
        return _value;
    }

    @Override
    public void setValue(int value) {
        _value = value;
    }

    @Override
    public Node getNext() {
        return _next;
    }

    @Override
    public void setNext(Node next) {
        _next = next;
    }
}