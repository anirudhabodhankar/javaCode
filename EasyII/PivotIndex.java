package EasyII;
import java.util.*;
public class PivotIndex {

    public static int getPivotIndex(int []input)
    {
        int totalSum = 0;
        int currentSum = 0;
        for(int i = 0; i < input.length; i++)
        {
            totalSum += input[i];
        }

        for(int i = 0; i< input.length; i++)
        {
            totalSum = totalSum - input[i];
            if(totalSum == 2*currentSum)
            {
                return i;
            }

            currentSum = currentSum +input[i];
            totalSum = totalSum + input[i];
        }

        return -1;
    }

    public static void main(String [] args)
    {
        int []input = new int[]{1,7,3,6,5,6};
        System.out.println("Input array is : " + Arrays.toString(input));
        System.out.println("Pivot element index is : " + getPivotIndex(input));
    }
    
}
