package Set;

public class LinkedListSet extends Set{
    private ListNode head;
    private int size = 0;

    @Override
    public boolean add(String word){
        if(head == null){
            head = new ListNode(word);
        }else{
            if(contains(word)){
                return false;
            }else{
                ListNode node = new ListNode(word);
                node.next = head;
                head = node;
            }
        }
        size++;
        return true;
    }

    @Override
    public boolean contains(String word){
        ListNode curr = head;
        while(curr != null){
            if(curr.str.equals(word)){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public  int size(){
        return size;
    }

}

class ListNode{
    String str;
    ListNode next;

    ListNode(String s){
        this.str = s;
        this.next = null;
    }
}