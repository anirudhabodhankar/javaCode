package EasyII;
import java.util.*;
public class RemoveLinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null; 
        }
    }

    Node head;
    public RemoveLinkedList(int data)
    {
        head = new Node(data);
    }

    public void insert(int data)
    {
        if(head == null)
        {
            head = new Node(data);
        }
        else
        {
            Node tail = head;
            while(tail.next != null)
            {
                tail = tail.next;
            }

            tail.next = new Node(data);
        }
    }

    public void print()
    {
        System.out.println("\n Current list is : ");
        Node tail = head;
        while(tail != null)
        {
            System.out.print(tail.data + " , ");
            tail = tail.next;
        }
    }

    public void delete(int data)
    {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node tail = dummy; 
        while(tail.next != null)
        {
            Node nextNode = tail.next;
            if(nextNode.data == data)
            {
                tail.next = nextNode.next;
            }
            else
            {
                tail = tail.next;
            }
        }
        
        head = dummy.next;
    }

    public static int[] getArray(int size)
    {
        Random rnd = new Random(50);
        int []input = new int[size];
        for(int i = 0; i < input.length; i++)
        {
            input[i] = rnd.nextInt(50);
        }

        return input;
    }

    public static void main(String []args)
    {
        int []input = getArray(15);
        RemoveLinkedList list = new RemoveLinkedList(input[0]);
        for(int i = 1; i < input.length; i++)
        {
            list.insert(input[i]);
        }

        list.print();

        list.delete(12);
        list.print();

        list.delete(28);
        list.print();

        list.delete(0);
        list.print();

        list.delete(17);
        list.print();
;    }
}
