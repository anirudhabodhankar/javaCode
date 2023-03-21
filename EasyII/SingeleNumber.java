package EasyII;
import java.util.*;
public class SingeleNumber {
    public static int getSingleNumbr(int []input)
    {
        int singleNumber = 0;
        for(int i = 0; i < input.length; i++)
        {
            singleNumber = singleNumber ^ input[i];
        }
        return singleNumber;

    }

    public static void main(String []args)
    {
        int []input = new int[]{4,1,2,1,2};
        System.out.println("Input array is : " + Arrays.toString(input));
        System.out.println("single number in above array is : " + getSingleNumbr(input));
    }
}
