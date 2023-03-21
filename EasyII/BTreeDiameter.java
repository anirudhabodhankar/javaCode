package EasyII;

public class BTreeDiameter {
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

    public BTreeDiameter(int data)
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

        if(currentNode != null){

            System.out.print(currentNode.data);
            if(currentNode.left == null && currentNode.right != null)
            {
                System.out.print("()");
            }

            if(currentNode.left != null)
            {
                System.out.print("(");
                this.print(currentNode.left);
                System.out.print(")");
            }

            if(currentNode.right != null)
            {
                System.out.print("(");
                this.print(currentNode.right);
                System.out.print(")");
            }
        }

    }

    private int diameter; 
    public int getDiameter()
    {
        this.diameter = 0;
        this.getHeight(root);
        return this.diameter;
    }

    private int getHeight(Node currentNode)
    {
        if(currentNode == null)
        {
            return -1;
        }

        int leftHeight = getHeight(currentNode.left) + 1;
        int rightHeight = getHeight(currentNode.right) + 1;
        
        this.diameter = Math.max(leftHeight+  rightHeight, this.diameter) ;

        return Math.max(leftHeight, rightHeight);
    }

    public static void main(String []args)
    {
        BTreeDiameter tree = new BTreeDiameter(1);
        tree.insertLeft(1,2);
        tree.insertRight(1, 3);

        tree.insertLeft(2,4);
        tree.insertRight(2, 5);

        tree.insertRight(4,6);
        tree.insertRight(6, 9);

        tree.insertRight(5, 7);
        tree.insertRight(7, 8);

        tree.print();

        System.out.println("Tree diameter is : " + tree.getDiameter());
    }

}
