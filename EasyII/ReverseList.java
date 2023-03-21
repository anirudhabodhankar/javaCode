package EasyII;

public class ReverseList {
    
    public static class Node
    {
        int data; 
        Node next;
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    Node head; 
    public ReverseList(int data)
    {
        this.head = new Node(data);
    }

    public void insert(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
        }

        Node tail = head;
        while(tail.next != null)
        {
            tail = tail.next;
        }

        tail.next = newNode;
    }

    public void printList()
    {
        Node tail = head;
        System.out.print("\n List Contents : ");
        while(tail != null)
        {
            System.out.print(tail.data + " , ");
            tail = tail.next;
        }
    }

    public void reverse()
    {
        if(head == null){
            return;
        }

        Node prev = null;
        Node currentNode = head;

        while(currentNode != null)
        {
            Node nextNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = nextNode;
        }

        head = prev;
    }

    public void reverseR()
    {
        head = reverseR(head);
    }
    public Node reverseR(Node currentNode)
    {
        if(currentNode == null)
        {
            return null;
        }

        Node newHead = currentNode;

        if(currentNode.next != null)
        {
            newHead = reverseR(currentNode.next);
            currentNode.next.next = currentNode; 
        }

        currentNode.next = null;
        return newHead;
    }

    public void reverseRBase()
    {
        reverserRBase(head);
    }
    public void reverserRBase(Node currentNode)
    {
        if(currentNode == null)
        {
            return;
        }

        if(currentNode.next != null)
        {
            reverserRBase(currentNode.next);
            currentNode.next.next = currentNode;
        }
        else
        {
            this.head = currentNode;
        }

        currentNode.next = null;
    }

    public static void main(String []args){
        ReverseList list = new ReverseList(10);
        list.insert(12);
        list.insert(15);
        list.insert(22);
        list.insert(9);
        list.insert(6);
        list.insert(30);

        list.printList();

        list.reverse();
        list.printList();

        list.reverseR();
        list.printList();

        list.reverseRBase();
        list.printList();
    }
}
