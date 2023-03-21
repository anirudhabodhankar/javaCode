package EasyII;
import java.util.*;

public class BuySellStocks {
    public static int maxProfit(int []input){
        if(input == null || input.length <= 1){
            return 0;
        }

        int maxProfit = 0, currentProfit = 0;

        int i = 0;
        for(int j = 1; j< input.length; j++){
            currentProfit = input[j] - input[i];
            maxProfit = Math.max(currentProfit, maxProfit);
            if(input[j] < input[i]){
                i = j;
            }
        }

        return  maxProfit;
    }

    public static int maxProfitBasic(int []input)
    {
        if(input == null || input.length <= 1){
            return 0;
        }
        
        int maxProfit = 0;
        for(int i = 0; i< input.length-1; i++)
        {
            for(int j= i+1; j< input.length-1; j++)
            {
                maxProfit = Math.max(maxProfit, input[j] - input[i]);
            }
        }

        return maxProfit;
    }

    public static int[] getArray(int size){
        Random rnd = new Random(50);
        int []input = new int[size];
        for(int i =0; i < input.length; i++){
            input[i] = rnd.nextInt(100);
        }

        return input;
    }
        

    public static void main(String []args){
        int []input = getArray(15);
        System.out.println("Input array is : " + Arrays.toString(input));
        System.out.println("Max profit from above prices is : " + maxProfit(input));
        System.out.println("Max profit from above prices is : " + maxProfitBasic(input));
    }
    
}
