package EasyII;
import java.util.*;

public class MergeSortedArrays {
    public static int[] getArray(int size, int zeros)
    {
        Random rnd = new Random(size+10);
        int []input = new int[size+zeros];
        for(int i = 0; i< size; i++){
            input[i] = rnd.nextInt(100);
        }
        for(int j = size; j < input.length; j++)
        {
            input[j] = 0;
        }        

        return input;
    }

    public static void swap(int []input, int i, int j)
    {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void heapSort(int []input, int length)
    {
        for(int i = (length/2) ; i >= 0; i--)
        {
            heapify(input, length, i);
        }

        for(int i = length-1 ; i > 0; i--)
        {
            swap(input, i , 0);
            heapify(input, i, 0);
        }
    }

    public static void heapify(int [] input, int length, int root)
    {
        int leftChild = root * 2 + 1;
        int rightChild = root * 2 + 2;
        int maxIndex = root;

        if(leftChild < length && input[maxIndex] < input[leftChild])
        {
            maxIndex = leftChild;
        }

        if(rightChild < length && input[maxIndex] < input[rightChild])
        {
            maxIndex = rightChild;
        }

        if(maxIndex != root)
        {
            swap(input, root, maxIndex);
            heapify(input, length, maxIndex);
        }
    }

    public static void merge(int []arr1, int [] arr2, int l1, int l2){
        l1--;
        l2--;
        while (l1 >= 0 && l2 >= 0)
        {
            if(arr1[l1] > arr2[l2])
            {
                arr1[l1 + l2 +1] = arr1[l1];
                l1--;
            }
            else{
                arr1[l1 + l2 + 1] = arr2[l2];
                l2--;
            }
        }

        while(l1 >= 0)
        {
            arr1[l1 + l2 + 1] = arr1[l1];
            l1--;
        }

        while(l2 >= 0)
        {
            arr1[l1 + l2 + 1] = arr2[l2];
            l2--;
        }

    }

    public static void main(String []args){
        int []arr1 = getArray(15, 10);
        int []arr2 = getArray(10, 0);

        System.out.println("First array is : " + Arrays.toString(arr1));
        System.out.println("Second array is : " + Arrays.toString(arr2));

        heapSort(arr1, 15);
        heapSort(arr2, arr2.length);

        System.out.println("First array is : " + Arrays.toString(arr1));
        System.out.println("Second array is : " + Arrays.toString(arr2));

        merge(arr1, arr2, 15, 10);
        System.out.println("First array is : " + Arrays.toString(arr1));
        
    }
    
}
