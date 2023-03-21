package EasyII;
import java.util.*;
public class PalindromeLinkedList {
    
    public static class Node{
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
        }
    }

    Node head;
    public void insert(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
            return;
        }

        Node tail = head;
        while(tail.next != null)
        {
            tail = tail.next;
        }

        tail.next = newNode;
    }

    public void print()
    {
        Node tail = head;
        System.out.print("\nList is : ");
        while(tail != null)
        {
            System.out.print(tail.data + " , ");
            tail = tail.next;
        }
    }

    public boolean IsPalindrome()
    {
        boolean returnValue = true;
        Node slow, fast;
        slow = fast = head;
        Node slowPrev = null;

        //get the midway point.
        //list starting from slwo will be of equal size or size +1 to list before that. 
        while(fast != null && fast.next != null)
        {
            slowPrev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse the list from slow
        // slowPrev is not set to null, but is pointing to one element next
        Node prev = null;
        while (slow!= null)
        {
            Node nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        

        Node right  = prev;
        Node left = head;

        while(right != null)
        {
            if(left.data != right.data){
                returnValue = false;
            }

            left = left.next;
            right = right.next;
        }

        slow = prev;
        prev = null;
        while (slow!= null)
        {
            Node nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        slowPrev = prev;
        
        return returnValue;
    }

    public static void main(String []args){
        PalindromeLinkedList list = new PalindromeLinkedList();
         list.insert(10);
         list.insert(50);
         list.insert(30);
         list.insert(70);
         list.insert(30);
         list.insert(50);
         list.insert(10);

         list.print();

         System.out.println("Is this list palindorme : " + list.IsPalindrome());

         list.print();
    }

}
