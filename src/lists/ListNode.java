package lists;

public class ListNode<AnyType> {

    AnyType data;
    ListNode<AnyType> next;
    ListNode<AnyType> prev;

    ListNode(AnyType data) {
        this(null, data, null);
    }

    ListNode(ListNode<AnyType> prev, AnyType data, ListNode<AnyType> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public AnyType getData(){
        return data;
    }
}