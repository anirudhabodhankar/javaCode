import java.util.*;
public class LongestIncreasingSub {
    public static long countQuadruplets(int[] nums) {
        int [][]leftMinCount = new int[nums.length][nums.length] ;
        int [][]rightMaxCount = new int[nums.length][nums.length];

        for(int i =0; i< nums.length; i++)
        {
            for(int j= 0; j< nums.length; j++)
            {
                leftMinCount[i][j] = rightMaxCount[i][j] = 0;
            }
            
        }

        for (int i = 1; i < nums.length; i++ )
        {
            int minCount = 0;
            for (int j= 0; j< i; j++)
            {
                if(nums[j] < nums[i])
                {
                    minCount++;
                }
                leftMinCount[i][j] = minCount;
            }
        }

        for (int i = nums.length-2; i >= 0; i--)
        {
            int maxCount = 0;
            for (int j= nums.length - 1; j > i; j--)
            {
                if(nums[j] > nums[i])
                {
                    maxCount++;
                }
                rightMaxCount[i][j] = maxCount;
            }
        }

        
        System.out.println("min array is : ");
        for(int i = 0; i< nums.length; i++)
        {
            System.out.println(Arrays.toString(leftMinCount[i]));
        }

        System.out.println("max array is : ");
        for(int i = 0; i< nums.length; i++)
        {
            System.out.println(Arrays.toString(rightMaxCount[i]));
        }

        long  totalSequenceCount = 0; 
        for(int i = 1 ; i < nums.length -2; i++)
        {
            for(int j = i+1; j < nums.length-1; j++)
            {
                if( nums[j] > nums[i])
                {
                    totalSequenceCount = totalSequenceCount + leftMinCount[i][i-1]*rightMaxCount[i][j+1];
                }
            }
        }

        return totalSequenceCount;
    }
   




    public static void main(String []args)
    {
        int []nums = new int []{2,5,3,1,4};
        countQuadruplets(nums);
    }
}
