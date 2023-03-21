
import java.util.*;
public class MinWindowSubSequene {
    

    public static String minWindow(String s, String t) {
       int minLength = s.length();
       int minL = 0; 
       int minR= 0;
       for(int i = 0; i < s.length()-t.length(); i++)
       {
            int k = 0;
            for(int j = i; j < s.length(); j++)
            {
                
                if(s.charAt(j) == t.charAt(k))
                {
                    k++;
                }

                if(k == t.length())
                {
                    if(minLength > (j-i))
                    {
                        minL = i;
                        minR = j+1;
                        minLength = j-i;
                    }
                    
                    break;
                }
            }
       }

       return s.substring(minL, minR);
    }

    public static void main(String []args)
    {
        System.out.println(minWindow("abababa", "ba"));
    }
}

