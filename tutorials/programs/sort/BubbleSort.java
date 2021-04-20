import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] nums) {
        boolean sorted = false;
        while (!sorted) { // repeat until the array has been sorted
            sorted = true;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i - 1] > nums[i]) {
                    // swap the two elements
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                    sorted = false; // elements out of order
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {8, 53, 3, 5, 8, 4, 2, -100, 12};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
