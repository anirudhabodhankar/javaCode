package EasyII;
import java.util.*;

public class ReplaceGRight{
    public static int[] getArray(int size){
        Random rnd = new Random(50);
        int []input = new int[size];
        for(int i = 0; i< input.length; i++)
        {
            input[i] = rnd.nextInt(50);
        }

        return input;
    }

    public static void replaceRightWithGreatest(int []input)
    {
        int max = -1;
        for(int i = input.length -1 ; i >= 0; i--)
        {
            int newMax = Math.max(max, input[i]);
            input[i] = max;
            max = newMax;
        }
    }

    public static void main(String []args){
        int []input = getArray(15);
        System.out.println("Input array is : " + Arrays.toString(input));
        replaceRightWithGreatest(input);
        System.out.println("Input array is : " + Arrays.toString(input));
    }
}