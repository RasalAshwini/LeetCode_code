class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");

        for(int i=0; i<words.length;i++){

            char lChar = words[i].charAt(words[i].length()-1);

            char fChar = words[(i+1)%words.length].charAt(0);

            if(lChar!=fChar){
                return false;
            }
        }

        return true;
}
}