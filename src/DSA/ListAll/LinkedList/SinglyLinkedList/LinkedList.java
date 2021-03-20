package DSA.ListAll.LinkedList.SinglyLinkedList;

import DSA.ListAll.Node.Node;
import DSA.ListAll.Node.NodeImpl;

public class LinkedList {
    private Node head = null;
    private Node tail = null;
    private int size = 0;


    /**
     * Remove the node at index i of the list.
     * Note that the first element is at index 0
     * If i is larger than the size of the list, throw an IndexOutOfBounds Exception
     * <p>
     * ex: list: 1 -> 2 -> 3 -> 4
     * i: 1
     * list after removeAtIndex: 1 -> 3 -> 4
     *
     * @param i - index of node to remove
     */
    public void removeAtIndex(int i) {
        this.validIndex(i);
        Node current = head;
        int m = 0;
        if (i == 0) {
            this.remove(current.getValue());
        } else {
            while (m < i) {
                current = current.getNext();
                m++;
            }
            current.setValue((int) (Math.random() * 330000));
            this.remove(current.getValue());
        }
    }


    /**
     * Compute and return the average of all the numbers in the linked list rounded down to the nearest integer
     *
     * @return an int that is the floor of the mean of the list.
     */
    public int mean() {
        if (this.isEmpty()) {
            return 0;
        }
        Node current = head;
        double sum = 0;
        while (current.hasNext()) {
            sum += current.getValue();
            current = current.getNext();
        }
        sum += current.getValue();
        return (int) Math.floor(sum / this.size);
    }

    /**
     * Return true if this linked list is equal to the list argument, false otherwise.
     * Two lists are equal if they have the same size, and the same
     * elements in the same order.
     * ex:  list: 1 -> 4 -> 2
     * list2: 1 -> 4 -> 2
     * return: true
     * <p>
     * list: 1 -> 5
     * list2: 2 -> 5
     * return false;
     *
     * @return true if the lists have the same elements in the same order, false otherwise
     */
    public boolean isEqual(LinkedList list2) {
        if (list2.isEmpty() ^ this.isEmpty()) {
            return false;
        } else if (list2.isEmpty() && this.isEmpty()){
            return true;
        }
        boolean boolVal = false;
        Node current = head;
        Node list2node = list2.getHead();
        if (this.size != list2.size()) {
            return false;
        }
        while (current.hasNext() && list2node.hasNext()) {
            if (current.getValue() != list2node.getValue()) {
                return boolVal = false;
            } else if (current.getValue() == list2node.getValue()) {
                boolVal = true;
            }
            current = current.getNext();
            list2node = list2node.getNext();
        }
        if (current.getValue() != list2node.getValue()) {
            boolVal = false;
        }
        return boolVal;
    }

    /**
     * Remove all the nodes at odd indices from the list. Remember that the first Node is at index 0
     * <p>
     * ex: list: 1 -> 3 -> 4 -> 2 -> 8
     * list after removeOdds: 1 -> 4 -> 8
     */
    public void removeOdds() {
        Node current = head;
        int i = 0;
        while (current.hasNext()) {
            if (i%2==1){
                current.setValue((int) (Math.random() * 330000));
                this.remove(current.getValue());
            }
            current = current.getNext();
            i++;
        }
        if(i%2==1){
            current.setValue((int) (Math.random() * 330000));
            this.remove(current.getValue());
        }
    }

    /**
     * Return true if the list is symmetrical, false otherwise
     * ex: list: 1 -> 2 -> 3 -> 2 -> 1
     * return: true
     * <p>
     * list: 1 -> 2 -> 3 -> 4 -> 5
     * return: false
     *
     * @return true if the list is symmetrical, false otherwise
     */

    public boolean isSymmetrical() {
        if (this.isEmpty()) {
            return true;
        }
        Node current = head;
        int middle;
        if (this.size % 2 != 0) {
            middle = ((this.size - 1) / 2);
        } else {
            middle = (this.size / 2);
        }
        int startSum = 0;
        int endSum = 0;
        int i = 0;
        int j = 0;
        while (current.hasNext()) {
            if (i < middle) {
                startSum += current.getValue();
                i++;
                current = current.getNext();
            } else if (i == middle & this.size % 2 == 0) {
                i++;
            } else if (i == middle & this.size % 2 != 0) {
                i++;
                current = current.getNext();
            } else if (j < middle & i > middle) {
                endSum += current.getValue();
                current = current.getNext();
                j++;
            } else {
                current = current.getNext();
            }
        }
        endSum += current.getValue();
        if (startSum == endSum) {
            return true;
        }
        return false;
    }


