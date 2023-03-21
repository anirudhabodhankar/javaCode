package EasyII;
import java.util.*;
public class MaxNumberOfBaloons {
    
    public static int getMaxBaloons(char[] child, char []parent)
    {
        Map<Character, Integer> childMap = new HashMap();
        Map<Character, Integer> parentMap = new HashMap();

        for(int i = 0 ; i < child.length; i++)
        {
            if(childMap.containsKey(child[i]))
            {
                childMap.put(child[i], childMap.get(child[i]) + 1);
            }
            else{
                childMap.put(child[i],  1);
            }
        }

        for(int i = 0 ; i < parent.length; i++)
        {
            if(parentMap.containsKey(parent[i]))
            {
                parentMap.put(parent[i], parentMap.get(parent[i]) + 1);
            }
            else{
                parentMap.put(parent[i],  1);
            }
        }

        int totalBaloons = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer>  childEntry: childMap.entrySet())
        {
            if(!parentMap.containsKey(childEntry.getKey()))
            {
                totalBaloons = 0; 
            }
            else
            {
                totalBaloons = Math.min(totalBaloons, parentMap.get(childEntry.getKey())/ childEntry.getValue());
            }
        }

        return totalBaloons;
    }

    public static void main(String []args)
    {
        String s1 = "baloon";
        String s2 = "loonbalxballpoon";
        System.out.println("Max number of baloons is : " + getMaxBaloons(s1.toCharArray(), s2.toCharArray()));
    }
}
