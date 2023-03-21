package EasyII;
import java.util.*;
public class ClimbingStair {
    public static int getCombi(int n){
        if(n <=0)
        {
            return 0;
        }

        if(n <=2)
        {
            return n;
        }

        return (getCombi(n-2) + getCombi(n-1));
    }

    public static int getCombiDP(int n){
        if(n <=0)
        {
            return 0;
        }

        if(n <=2)
        {
            return n;
        }

        int l1 = 1, l2 = 2;
        int totalStair = 0;

        for(int i = 3; i <= n; i ++)
        {
            totalStair = l1 + l2;
            l1 = l2;
            l2 = totalStair;
        }

        return totalStair;


    }
    public static void main(String []args){
        System.out.println(String.format("Total number of ways to reach [%d] stairs is : [%d]", 10, getCombiDP(10)));
        System.out.println(String.format("Total number of ways to reach [%d] stairs is : [%d]", 10, getCombi(10)));
    }
}
