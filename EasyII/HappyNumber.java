package EasyII;
import java.util.*;
public class HappyNumber {
    public static boolean isHappy(int number)
    {
        System.out.println("Original number is : " + number);
        Set<Integer> visited = new HashSet();
        visited.add(number);

        while(true)
        {
            int newNumber = 0;
            while(number != 0)
            {
                int remainder =  number % 10;
                newNumber += remainder * remainder;
                number = number /10;
            }

            System.out.println("Next number is : " + newNumber);
            if(newNumber == 1)
                return true;;
            
            if(visited.contains(newNumber))
            {
                break;
            }

            visited.add(newNumber);
            number = newNumber;
        }

        return false;
    }

    public static void main(String []args)
    {
        int number = 6129;
        System.out.println(String.format("Given number [%d] is [%b]", number, isHappy(number)));
    }
}
