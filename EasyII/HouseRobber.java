package EasyII;
import java.util.*;

public class HouseRobber {

    public static int[] getArray(int size)
    {
        Random rnd = new Random(50);
        int []input = new int[size];
        for(int i = 0; i< size; i++){
            input[i] = rnd.nextInt(100);
        }

        return input;
    }

    public static int getLootDP(int[] input)
    {
        int m1 = 0; int m2 = 0;
        for(int i = 0; i < input.length ; i++){
            int currentMax = Math.max(m1 , m2 + input[i]);
            m2 = m1; 
            m1 = currentMax;
        }

        return m1;
    }

    public static int getLoot(int [] input)
    {
        return getLoot(input, input.length -1);
    }

    public static int getLoot(int []input, int i){
        if(i < 0){
            return 0;
        }

        return Math.max(getLoot(input, i-1), input[i] + getLoot(input, i-2));
    }

    public static void main(String []args)
    {
        int [] input = new int[]{100, 1 ,1, 100, 1, 1, 100};
        System.out.println("Input array is : "+ Arrays.toString(input));
        System.out.println("Max loof for above array is : "+ getLootDP(input));

        input = getArray(15);
        System.out.println("Input array is : "+ Arrays.toString(input));
        System.out.println("Max loof for above array is : "+ getLootDP(input));
    }
    
}
