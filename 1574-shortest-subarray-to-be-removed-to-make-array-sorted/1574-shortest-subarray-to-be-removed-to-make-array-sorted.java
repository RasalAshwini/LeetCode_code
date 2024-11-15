import java.util.*;

public class Solution {
    public static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        // Find the longest non-decreasing prefix
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        // If the whole array is sorted, no need to remove any subarray
        if (left == n - 1) {
            return 0;
        }

        // Find the longest non-decreasing suffix
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // The minimum subarray to remove is either removing the prefix or the suffix
        int result = Math.min(n - left - 1, right);

        // Try to merge the prefix and suffix
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example test cases
        int[] arr1 = {1, 2, 3, 10, 4, 2, 3, 5};
        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr3 = {1, 2, 3};

        System.out.println(findLengthOfShortestSubarray(arr1)); // Output: 3
        System.out.println(findLengthOfShortestSubarray(arr2)); // Output: 4
        System.out.println(findLengthOfShortestSubarray(arr3)); // Output: 0
    }
}
