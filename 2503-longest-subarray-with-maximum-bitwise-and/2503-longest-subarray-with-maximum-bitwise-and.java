class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int count =0;
        int maxLength=0;
        int max=nums[0];

        for(int i=1;i<n;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
            }

        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]==max)
            {
                count++;
            }else
            {
                maxLength=Math.max(maxLength,count);
                count=0;
            }
        }
        maxLength=Math.max(maxLength,count);
        return maxLength;
    }
}