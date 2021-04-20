public class BinarySearch {
    /** 
     * Binary search algorithm
     *
     * @param array array to search in
     * @param start start index of range to search in (inclusive)
     * @param end end index of range to search in (inclusive)
     * @param target value to search for
     *
     * @return index of target value in the array, or -1 if the target value was not found
     */
    public static int binarySearch(int[] array, int start, int end, int target) {
        if (start > end) {
            // value not present in the array
            return -1;
        }
        int middle = (start + end) / 2;

        if (target < array[middle]) {
            // search for value in the first half
            // value can't be in the second half because it is less than the middle value
            return binarySearch(array, start, middle - 1, target);

        } else if (target > array[middle]) {
            // search for value in the second half
            // value can't be in the first half because it is greater than the middle value
            return binarySearch(array, middle + 1, end, target);
        } else {
            // value equal to middle value
            // return index of value
            return middle;
        }
    }

    /** Provides an easy-to-use interface to binarySearch() */
    public static int search(int[] arr, int target) {
        return binarySearch(arr, 0, arr.length - 1, target);
    }

    public static void main(String[] args) {
        int[] numbers = {-100, 2, 3, 4, 5, 8, 8, 12};
        System.out.println(search(numbers, 8));
        System.out.println(search(numbers, 3));
        System.out.println(search(numbers, -100));
        System.out.println(search(numbers, 12));
        System.out.println(search(numbers, 13));
    }
}
