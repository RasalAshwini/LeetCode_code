class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);  
        long count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n - 1; i++) {
            int left = binarySearchLeft(nums, i + 1, n - 1, lower - nums[i]);
            int right = binarySearchRight(nums, i + 1, n - 1, upper - nums[i]);
            
            if (left != -1 && right != -1 && left <= right) {
                count += (right - left + 1);  
            }
        }
        
        return count;
    }

    private int binarySearchLeft(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left <= end ? left : -1;
    }

    private int binarySearchRight(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right >= start ? right : -1;
   }
}
