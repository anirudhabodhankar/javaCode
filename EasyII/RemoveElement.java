package EasyII;
import java.util.*;

public class RemoveElement {
    public static int removeElement(int []input, int value)
    {
        int i = 0;
        for(int j = 0; j< input.length; j++)
        {
            if(input[j] != value)
            {
                input[i++] = input[j];
            }
        }

        int j = input.length -1;
        while (j >= i)
        {
            input[j--] = -1;
        }

        // i is not indext of last element. it is length
        return i;
    }

    public static void main(String []args)
    {
        int []input = new int[]{2,1,2,2,3,0,4,2};
        System.out.println("Input array is : " + Arrays.toString(input));
        int newLength = removeElement(input, 2);
        System.out.println("New array is : " + Arrays.toString(input));
    }
}
