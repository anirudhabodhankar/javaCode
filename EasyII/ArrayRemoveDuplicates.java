package EasyII;
import java.util.*;

public class ArrayRemoveDuplicates {
    public static int remvoeDuplicates(int []input)
    {
        if(input.length == 1)
        {
            return 1;
        }

        int i = 0;
        for(int j = 0; j< input.length; j++)
        {
            if(input[i] != input[j])
            {
                i++;
                input[i] = input[j];
            }
        }

        return i+1;
    }

    public static void main(String []args)
    {
        int []input = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("Input array is : " + Arrays.toString(input));
        int size = remvoeDuplicates(input);
        System.out.println("Input array is : " + Arrays.toString(input));

    }
}
