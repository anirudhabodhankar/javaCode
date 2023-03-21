package EasyII;
import java.util.*;
public class LowestCommonAncestor {
    public static class Node{
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

    public LowestCommonAncestor(int data)
    {

    }
    
    public void print(){
        System.out.println("\nCurrent tree is : "  );
        printInOrder(this.root);
    }

    public void printInOrder(Node root)
    {
        if(root == null)
        {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.data + " , ");
        printInOrder(root.right);
    }

    public void insert(int data)
    {
        Node newNode = new Node(data);
        if(root == null)
        {
            root = newNode;;
        }
        else
        {
            insert(root, newNode);
        }
    }

    public void insert(Node root, Node newNode)
    {
        if(newNode.data < root.data)
        {
            if(root.left == null)
            {
                root.left = newNode;
            }
            else
            {
                insert(root.left, newNode);
            }
        }
        else
        {
            if(root.right == null)
            {
                root.right = newNode;
            }
            else
            {
                insert(root.right, newNode);
            }
        }
    }

    public boolean find(int data)
    {
        return this.find(root, data);
    }
    
    private boolean find(Node root, int data)
    {
        if(root == null)
        {
            return false;
        }
        if(data < root.data)
        {
            return this.find(root.left, data);
        }
        else if(data > root.data)
        {
            return find(root.right, data);
        }
        
        return true;
    }

    public int getLCA(int a, int b)
    {
        if(this.find(a) && this.find(b))
        {
            Node temp = root;
            while(true)
            {
                if(a < temp.data && b < temp.data)
                {
                    temp = temp.left;
                }
                if(a > temp.data && b > temp.data)
                {
                    temp = temp.right;
                }
                else
                {
                    return temp.data;
                }
            }
        }

        return -1;
    }

    public static void main(String []args)
    {
        int []input = new int[]{2,8, 0 ,4,7,9,3,5};
        LowestCommonAncestor lca = new LowestCommonAncestor(6);
        for(int i =0; i < input.length; i++)
        {
            lca.insert(input[i]);
        }

        lca.print();

        int a = 3, b = 10;
        System.out.println("\na is present in the tree : " + lca.find(a));
        System.out.println("b is present in the tree : " + lca.find(b));

        System.out.println("LCA of a nd b is : " + lca.getLCA(a, b));
    }
}
