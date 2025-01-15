class Solution {
    public int minimizeXor(int num1, int num2) {
        int num2SetBits = Integer.bitCount(num2); // Count set bits in num2
        int result = 0;

        // Step 1: Prioritize setting bits in num1 to result
        for (int i = 31; i >= 0 && num2SetBits > 0; i--) {
            if ((num1 & (1 << i)) != 0) { // Check if the ith bit in num1 is set
                result |= (1 << i);      // Set the ith bit in result
                num2SetBits--;          // Reduce the number of set bits to add
            }
        }

        // Step 2: Set remaining bits from the least significant bit
        for (int i = 0; i < 32 && num2SetBits > 0; i++) {
            if ((result & (1 << i)) == 0) { // Check if the ith bit in result is not set
                result |= (1 << i);         // Set the ith bit in result
                num2SetBits--;             // Reduce the number of set bits to add
            }
        }

        return result;
}
}