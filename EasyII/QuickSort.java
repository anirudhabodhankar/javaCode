package EasyII;

import java.util.*;

public class QuickSort {
    public static void swap(int []input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static int partition(int []input, int start, int end){
        int partition = input[end];
        int i = start;

        for(int j = start; j< end; j++){
            if(input[j]< partition){
                swap(input, i, j);
                i++;
            }
        }

        swap(input, i, end);
        return i;
    }

    public static void quickSort(int []input, int start, int end){
        if(start < end){
            // get the partition index
            int partId = partition(input, start, end);

            // sort the left part
            quickSort(input, start, partId -1);

            //sort the right part
            quickSort(input, partId + 1, end);
        }
    }

    public static void quickSort(int []input){
        quickSort(input, 0, input.length -1);
    }

    public static int[] getArray(int size){
        Random rnd = new Random(150);
        int []input = new int[size];
        for(int i = 0; i < size; i++)
        {
            input[i] = rnd.nextInt(50);
        }

        return input;
    }

    public static void main(String []args){
        var input = getArray(15);
        System.out.println("Input array is : " + Arrays.toString(input));
        quickSort(input);
        System.out.println("Sorted array is :" + Arrays.toString(input));
    }
}
