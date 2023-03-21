package EasyII;
import java.util.*;
public class FirstSubstringIndex {
    public static int findFirstIndex(String source, String key)
    {
        for(int i = 0; i< source.length(); i ++)
        {
            if(source.charAt(i) == key.charAt(0) && isSame(source, i, key))
            {
                return i;
            }
        }

        return -1;

    }

    public static boolean isSame(String source, int start, String key)
    {
        int j = 0;
        for(int i = start; i< source.length(); i++)
        {
            if(j >= key.length())
            {
                break;
            }

            if(source.charAt(i) != key.charAt(j++))
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String []args){
        System.out.println("Find first index : " + findFirstIndex("aaaaaa", "bba"));
    }
}
