package EasyII;
import java.util.*;
public class MergeList {
    public static class Node{
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
        }
    }

    public static class LinkedListCustom{
        Node head;
        public LinkedListCustom()
        {
            head = null;
        }

        public LinkedListCustom(int data){
            head = new Node(data);
        }

        public void printList(){
            Node temp = head;
            System.out.print("\nList is :");
            while(temp != null){
                System.out.print(temp.data + " , ");
                temp = temp.next;
            }
        }

        public void InsertSorted(int data)
        {
            Node newNode = new Node(data);
            var temp = head;
            if(head == null)
            {
                head = newNode;
            }
            else if(head.data > newNode.data)
            {
                newNode.next = head;
                head = newNode;
            }
            else{
                while(temp != null)
                {
                    if((temp.data <= newNode.data) && (temp.next == null || temp.next.data > newNode.data))
                    {
                        newNode.next = temp.next;
                        temp.next = newNode;
                        break;
                    }
                    
                    temp = temp.next;
                }
            }
        }

        public void merge(LinkedListCustom l2)
        {
            Node dummy = new Node(0);
            Node h1 = this.head;
            Node h2 = l2.head;

            this.head = dummy;
            while(h1 != null && h2!= null)
            {
                if(h1.data < h2.data )
                {
                    dummy.next = h1;
                    h1 = h1.next;
                }
                else
                {
                    dummy.next = h2;
                    h2 = h2.next;
                }
                dummy = dummy.next;
            }

            dummy.next = h1 != null? h1: h2;
            this.head = head.next;

        }
    }

    

    public static void main(String []args){
        LinkedListCustom list1 = new LinkedListCustom(29);
        list1.InsertSorted(13);
        list1.InsertSorted(23);
        list1.InsertSorted(7);
        list1.InsertSorted(15);
        list1.InsertSorted(19);
        list1.InsertSorted(35);
        list1.printList();

        LinkedListCustom list2 = new LinkedListCustom(12);
        list2.InsertSorted(8);
        list2.InsertSorted(5);
        list2.InsertSorted(21);
        list2.InsertSorted(26);
        list2.InsertSorted(18);
        list2.printList();

        list1.merge(list2);
        list1.printList();
    }
    
}
