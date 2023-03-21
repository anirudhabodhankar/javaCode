package EasyII;
import java.util.*;

public class MaxSubArray {
    public static int[] getArray(int size)
    {
        Random rnd = new Random(50);
        Set<Integer> inputSet = new HashSet<>();
        while(inputSet.size() < size){
            inputSet.add(rnd.nextInt(50) * (rnd.nextBoolean() ? 1 : -1));
        }

        return inputSet.stream().mapToInt(Integer :: intValue).toArray();
    }

    public static int maxSubArraySum(int []input){
        int maxSum = input[0];
        int currentSum = 0;
        for(int i = 0; i< input.length; i++){
            currentSum = Math.max(0, currentSum);
            currentSum += input[i];
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
    public static void main(String []args){
        int []input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        input = getArray(15);
        System.out.println("Input array is : " + Arrays.toString(input));
        System.out.println("Max sum subarray has sum : " + maxSubArraySum(input));

    }
}
