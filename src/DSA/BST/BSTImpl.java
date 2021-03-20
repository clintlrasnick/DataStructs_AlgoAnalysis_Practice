package DSA.BST;


public class BSTImpl implements BST {

    private Node root;
    private int size;

    public BSTImpl() {
        root = null;
        size = 0;
    }

    public BSTImpl(String s) {
        root = new NodeImpl(s);
        size = 0;
    }

    // The implementation of "height" is given to you below
    // it is here to illustrate for you how to set up
    // the method implementation as recursion.
    // You should follow this pattern for implementing the other recursive methods
    // by adding your own private recursive methods

    @Override
    public int height() { // public interface method signature
        // this method is the public interface method
        // it is not recursive, but it calls a recursive
        // private method and passes it access to the tree cells
        return height_recursive(this.root);
    }
    private int height_recursive(Node c) {
        // inner method with different signature
        // this helper method uses recursion to traverse
        // and process the recursive structure of the tree of cells
        if (c==null) return -1;
        int lht = height_recursive(c.getLeft());
        int rht = height_recursive(c.getRight());
        return Math.max(lht,rht) + 1;
    }

    @Override
    public Node getRoot() {
        return this.root;
    }

    @Override
    public String insert(String value) {
        root = insert_r(root, value);
        this.size += 1;
        return value; }

    private Node insert_r(Node root, String value){
        if (root==null)
        {root = new NodeImpl(value);
            return root;
        }
        if (value.compareTo(root.getValue())<0){
            root.setLeft(insert_r(root.getLeft(), value));
        }
        if (value.compareTo(root.getValue())>0){
            root.setRight(insert_r(root.getRight(), value));
        }
        return root;
    }

    // remove implementation given to you, do NOT change
    @Override
    public void remove(String value) {
        remove_r(value,this.root);
        size--;
    }
    private Node remove_r(String k, Node c) {
        if (c==null) return null; // item not found, nothing to do

        // now we know we have a real node to examine
        int cflag = k.compareTo(c.getValue());

        if (cflag<0) { // k is smaller than node
            c.setLeft(remove_r(k,c.getLeft()));
            return c;
        }
        else
        if (cflag>0) { // k is larger than node
            c.setRight(remove_r(k,c.getRight()));
            return c;
        }
        else //cflag==0
        { // found it... now figure out how to rearrange

            // cases
            if (c.getLeft()==null && c.getRight()==null) { c = null; } // leaf
            else if (c.getLeft()==null && c.getRight()!=null) { c = c.getRight(); } // RC only
            else if (c.getLeft()!=null && c.getRight()==null) { c = c.getLeft(); } // LC only
            else { // 2 children
                Node max = maxCell(c.getLeft());
                c.setValue(max.getValue());
                c.setLeft(remove_r(c.getValue(), c.getLeft()));   // recurse
            }
            return c;
        }

    }

    private Node maxCell(Node c) { // this is used in remove too
        if (c.getRight()==null) return c;
        return maxCell(c.getRight());
    }

    @Override
    public boolean isFull() {
        return isFull_r(root);
    }
    private boolean isFull_r(Node root){

        if (root.getLeft()==null && root.getRight()==null){
            return true; // terminal condition. return.
        } else if (root.getRight()==null ^ root.getLeft()==null){return false;}
        boolean rightFull = isFull_r(root.getRight());
        boolean leftFull = isFull_r(root.getLeft());
        return rightFull && leftFull;
    }

    @Override
    public String findMin() {
        if (this.root == null){
            return null;
        }
        return findMin_r(root).getValue();
    }

    private Node findMin_r(Node root){
        if(root == null){
            return null;}
        else if (root.getLeft()==null){
            return root;
        }
        return findMin_r(root.getLeft());
    }

    @Override
    public String findMax() {
        if (this.root == null){
            return null;
        }
        return findMax_r(root).getValue();
    }
    private Node findMax_r(Node root){
        if (root==null){
            return null;
        } else if(root.getRight()==null){
            return root;
        }
        return findMax_r(root.getRight());
    }

    @Override
    public boolean contains(String s) {
        return contains_r(root, s);
    }
    private boolean contains_r(Node root, String s){
        if (root == null){return false;}
        if (s.compareTo(root.getValue())==0){
            return true;}
        if (s.compareTo(root.getValue())<0){
            return contains_r(root.getLeft(), s);
        }
        if (s.compareTo(root.getValue()) >0){
            return contains_r(root.getRight(), s);
        }
        return false;
    }

    @Override
    public Node get(String s) {
        return get_r(root, s);
    }
    private Node get_r(Node root, String s){
        if (root == null){return null;}
        if (s.compareTo(root.getValue())==0){
            return root;}
        if (s.compareTo(root.getValue())<0){
            return get_r(root.getLeft(), s);
        }
        if (s.compareTo(root.getValue()) >0){
            return get_r(root.getRight(), s);
        }
        return null;
    }
    @Override
    public int size() {
        return this.size;
    }
}