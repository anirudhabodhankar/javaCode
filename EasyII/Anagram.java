package EasyII;
import java.util.*;

public class Anagram {
    public static void swap(char []input, int i, int j){
        var temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    public static int partition(char []input, int start, int end){
        int pivotIndex = end;
        int i = start;

        for (int j = start; j< end; j ++){
            if(input[j] > input[pivotIndex]){
                swap(input, i++, j);
            }
        }

        swap(input, i , pivotIndex);
        return i;
    }

    public static void quickSort(char []input, int start, int end)
    {
        if(start < end){
            var mid = partition(input, start, end);
            quickSort(input, start, mid-1);
            quickSort(input, mid+1, end);
        }
    }

    public static void sort(char []input){
        quickSort(input, 0, input.length-1);
    }

    public static boolean IsAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        char []s1Array = s1.toCharArray();
        char []s2Array = s2.toCharArray();

        System.out.println("Fist array is : " + Arrays.toString(s1Array));
        System.out.println("Second array is : " + Arrays.toString(s2Array));

        sort(s1Array);
        sort(s2Array);
        
        System.out.println("Fist array is : " + Arrays.toString(s1Array));
        System.out.println("Second array is : " + Arrays.toString(s2Array));
        
        for(int i = 0; i< s1Array.length ; i++){
            if(s1Array[i] != s2Array[i]){
                return false;
            }
        }
        

        return true;
    }

    public static boolean IsAnagramH(String s1, String s2)
    {
        if(s1.length() != s2.length()){
            return false;
        }

        var s1Array = s1.toCharArray();
        var s2Array = s2.toCharArray();

        Map<Character, Integer> map = new HashMap();

        for(int i = 0; i < s1Array.length; i++)
        {
            int count = map.containsKey(s1Array[i])? map.get(s1Array[i]) : 0;
            map.put(s1Array[i], count+1);
        }

        for(int i = 0; i < s2Array.length; i++)
        {
            int count = map.containsKey(s2Array[i])? map.get(s2Array[i]) : 0;
            map.put(s2Array[i], count-1);
        }

        for(Map.Entry<Character, Integer> keyValue : map.entrySet()){
            if(keyValue.getValue() < 0)
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String []args){
        String s1 = "anagram";
        String s2 = "nagaran";

        System.out.println("Two strings are anagram : " + IsAnagramH(s1, s2));
    }
    
}
