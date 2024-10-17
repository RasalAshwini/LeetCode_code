class Solution {
    public int maximumSwap(int num) {
        char []s= Integer.toString(num).toCharArray();
        int n= s.length;
        int maxRight[]=new int[n];
        maxRight[n-1]=n-1;
        for(int i=n-2;i >=0;i--)
        {
            int rightMaxIdx=maxRight[i+1];
            int rightMaxElement=s[rightMaxIdx];
            maxRight[i]=(s[i] > rightMaxElement) ? i: rightMaxIdx;
            
        }
        
        for(int i=0;i<n;i++)
        {
            
            int maxRightIdx=maxRight[i];
            int maxRightElement=s[maxRightIdx];
            if(s[i] < maxRightElement)
            {
                char temp =s[i];
                s[i]=s[maxRightIdx];
                s[maxRightIdx]=temp;
                
                return Integer.parseInt(new String(s));
            }
        }
        return num;
    }
}