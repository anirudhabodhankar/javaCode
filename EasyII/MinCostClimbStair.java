package EasyII;
import java.util.*;
public class MinCostClimbStair {
    public static int minCost(int [] input)
    {
        int stCost1 = 0; 
        int stCost2 = 0; 
        for(int i =0 ;i < input.length; i++)
        {
            int currentCost = Math.min(stCost1, stCost2) + input[i];
            stCost1 = stCost2;
            stCost2 = currentCost;
        }

        return Math.min(stCost1, stCost2);
    }

    public static void main(String []args)
    {
        int []input = new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println("Min cost of climbing stair is : " + minCost(input));
        input = new int[]{10,15,20};
        System.out.println("Min cost of climbing stair is : " + minCost(input));
    }
    
}
