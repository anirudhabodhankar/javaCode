package EasyII;
import java.util.*;
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s1, String s2)
    {
        if(s1.length() != s2.length())
        {
            return false;
        }

        Map<Character, Character> charMap = new HashMap<>();
        Map<Character, Character> revMap = new HashMap<>();

        for(int i = 0; i< s1.length(); i++)
        {
            if(charMap.containsKey(s1.charAt(i)))
            {
                if(charMap.get(s1.charAt(i)) != s2.charAt(i))
                {
                    return false;
                }
            }
            else
            {
                if(revMap.containsKey(s2.charAt(i)))
                {
                    return false;
                }
                charMap.put(s1.charAt(i), s2.charAt(i));
                revMap.put(s2.charAt(i), s1.charAt(i));
            }
        }

        return true;

    }

    public static void main(String []args)
    {
        String s1 = "egga";
        String s2 = "addd";
        System.out.println("String isomorphic ? : " + isIsomorphic(s1, s2));
    }
}