    /**
     * Stretch the list so that each element in the list is represented factor times
     * If the factor is 0 the list should be cleared (have 0 nodes)
     * ex: list: 1 -> 2 -> 3
     * factor: 3
     * list after multiply: 1 -> 1 -> 1 -> 2 -> 2 -> 2 -> 3 -> 3 -> 3
     *
     * @param factor the amount to multiply the number of occurrences of each element by
     */
    public void multiply(int factor) {
        Node current = head;
        Node pointer = head.getNext();
        if (factor == 0) {
            this.clear();
            return;
        }
        while (current.hasNext()) {
            for (int i = 0; i < factor - 1; i++) {
                Node temp = new NodeImpl(current.getValue(), current.getNext());
                current.setNext(temp);
                current = current.getNext();
            }
            current = current.getNext();
        }
        for (int m = 0; m < factor - 1; m++) {
            this.add(current.getValue());
        }
    }

    /**
     * Reverse the list
     * <p>
     * ex list:  10 -> 9 -> 8 -> 7
     * list after reverse: 7 -> 8 -> 9 -> 10
     */
    public void reverse() {
        int i = 1;
        while (i < this.size) {
            Node current = head;
            Node other;
            Node third;
            int m = 1;
            while (current.getNext().hasNext()) {
                current = current.getNext();
            }
            other = current.getNext();
            current.setNext(null);
            tail = current;
            third = head;
            while (m < i - 1) {
                third = third.getNext();
                m++;
            }
            if (i == 1) {
                other.setNext(head);
                head = other;
            } else {
                other.setNext(third.getNext());
                third.setNext(other);
            }
            i++;
        }
    }

    /**
     * Given a sorted linked list, remove the duplicate values from the list
     * ex: list: 5 -> 6 -> 7 -> 7 -> 7 -> 8 -> 8 -> 9
     * list after removeRepeats: 5 -> 6 -> 7 -> 8 -> 9
     */
    public void removeRepeats() {
        if (head == null) {
            this.clear();
            return;
        }
        Node current = head;
        while (current.hasNext()) {
            Node pointer = current.getNext();
            while (pointer.hasNext()) {
                Node pointer2;
                if (current.getValue() == pointer.getValue()) {
                    pointer2 = pointer.getNext();
                    pointer.setValue((int) (Math.random() * 330000));
                    this.remove(pointer.getValue());
                    pointer = pointer2;
                } else {
                    pointer = pointer.getNext();
                }
            }
            if (current.getValue() == tail.getValue()) {
                tail.setValue((int) (Math.random() * 330000));
                this.remove(tail.getValue());
            }
            current = current.getNext();
        }

    }

    /**
     * Return true if the list contains a cycle, false otherwise
     * ex: list: 1 -> 2 -> 3 - > 4 --       (4 points to 2)
     * ^              |
     * |              |
     * ---------------
     * return: true
     * <p>
     * list: 1 -> 2 -> 3 -> 4
     * return: false
     *
     * @return true if the list contains a cycle, false otherwise
     */
    public boolean containsCycle() {
        if(this.size < 2){return false;}
        Node current = head;
        Node pointer = head.getNext();
        while (current.hasNext()) {
            if (pointer.hasNext()){pointer = pointer.getNext();}
            if(!pointer.hasNext()){
                return false;
            }
            while (pointer.hasNext()) {
                current = current.getNext();
                pointer = pointer.getNext();
                if(!pointer.hasNext()||!current.hasNext()){return false;}
                if (current.equals(pointer)) {
                    return true;
                }
                pointer = pointer.getNext();
            }
            current = current.getNext();
        }
        return false;
    }




