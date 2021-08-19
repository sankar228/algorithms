package algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryToBinaraySearch {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(){}
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args){
        BinaryToBinaraySearch obj = new BinaryToBinaraySearch();
/* Constructing tree given in the above figure
            10
            / \
            30 15
            /     \
            20     5 */

        Node root = new Node(10);
        root.left = new Node(30);
        root.left.left = new Node(20);
        root.right = new Node(15);
        root.right.right = new Node(5);

        obj.binaryToBST(root);
    }

    public int countNodes(Node node){
        if(node == null) return 0;

        return countNodes(node.left) + countNodes(node.right) + 1;
    }

    int index = 0;
    public void storeInorder(Node root, ArrayList<Integer> inorder){

        if(root == null) return ;

        storeInorder(root.left, inorder);

        inorder.add(root.data);

        storeInorder(root.right, inorder);
    }

    public void listToBst(Node root, ArrayList<Integer> inorder){

        if(root == null) return;

        listToBst(root.left, inorder);

        root.data = inorder.get(index);
        index ++;

        listToBst(root.right, inorder);

    }

    public void printInorder(Node root){
        if(root == null) return;

        printInorder(root.left);
        System.out.println(root.data + " , ");
        printInorder(root.right);
    }

    public void binaryToBST(Node root){
        int n = countNodes(root);

        ArrayList<Integer> inorder = new ArrayList();
        storeInorder(root, inorder);

        inorder.forEach(a -> System.out.println(a));

        Collections.sort(inorder);

        listToBst(root, inorder);

        printInorder(root);

        ArrayList<Integer> l = new ArrayList<>();

    }
}
