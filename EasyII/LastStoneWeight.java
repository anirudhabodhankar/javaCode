package EasyII;
import java.util.*;
public class LastStoneWeight {
    public static class CustomHeap{
        int totalLength;
        int length;
        int []input;

        public CustomHeap(int size)
        {
            this.input = this.getArray(size);
            this.totalLength = this.length = size;
            System.out.println("Input array is : "+ Arrays.toString(input));
            this.buildMaxHeap();
            System.out.println("Mapxheap array is : "+ Arrays.toString(input));
        }

        private int[] getArray(int size)
        {
            Random rnd = new Random(510);
            int []input = new int[size];
            for(int i = 0; i< size; i++)
            {
                input[i] = rnd.nextInt(50);
            }

            return input;
        }

        public void swap(int i, int j)
        {
            int temp = this.input[i];
            this.input[i] = this.input[j];
            this.input[j] = temp;
        }

        private void buildMaxHeap()
        {
            for (int i = length /2 -1; i >= 0; i--)
            {
                this.heapify(i);
            }
        }

        private void heapify(int root)
        {
            int max = root;
            int left = root*2 + 1;
            int right = root*2 +2;

            if(left < length && input[left] > input[max])
            {
                max = left;
            }

            if(right < length && input[right ]> input[max])
            {
                max = right;
            }

            if(max != root)
            {
                this.swap(max, root);
                this.heapify(max);
            }
        }

        private int removeTop()
        {
            int top = input[0];
            this.swap(0, length-1);
            length --;
            this.heapify(0);
            return top;
        }

        public int getLastStoneWeight()
        {
            this.buildMaxHeap();

            for(int i = totalLength ; i > 1; i--)       
            {
                int firstStone = this.removeTop();
                int secondStone = this.input[0];

                int diff = Math.abs(firstStone - secondStone);
                this.input[0] = diff;
                heapify(0);
                System.out.println("Heap after iteration is : " + Arrays.toString(input));
            } 

            return input[0];
        }

    }

    public static void main(String []args)
    {
        CustomHeap heap = new CustomHeap(5);
        System.out.print("The wieght of last stone is : "+heap.getLastStoneWeight());
    }
}
