import java.util.*;
public class MinWindowSubstring {
    public static class MinWindow
    {
        int minLength = Integer.MAX_VALUE;
        int minL = 0; 
        int minR = 0;
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
        int req = 0;
        int present = 0;

        String s;
        String t;

        public MinWindow(String s, String t)
        {
            this.s = s;
            this.t = t;

            for(int i = 0; i< this.t.length(); i++)
            {
                if(this.tMap.containsKey(t.charAt(i)))
                {
                    this.tMap.put(this.t.charAt(i), 1 + this.tMap.get(t.charAt(i)));
                }
                else
                {
                    this.tMap.put(this.t.charAt(i), 1 );
                    this.req++;
                }
            }

            System.out.println("Required count is : " + this.req);
        }

        private boolean isMatch()
        {
            return this.present == this.req;
        }

        public void updateMinWindow(int i, int j)
        {
            if(this.isMatch() && this.minLength > j-i)
            {
                this.minLength = j-i;
                minL = i;
                minR = j;
                System.out.println(String.format("Found match at [%d] , [%d]", i, j));
            }
        }

        private void addChar(char c, int i, int j)
        {
            if(this.tMap.containsKey(c))
            {
                if(this.sMap.containsKey(c))
                {
                    this.sMap.put(c, this.sMap.get(c) + 1);
                }
                else
                {
                    this.sMap.put(c, 1);
                }

                if(this.sMap.get(c) == this.tMap.get(c))
                {
                    this.present++;
                }
            }

            this.updateMinWindow(i, j);
        }

        private void removeChar(char c, int i , int j)
        {
            if(this.tMap.containsKey(c))
            {
                if(this.sMap.containsKey(c))
                {
                    this.sMap.put(c, this.sMap.get(c) - 1);
                    if(this.sMap.get(c) == this.tMap.get(c) -1)
                    {
                        this.present--;
                    }
                }
            }

            this.updateMinWindow(i, j);
        }

        public String getMinWindow()
        {
            int i = 0;
            int j = 0; 
            while(j < s.length())
            {
                if(!this.isMatch())
                {
                    this.addChar(s.charAt(j), i , j);
                    j++;
                }

                while(i <= j && this.isMatch())
                {
                    this.removeChar(s.charAt(i), i , j);
                    i++;
                }
            }

            return s.substring(minL, minR+1);
        }
    }

    public static void main(String []args)
    {
        MinWindow mn = new MinWindow("ABDFGDCKAB", "ABCD" );
        mn.getMinWindow();
    }
}
