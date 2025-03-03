class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];

        int i = 0, j = n - 1; // pointers for original array
        int i_ = 0, j_ = n - 1; // pointers for result array

        while (i < n && j >= 0) {
            if (nums[i] < pivot) {
                result[i_] = nums[i];
                i_++;
            }

            if (nums[j] > pivot) {
                result[j_] = nums[j];
                j_--;
            }

            i++;
            j--;
        }

        // Fill pivot in the remaining positions
        while (i_ <= j_) {
            result[i_] = pivot;
            i_++;
        }

        return result;
    }
}