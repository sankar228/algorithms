package algorithms;

public class AddTwoNum {
    public static void main(String[] args) {
        AddTwoNum obj = new AddTwoNum();


        //obj.addTwoNumbers();
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode tail = head;

        int carry = 0;
        while(l1.next != null){
            int sum = l1.val + l2.val;
            if(sum > 9){
                carry = 1;
                sum = sum - 10;
            }

            if( head == tail){
                tail.val = sum;
            }else{
                tail.next = new ListNode();
                tail = tail.next;
                tail.val = sum + carry;
            }
        }

        return head;

    }
}
