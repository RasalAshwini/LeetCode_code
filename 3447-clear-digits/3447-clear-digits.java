class Solution {
    public String clearDigits(String s) {
        StringBuilder sb=new StringBuilder(s);
        int n= s.length();
        for(int i=0;i<sb.length();i++)
        {
            if(Character.isDigit(sb.charAt(i)))
            {
                sb.deleteCharAt(i);
                if(i>0)
                {
                    sb.deleteCharAt(i-1);
                i--;
                }
                
                i--;

            }
        }
        return sb.toString();
    }
}