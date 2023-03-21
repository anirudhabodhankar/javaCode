
import java.util.*;

public class MaxNoInWindow {

	public static List<Integer> findMaxSlidingWindow(List<Integer> nums, int windowSize) {
		List<Integer> result = new ArrayList<Integer>();

		if(nums.size() < windowSize)
		{
			return result;
		}

		Deque<Integer> dq= new ArrayDeque();
		for(int i = 0; i < windowSize; i++ )
		{
			while(dq.size()> 0 && dq.getLast() < nums.get(i))
			{
				dq.removeLast();
			}
			dq.addLast(nums.get(i));
		}

		result.add(dq.getFirst());

		int l = 0;
		int r = windowSize;
		while(r < nums.size())
		{
			if(nums.get(l) == dq.getFirst())
			{
				dq.removeFirst();
			}

			while(dq.size()> 0 && dq.getLast() < nums.get(r))
			{
				dq.removeLast();
			}
			dq.addLast(nums.get(r));
			result.add(dq.getFirst());

			l++;
			r++;
		}
		// write yout code here
		return result;
	}

    public static void main(String []args)
    {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        findMaxSlidingWindow(input, 3);
    }
}

