class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=grid[0].length;
        int ans[]=new int[2];

        for(int i=0;i<grid.length;i++){{
            for(int j=0;j<grid[i].length;j++)
            map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
        }
        }
        for(int i=1;i<=n*n;i++){
            if(!map.containsKey(i)){
                ans[1]=i;
            }else if(map.get(i)==2){
                ans[0]=i;
            }
        }
        return ans;


        
    }
}