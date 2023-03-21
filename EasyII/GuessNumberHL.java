package EasyII;

public class GuessNumberHL {

    public static int guess(int num)
    {
        int pick = 6;
        if(pick < num)
        {
            return -1;
        }
        else if (pick > num)
        {
            return 1;
        }

        return 0;
    }

    public static int getPick(int n) 
    {
        int l = 1; 
        int r = n;
        int mid = -1;
        while (l <= r)
        {
            mid = (l + r) / 2;
            int guessNum = guess(mid);
            if(guessNum < 0)
            {
                r = mid -1;
            }
            else if(guessNum > 0)
            {
                l = mid + 1; 
            }
            if(guessNum == 0)
            {
                break;
            }

        }

        return mid;
    }

    public static void main(String []args)
    {
        System.out.println("Number you guessed is : " + getPick(100));
    }
}
