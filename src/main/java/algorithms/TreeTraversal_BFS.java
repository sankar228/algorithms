package algorithms;

public class TreeTraversal_BFS {

    Node root = null;
    public static void main(String[] args) {
        TreeTraversal_BFS tree = new TreeTraversal_BFS();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);

        System.out.println("Level order traversal of binary tree is ");
        tree.printTree();

    }

    public void printTree(){
        System.out.println("height of the tree: "+height(root));

        printCurrLevel(root, 2);
    }
     public void printCurrLevel(Node root, int level){
        if(root == null) return;

        if(level == 1) System.out.println(root.data);
        else if (level > 1){
            printCurrLevel(root.left, level -1);
            printCurrLevel(root.right, level -1);
        }
     }

    public int height(Node root){

        if(root == null) return 0;
        else{
            int lheight = height(root.left);
            int rheight = height(root.right);

            if(lheight > rheight) return lheight +1;
            else return rheight +1 ;
        }

    }
}

class Node{
    Node left;
    Node right;
    int data;

    Node(int data){
        this.data = data;
    }
}
