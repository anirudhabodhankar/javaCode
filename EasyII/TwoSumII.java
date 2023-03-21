package EasyII;
import java.util.*;

public class TwoSumII {

    public static int[] getArray(int size)
    {
        Set<Integer> input = new HashSet();
        Random rnd = new Random(50);
        while(input.size() < size){
            input.add(rnd.nextInt(50));
        }

        return input.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void merge(int []input, int l, int m1, int m2, int r){

        int n1 = m1 - l + 1;
        int n2 = r - m2 + 1;

        int []n1Array = new int[n1];
        int []n2Array = new int[n2];

        for(int i = 0; i< n1; i++){
            n1Array[i] = input[l + i];
        }

        for (int j = 0; j< n2; j++)
        {
            n2Array[j] = input[m2 + j];
        }

        int i = 0, j = 0;
        while(i < n1 && j < n2){
            if(n1Array[i] < n2Array[j])
            {
                input[l + i + j] = n1Array[i++];
            }
            else{
                input[l + i + j] = n2Array[j++];
            }
        }

        while(i < n1)
        {
            input[l + i + j] = n1Array[i++];
        }

        while(j < n2 ){
            input[l + i + j] = n2Array[j++];
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
        mergeSort(input, 0, input.length -1);
    }

    public static void findTwoSum(int []input, int target){
        int i = 0, j = input.length -1;
        while(i < j)
        {
            int sum = input[i] + input [j] ;
            if(sum == target){
                System.out.println(String.format("Found the pair : [%d], [%d]",input[i], input[j]));
                i++;
            }
            else if(sum < target){
                i++;
            }
            else{
                j--;
            }
        }
    }

    public static void main(String []args){
        int [] input = getArray(15);
        System.out.println("Input array is : "+ Arrays.toString(input));
        sort(input);
        System.out.println("Sorted array is : " + Arrays.toString(input));
        findTwoSum(input, 50);
    }
}
