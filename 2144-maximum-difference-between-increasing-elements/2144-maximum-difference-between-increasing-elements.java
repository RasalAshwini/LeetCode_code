class Solution {
    public int maximumDifference(int[] nums) {
        int small=nums[0];
        int diff=-1;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i] > small){
                diff= Math.max(diff,nums[i]-small);

            }else{
                small=nums[i];
            }
        }
        return diff;
    }
}