package EasyII;
import java.util.*;

public class UglyNumber {
    
    public static boolean isUgly(int number)
    {
        if(number < 2)
            return false;

        int []primes = new int[]{2,3,5};
        while (number != 1)
        {
            int baseNumber = number; 
            for(int i = 0; i < primes.length; i++)
            {
                if((number % primes[i]) == 0)
                {
                    number = number / primes[i];
                }
            }

            if(baseNumber == number)
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String []argc)
    {
        System.out.println("The givne number is ugly : " + isUgly(72));
    }
}
