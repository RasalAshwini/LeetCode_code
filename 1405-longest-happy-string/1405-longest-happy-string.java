class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq= new PriorityQueue<>((x,y)->y.num-x.num);
        if(a>0)
        {
            pq.add(new Pair(a,'a'));
        }
        if(b>0)
        {
            pq.add(new Pair(b,'b'));
        }
        if(c>0)
        {
            pq.add(new Pair(c,'c'));
        }
        StringBuilder result=new StringBuilder();
        while( !pq.isEmpty())
        {
            Pair curr=pq.poll();
            int currCount=curr.num;
            char currChar=curr.c;
            if(result.length() >= 2 && result.charAt(result.length()-1)==currChar && result.charAt(result.length()-2)==currChar)
            {
                if(pq.isEmpty())
                {
                    break;
                }
                Pair next=pq.poll();
                result.append(next.c);
                next.num--;
                if(next.num >0)
                {
                    pq.add(next);
                }
                pq.add(curr);
            }
            else
            {
                result.append(currChar);
                currCount--;
                if(currCount >0 )
                {
                    pq.add(new Pair(currCount,currChar));
                }
            }
        }
        return result.toString();
        
    }
    class Pair{
        int num;
        char c;
        Pair(int num,char c)
        {
            this.num=num;
            this.c=c;
        }
    }
}