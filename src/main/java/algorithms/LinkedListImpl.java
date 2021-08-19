package algorithms;

public class LinkedListImpl {
    Node head, tail = null;

    public static void main(String[] args) {
        LinkedListImpl obj = new LinkedListImpl();

        obj.add(10);
        obj.add(20);
        obj.add(50);
        System.out.println(obj.get(2));
    }

    class Node{
        Node prev, next;
        int data;

        Node(int data){
            this.data = data;
        }
    }

    public void add(int data){
        if(head == null && tail == null){
            head = tail = new Node(data);
        }else{
            Node newNode = new Node(data);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void delete(){

    }

    public void addAt(int index, int data){}
    public void deleteAt(int index){

    }

    public int get(int index){
        int nodeCnt = 0;
        Node elementNode = head;
        while(nodeCnt < index){
            elementNode = elementNode.next;
            nodeCnt++;
        }
        if(nodeCnt == index){
            return elementNode.data;
        }else{
            return -1; //no data found
        }
    }
}
