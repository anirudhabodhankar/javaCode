import java.util.*;

public class LongestSubStringWRC
{
    public static int getMaxLengthBasic(char []input)
    {
        int maxLength = 1;
        for(int i = 0; i< input.length; i++)
        {
            Set<Character> charSet = new HashSet();
            charSet.add(input[i]);
            for (int j = i+1; j< input.length; j++)
            {
                if(charSet.contains(input[j]) || (j == input.length-1))
                {
                    maxLength = Math.max(maxLength, j-i);
                    break;
                }

                charSet.add(input[j]);
            }
        }

        return maxLength;
    }

    public static int getMaxLength(char []input)
    {
        Set<Character> charSet = new HashSet();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < input.length; right++)
        {
            while(charSet.contains(input[right]))
            {
                left++;
                charSet.remove(input[left]);
            }
            
            charSet.add(input[right]);
            maxLength = Math.max(maxLength, left-right);
        }

        return maxLength;
    }

    public static void main(String []args)
    {
        String input = "abcabcbb";
        System.out.println("Max length of substring without any repeating character is : "+ getMaxLengthBasic(input.toCharArray()));
        System.out.println("Max length of substring without any repeating character is : "+ getMaxLengthBasic(input.toCharArray()));
    }

}
