package EasyII;

public class MergeBinaryTree {

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

    public MergeBinaryTree(int data)
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

    public void merge(MergeBinaryTree t2)
    {
        if(t2 == null)
        {
            return;
        }

        this.root = merge(this.root, t2.root);
    }

    private Node merge(Node root1, Node root2)
    {
        if(root1 == null)
        {
            return root2;
        }
        else if(root2 == null){
            return root1;
        }

        root1.data += root2.data;
        root1.left = merge(root1.left, root2.left);
        root1.right = merge(root1.right, root2.right);

        return root1;
    }

    public static void main(String []args)
    {
        MergeBinaryTree tree1 = new MergeBinaryTree(1);
        tree1.insertLeft(1,3);
        tree1.insertRight(1, 2);

        tree1.insertLeft(3,5);
        tree1.print();

        MergeBinaryTree tree2 = new MergeBinaryTree(2);
        tree2.insertLeft(2,1);
        tree2.insertRight(2, 3);

        tree2.insertRight(1, 4);
        tree2.insertRight(3, 7);

        tree2.print();

        tree1.merge(tree2);
        tree1.print();

    }


    
}
