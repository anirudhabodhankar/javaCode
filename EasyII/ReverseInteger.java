package EasyII;
import java.util.*;

public class ReverseInteger {
    public static long  reverse(long input)
    {
        long min = -2147483648;
        long max = 2147483647;
        long reverse = 0;
        while( input != 0)
        {
            long digit = input % 10;
            input = input /10;

            if(reverse > max/10 ||  (reverse == max/10 && digit >= max%10 )) 
            {
                return 0;
            }

            if(reverse < min/10 ||  (reverse == min/10 && digit <= min%10 )) 
            {
                return 0;
            }

            reverse = reverse *10 + digit;
        }

        return reverse;
    }

    public static void main(String []args)
    {
        long number = 7463847412L;
        System.out.println(String.format("Reverse of [%d] is : [%d]", number, reverse(number)));
    }
    
}
