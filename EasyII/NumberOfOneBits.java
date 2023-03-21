package EasyII;
import java.util.*;

public class NumberOfOneBits {
    public static int getOneBitCount(int number)
    {
        int count = 0;
        int one = 1;
        while (number != 0)
        {
            if((number & one) != 0)
            {
                count++;
            }

            number = number >>> 1;
        }

        return count;
    }

    public static void main(String []args)
    {
        int number = -17;
        System.out.println("Numer of one bits in number are : " + getOneBitCount(number));
    }
    
}
