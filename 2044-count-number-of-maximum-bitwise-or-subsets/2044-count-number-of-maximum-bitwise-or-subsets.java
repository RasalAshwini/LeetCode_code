class Solution {
    int countSubset(int idx,int currOr,int[]nums,int maxOr)
    {
        if(idx==nums.length)
        {
            if(currOr==maxOr)
            {
                return 1;
            }
            return 0;
        }
        int takeCount= countSubset(idx+1, currOr | nums[idx],nums,maxOr);
        int notTakeCount= countSubset(idx+1,currOr,nums,maxOr);
        return takeCount+notTakeCount;
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOr=0;
        for(int num:nums)
        {
            maxOr |=num;
        }
        int currOr=0;
        return countSubset(0,currOr,nums,maxOr);
        
    }
} 