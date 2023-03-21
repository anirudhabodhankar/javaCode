package EasyII;
import java.util.*;
public class KthLargestElement {
    int []input;
    int heapSize;
    int length;
    int totalLength;
    public KthLargestElement(int size, int k)
    {
        this.heapSize = k;
        this.totalLength = size;
        this.input = new int[size];
    }

    public void addArray(int []newArray)
    {
        this.length = 0; 
        for(int i = 0; i < newArray.length && i < heapSize; i++)
        {
            length ++;
            input[i] = newArray[i];
        }

        this.buildHeap();
        System.out.println("Input array is : " + Arrays.toString(input));

        for(int i = heapSize; i < newArray.length; i++)
        {
            this.add(newArray[i]);
        }

        System.out.println("Input array is : " + Arrays.toString(input));
    }

    public int add(int value)
    {
        if(value > input[0])
        {
            input[length] = input[0];
            input[0] = value;
            heapify(0);
        }
        else{
            input[length] = value;
        }

        System.out.println("Input array is : " + Arrays.toString(input));

        length ++;
        return input [0];
    }

    public void buildHeap()
    {
        for(int i = heapSize /2 -1; i >=0; i--)
        {
            heapify(i);
        }
    }

    public void swap(int a, int b)
    {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
    public void heapify(int root)
    {
        int min = root;
        int left = root*2 +1;
        int right = root * 2 + 2;

        if(left < heapSize && left < length && input[left] < input[min] )
        {
            min = left;
        }

        if(right < heapSize && right < length && input[right] < input[min])
        {
            min = right;
        }

        if(min != root)
        {
            this.swap(min, root);
            heapify(min );
        }
    }


    public static void main(String []args)
    {
        KthLargestElement kthElement = new KthLargestElement(15, 3);
        int []inputArray = new int[]{8,5,4,2};
        kthElement.addArray(inputArray);
        kthElement.add(3);
        kthElement.add(5);
        kthElement.add(10);
        kthElement.add(9);
        kthElement.add(4);
    }

    
}
