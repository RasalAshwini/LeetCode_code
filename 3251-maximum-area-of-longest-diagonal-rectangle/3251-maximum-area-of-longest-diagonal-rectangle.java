class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int area=0;
        double Digonal_length =Double.MIN_VALUE;
        for(int i=0;i<dimensions.length;i++){
            int length=dimensions[i][0];
            int width= dimensions[i][1];
            double current= Math.sqrt( (width *width) + (length *length));
            int currentArea=length * width;
            if( Digonal_length < current ||(current == Digonal_length && area < currentArea) ){
                Digonal_length = current;
                area=currentArea;
                
            }
        }
        return area;
        
    }
}