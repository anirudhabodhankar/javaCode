package EasyII;
import java.util.*;

import javax.naming.ldap.Rdn;

public class TwoSum {

    public static int[] getArray(int size){
        Random rnd = new Random(50);
        Set<Integer> input = new HashSet<>();
        int i = 0; 
        while(input.size() < size){
            input.add(rnd.nextInt(50));
        }

        return input.stream().mapToInt(Integer :: intValue).toArray();
    }

    public static void FindTwoSum(int []input, int target){
        Set<Integer> numSet = new HashSet<>();
        for(int i = 0; i< input.length; i++)
        {
            int diff = target - input[i];
            if(!numSet.contains(input[i])){
                numSet.add(diff);
            }
            else
            {
                System.out.println(String.format("Two values are [%d] & [%d]", input[i], diff));
                break;
            }
        }
    }

    public static void main(String []args){
        int []input = getArray(15);
        FindTwoSum(input, 40);

    }
}
