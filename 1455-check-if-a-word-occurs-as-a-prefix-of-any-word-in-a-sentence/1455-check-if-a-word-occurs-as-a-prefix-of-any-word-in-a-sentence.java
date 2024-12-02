class Solution {
    public int isPrefixOfWord(String sentence, String c) {
        
        String [] words=  sentence.split(" ");
        
        for(int i=0; i< words.length ;i++)
        {
            if(words[i].startsWith(c))
            {
                return i+1;
            }
        }
        
        return -1;
        
    }
}