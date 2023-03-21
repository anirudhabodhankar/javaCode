package EasyII;
import java.util.*;

public class SearchInsertPosition {
    public static int[] getArray(int size)
    {
        Random rnd = new Random(50);
        Set<Integer> input = new HashSet<>();

        while(input.size() < size)
        {
            input.add(rnd.nextInt(50));
        }

        return input.stream().mapToInt(Integer :: intValue).toArray();
    }

    public static void swap(int []input, int i , int j)
    {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static  void sort(int []input)
    {
        quickSort(input, 0, input.length -1);
    }

    public static void quickSort(int []input, int start, int end)
    {
        if(start < end)
        {
            int partIndex = partition(input, start, end);
            quickSort(input, start, partIndex -1);
            quickSort(input, partIndex + 1, end);
        }
    }

    public static int partition(int []input, int start, int end)
    {
        int partIndex = end;
        int i = start;
        for(int j = start; j < end; j++)
        {
            if(input[j] <= input[partIndex])
            {
                swap(input, i++, j);
            }
        }

        swap(input, partIndex, i);
        return i;
    }

    public static int getInsertPosition(int []input, int key)
    {
        // if mid is less then number left moves to right of mid
        // if mid is greater than number right moves to left of mid
        return getInsertPosition(input, 0, input.length -1, key);
    }

    public static int getInsertPosition(int []input, int left, int right, int key)
    {
        // [5 , 10, 11] - key is 6 and key is 11
        while (left <= right)
        {
            int mid = (left + right)/2;
            System.out.println("Input mid is : " + input[mid]);
            if(input[mid] == key)
            {
                return mid;
            }
            else if(input[mid] < key)
            {
                left = mid + 1;
            }
            else 
            {
                right = mid -1;
            }
        }

        return left;
    }

    public static void main(String []args)
    {
        int []input = getArray(15);
        System.out.println("Input array is : " + Arrays.toString(input));
        sort(input);
        System.out.println("Sorted input array is : " + Arrays.toString(input));
        int number = 2;
        System.out.println(String.format("Correct insert position of [%d] is : [%d]",number, getInsertPosition(input, number)));
    }
}
