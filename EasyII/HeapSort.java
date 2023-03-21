package EasyII;
import java.util.*;


public class HeapSort {
    
public static void swap(int []input, int i, int j){
    int temp = input[i];
    input[i] = input [j];
    input[j] = temp;
}

public static int[] getArray(int size){
    Random rnd = new Random(5);
    int []input = new int[size];
    for(int i = 0; i < size; i++){
        input[i] = rnd.nextInt(100);
    }

    return input;
}

public static void heapSort(int []input)
{
    for(int i = input.length/2 -1 ; i >= 0; i--)
    {
        heapify(input, input.length, i);
    }

    for(int  i = input.length -1; i > 0 ; i--){
        swap(input, i, 0);
        heapify(input, i, 0);
    }

}

public static void heapify(int []input, int size, int i){
    int maxVIndex = i;
    int leftIndex = i*2 + 1;
    int rightIndex = i*2 + 2;
    
    if(leftIndex < size && input[maxVIndex] < input[leftIndex]){
        maxVIndex = leftIndex;
    }
    if(rightIndex < size && input[maxVIndex] < input[rightIndex]){
        maxVIndex = rightIndex;
    }

    if(i != maxVIndex){
        swap(input, i, maxVIndex);
        heapify(input, size, maxVIndex);
    }
}

    public static void main(String []args){
        int []input = getArray(15);
        System.out.println("Input array is : "+ Arrays.toString(input));
        heapSort(input);
        System.out.println("Sorted array is : "+ Arrays.toString(input));

    }
}
