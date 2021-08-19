package algorithms;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        obj.reverse(n1);
    }

    private Node reverse(Node n) {
        if(n == null || n.next == null) return n;
        //n = 5
        Node rh = reverse(n.next);
        n.next.next = n;
        n.next = null;
        return rh;

    }

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }

        void setNext(Node nextnode){
            this.next = nextnode;
        }
    }

}
