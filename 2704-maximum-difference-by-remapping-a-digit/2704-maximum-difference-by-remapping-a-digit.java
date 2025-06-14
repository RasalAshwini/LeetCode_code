class Solution {
    public int minMaxDifference(int num) {
        String s=Integer.toString(num);
        
        char replaceMax=' ';
        for(char ch:s.toCharArray()){
         if(ch !='9'){
            replaceMax=ch;
            break;
         }
        }
        String maxS=s.replace(replaceMax,'9');
        
        char replaceMin =s.charAt(0);
        String minS=s.replace(replaceMin,'0');
        
        int max= Integer.parseInt(maxS);
        int min= Integer.parseInt(minS);
        return (max-min);
    }
}