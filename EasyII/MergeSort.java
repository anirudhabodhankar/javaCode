package EasyII;
import java.util.*;

public class MergeSort {

    public static void merge(int[]input, int start, int m1, int m2, int end){
        int n1 = m1 - start + 1;
        int n2 = end -m2 + 1;

        int []left = new int[n1];
        int []right = new int[n2];

        for(int i = 0; i < n1; i++)
        {
            left[i] = input[start + i];
        }

        for(int j = 0 ; j< n2 ;j++){
            right[j] = input[m2 + j];
        }

        int i = 0, j = 0;
        while(i < n1 && j < n2){
            if(left[i] < right[j]){
                input[start+i+j] = left [i++];
            }
            else{
                input[start+i+j] = right[j++];
            }
        }

        while(i < n1){
            input[start+i+j] = left [i++];
        }

        while (j < n2)
        {
            input[start+i+j] = right [j++];
        }

    }

    public static void mergeSort(int []input, int start, int end){
        if(start < end){
            int mid = (start + end) /2;
            mergeSort(input, start, mid);
            mergeSort(input, mid+1, end);

            merge(input, start, mid, mid+1, end);
        }

    }

    public static void sort(int []input){
        long startTime = System.currentTimeMillis();
        mergeSort(input, 0, input.length -1);
        long endTime = System.currentTimeMillis();

        System.out.println("Total time for sorting is : " + (endTime - startTime));
    }

    public static int[] getArray(int size){
        Random rnd = new Random(2000);
        int []input = new int[size];
        for(int i =0; i< size; i++){
            input[i] = rnd.nextInt(2000);
        }

        return input;
    }

    public static void main(String []args){
        int []input = getArray(20);
        System.out.println("Input list is : "+ Arrays.toString(input));
        sort(input);
        System.out.println("After sorting : " + Arrays.toString(input));
    }
}
