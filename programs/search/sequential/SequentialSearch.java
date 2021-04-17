public class SequentialSearch {
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {8, 53, 3, 5, 8, 4, 2, -100, 12};
        System.out.println(search(numbers, 8));
        System.out.println(search(numbers, 3));
        System.out.println(search(numbers, -100));
        System.out.println(search(numbers, 12));
        System.out.println(search(numbers, 13));
    }
}
