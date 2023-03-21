package EasyII;
import java.util.*;
public class ValidParentheses {
    public static boolean IsValid(String str)
    {
        Map<Character, Character> paraMap = new HashMap();
        paraMap.put('(', ')');
        paraMap.put('{', '}');
        paraMap.put('[',']');

        Set<Character> closingSet = new HashSet();
        closingSet.add(')');
        closingSet.add(']');
        closingSet.add('}');

        Stack<Character> paraStack = new Stack();

        var charArray = str.toCharArray();
        for(int i =0; i< charArray.length; i++){
            if (paraMap.containsKey(charArray[i])){
                paraStack.push(paraMap.get(charArray[i]));
            }
            else if(closingSet.contains(charArray[i]))
            {
                if(!paraStack.empty() && paraStack.peek() == charArray[i])
                {
                    paraStack.pop();
                }
                else{
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String []args){
        String input = "]({()[]{}})";
        System.out.println("Is input string has valid set of parentheses : " + IsValid(input));
    }
}
