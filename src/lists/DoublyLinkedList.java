package lists;

import java.util.NoSuchElementException;


public class DoublyLinkedList<AnyType> {

    private ListNode<AnyType> front;

    private int size;

    public DoublyLinkedList() {
        front = null;
        size = 0;
    }

    public void add(AnyType x) {
        if (isEmpty())
            front = new ListNode<AnyType>(x);
        else {
            ListNode<AnyType> temp = front;
            front = new ListNode<AnyType>(null, x, temp);
            front.next.prev = front;
        }
        size++;
    }

    public void remove(AnyType x) {
        if (isEmpty())
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        if (front.data.equals(x)) {
            front = front.next;
            return;
        }

        ListNode<AnyType> current = front;

        while (current != null && !current.data.equals(x))
            current = current.next;

        if (current == null)
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        if (current.next != null)
            current.next.prev = current.prev;

        current.prev.next = current.next;

        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public ListNode getNext(ListNode current){
        return current.next;
    }

    public ListNode getFront(){
        return front;
    }
}