package EasyII;
import java.util.*;

public class MoveZeroes {
    public static void move(int[] input)
    {
        int i = 0;
        for (int j = 0; j< input.length; j++)
        {
            if(input[j] != 0 )
            {
                input[i++] = input[j];
            }
        }

        while(i < input.length)
        {
            input[i++] = 0;
        }
    }

    public static void main(String []args)
    {
        int []nums = new int[]{0,1,0,3,12};
        System.out.println("Input array is : " + Arrays.toString(nums));
        move(nums);
        System.out.println("Result array is : " + Arrays.toString(nums));

    }
}
