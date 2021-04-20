import java.util.ArrayList;

public class InsertionSort {
    public static ArrayList<Integer> sort(int[] nums) {
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        for (int num : nums) {
            for (int i = 0; i <= sorted.size(); ++i) {
                if (i == sorted.size() || num < sorted.get(i)) {
                    sorted.add(i, num);
                    break;
                }
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] numbers = {8, 53, 3, 5, 8, 4, 2, -100, 12};
        ArrayList<Integer> sorted = sort(numbers);
        System.out.println(sorted);
    }
}
