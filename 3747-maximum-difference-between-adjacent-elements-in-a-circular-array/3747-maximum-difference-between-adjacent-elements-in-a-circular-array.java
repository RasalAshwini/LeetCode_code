class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int diff1=0;
        int diff2=0;
        int result =0;
        int n=nums.length;
        diff2=Math.abs(nums[0]-nums[n-1]);
        for(int i=0;i<n-1;i++){
            
            diff1= Math.max(diff1,Math.abs(nums[i]-nums[i+1]));
        }

        
        if(diff1 >diff2){
            result=diff1;
        }else{
            result=diff2;
        }
        return result;
    }
}