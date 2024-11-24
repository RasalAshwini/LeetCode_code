class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        long sum=0;
        int count=0;
        int small=Integer.MAX_VALUE;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int num=matrix[i][j];
                sum += Math.abs(num);
                if(num<0)
                {
                    count++;
                    
                }
                small = Math.min(small, Math.abs(num));
                
            }
        }
        if(count %2 !=0)
        {
            sum -=2 *small;
            
        }
        
        return sum;
    }
}