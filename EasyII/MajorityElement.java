package EasyII;
import java.util.*;

public class MajorityElement {
    public static int getMajorityElement(int []input)
    {
        int majorityElement = -1;
        int currentCount = 0;

        for(int i = 0; i< input.length; i++)
        {
            if(currentCount == 0)
            {
                majorityElement = input[i];
                currentCount++;
            }
            else
            {
                if(majorityElement == input[i])
                {
                    currentCount++;

                }
                else currentCount--;
            }
        }

        return majorityElement;
    }

    public static void main(String []args)
    {
        int []input = new int[]{2,2,1,1,1,1,1,2,2};
        System.out.println("Majority element in given array is : " + getMajorityElement(input));
    }
}
