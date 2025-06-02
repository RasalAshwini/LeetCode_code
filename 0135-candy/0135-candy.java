
import java.util.Arrays;
class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int a[]=new int[n];
        Arrays.fill(a, 1);
        for(int i=1;i<n;i++){
            if(ratings[i] >ratings[i-1]){
                a[i]= a[i-1]+1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i] >ratings[i+1]){
            a[i]=Math.max(a[i],a[i+1]+1);
            }
        }
        int output=0;
        for(int i=0;i<n;i++){
            output +=a[i];
        }

        return output;
    }
}