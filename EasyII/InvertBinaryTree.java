package EasyII;
import java.util.*;

public class InvertBinaryTree {
    public static class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root; 

    public InvertBinaryTree(int data)
    {
        this.root = new Node(data);
    }

    public void insertLeft(int parent, int data)
    {
        this.insertLeft(root, parent, data);
    }

    private void insertLeft(Node currentNode, int parent, int data)
    {
        if(currentNode == null)
        {
            return ;
        }

        if(currentNode.data == parent)
        {
            currentNode.left = new Node(data);
        }
        else
        {
            insertLeft(currentNode.left, parent, data);
            insertLeft(currentNode.right, parent, data);
        }
    }

    public void insertRight(int parent, int data)
    {
        this.insertRight(root, parent, data);
    }

    private void insertRight(Node currentNode, int parent, int data)
    {
        if(currentNode == null)
        {
            return ;
        }

        if(currentNode.data == parent)
        {
            currentNode.right = new Node(data);
        }
        else
        {
            insertRight(currentNode.left, parent, data);
            insertRight(currentNode.right, parent, data);
        }
    }

    public void print()
    {
        System.out.print("\nCurrent Tree structure is : ");
        this.print(root);
    }

    private void print(Node currentNode){
        System.out.print("(");

        if(currentNode != null){

            System.out.print(currentNode.data);
            this.print(currentNode.left);
            this.print(currentNode.right);
        }

        System.out.print(")");
    }
    
    public void invert()
    {
        this.invert(this.root);
    }

    private void invert(Node root)
    {
        if(root == null)
        {
            return;
        }
        
        invert(root.left);
        invert(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }


    public static void main(String []args)
    {
        InvertBinaryTree tree1 = new InvertBinaryTree(4);
        tree1.insertLeft(4,2);
        tree1.insertRight(4, 7);

        tree1.insertLeft(2,1);
        tree1.insertRight(2, 3);

        tree1.insertLeft(7,6);
        tree1.insertRight(7, 9);

        tree1.print();
        tree1.invert();
        
        tree1.print();
    }


    
}
