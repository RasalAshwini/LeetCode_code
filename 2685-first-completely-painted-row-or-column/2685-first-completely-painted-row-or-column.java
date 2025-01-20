class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        
        // Map each value in mat to its row and column indices
        int[][] position = new int[m * n + 1][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                position[mat[i][j]][0] = i;
                position[mat[i][j]][1] = j;
            }
        }
        
        // Arrays to track the paint count for rows and columns
        int[] rowPaint = new int[m];
        int[] colPaint = new int[n];
        
        // Process each number in arr
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int row = position[num][0];
            int col = position[num][1];
            
            // Increment the paint counts for the row and column
            rowPaint[row]++;
            colPaint[col]++;
            
            // Check if any row or column is completely painted
            if (rowPaint[row] == n || colPaint[col] == m) {
                return i;
            }
        }
        
        return -1; // Should never reach here since a row or column will always be completed
}
}