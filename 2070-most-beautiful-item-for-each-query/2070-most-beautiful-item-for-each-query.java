class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);  
        
        Map<Integer, Integer> priceToMaxBeauty = new HashMap<>();
        int maxBeauty = 0;
        
        for (int[] item : items) {
            maxBeauty = Math.max(maxBeauty, item[1]);
            priceToMaxBeauty.put(item[0], maxBeauty); 
        }
        
        int[] sortedPrices = new int[priceToMaxBeauty.size()];
        int index = 0;
        for (int price : priceToMaxBeauty.keySet()) {
            sortedPrices[index++] = price;
        }
        Arrays.sort(sortedPrices);
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            
            int pos = Arrays.binarySearch(sortedPrices, query);
            if (pos < 0) {
                pos = -pos - 2;  
            }
            
            if (pos >= 0) {
                result[i] = priceToMaxBeauty.get(sortedPrices[pos]);
            } else {
                result[i] = 0;
            }
        }
        
        return result;
}
}