    /**
     * Merge the given linked list into the current list. The 2 lists will always be
     * either the same size, or the current list will be longer than list2.
     * The examples below show how to handle each case.
     *
     * Note: Do NOT create and return a new list, merge the second list into the first one.
     *
     * ex: list: 1 -> 2 -> 3
     *     list2: 4 -> 5 -> 6
     *     return: 1 -> 4 -> 2 -> 5 -> 3 -> 6
     *
     *     list: 1 -> 2 -> 3 -> 4
     *     list2: 5 -> 6
     *     return 1 -> 5 -> 2 -> 6 -> 3 -> 4
     *
     * @param list
     */

    public void merge(LinkedList list){
        if (list.isEmpty()){
            return;
        }
        Node current = this.getHead();
        Node p1 = current.getNext();
        Node p2 = list.getHead();
        Node p3 = p2.getNext();
        while(p2.hasNext()){
            current.setNext(p2);
            p2.setNext(p1);
            current = p1;
            p2 = p3;
            p3 = p3.getNext();
            p1 = p1.getNext();
        }
        current.setNext(p2);
        p2.setNext(p1);
        if (this.size == list.size()){
            this.tail = p2;
        }
    }

    /* Implementation given to you. Do not modify below this. */

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /*
    Returns true if the list contains a node whose value matches the element parameter, false otherwise
     */
    public boolean contains(int element) {
        Node current = head;
        while(current != null) {
            if(current.getValue() == element) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /*
    converts the linked list into an array
     */
    public int[] toArray() {
        int[] arr =  new int[size()];
        Node current = head;
        int i = 0;
        if(isEmpty()) {
            return arr;
        }
        while(current != null){
            arr[i] = current.getValue();
            current = current.getNext();
            i++;
        }
        return arr;
    }

    /*
    adds a node to the end of the list
     */
    public void add(int element) {
        Node newNode = new NodeImpl(element, null);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }

    }

    /*
    removes the element from the list
     */
    public boolean remove(int element) {
        Node current = head;
        if(isEmpty()) {
            return false;
        }
        if(current.getValue() == element){
            head = head.getNext();
            size--;
            return true;
        }
        while(current.getNext().getValue() != element) {
            current = current.getNext();
            if(current == null) {
                return false;
            }
        }
        if(current.getNext().getNext() == null) {
            tail = current;
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    /*
        returns the value at the index parameter.
     */
    public int get(int index) {
        validIndex(index);
        Node current = head;
        int i = 0;
        while (i < index) {
            current = current.getNext();
            i++;
        }
        return current.getValue();
    }

    /*
    sets the value of the node at index to the element
     */
    public int set(int index, int element) {
        validIndex(index);
        Node current = head;
        int prevValue = 1;
        int i = 0;
        if(index == 0) {
            prevValue = head.getValue();
            head.setValue(element);
        } else {
            while(current != null) {
                if(i == index) {
                    prevValue = current.getValue();
                    current.setValue(element);
                    return prevValue;
                }
                current = current.getNext();
                i++;
            }
        }

        return prevValue;
    }

    /*
    adds a node at the given index with the given element as its value
     */
    public void add(int index, int element) {
        if(index > size) {
            validIndex(index);
        }
        Node current = head;
        int i = 0;
        if(index == 0) {
            if(isEmpty()) {
                add(element);
                return;
            } else {
                Node newNode = new NodeImpl(element, head);
                head = newNode;
                size++;
                return;
            }

        }  else if(index == size) {
            add(element);
            return;
        }
        while(current != null) {
            if(i == (index - 1)) {
                Node temp = current.getNext();
                Node newNode = new NodeImpl(element, temp);
                current.setNext(newNode);
                size++;
                return;
            } else {
                current = current.getNext();
                i++;
            }
        }
    }

    /*
    returns the index of the given element
     */
    public int indexOf(int element) {
        Node current = head;
        int index = 0;
        while(current != null) {
            if(current.getValue() == element) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    /*
    returns the last index of the element
     */
    public int lastIndexOf(int element) {
        Node current = head;
        int index = -1;
        int i = 0;
        while(current != null) {
            if(current.getValue() == element) {
                index = i;
            }
            i++;
            current = current.getNext();
        }
        return index;
    }

    public void validIndex(int i) {
        if(i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public Node getHead() {
        return head;
    }

    /* prints out list */
    public String toString() {
        String list = "";
        Node current = head;
        while(current != null) {
            if(current.getNext() == null)
                list += current.getValue();
            else
                list += current.getValue() + " -> ";
            current = current.getNext();
        }
        return list;
    }

}