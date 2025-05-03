class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int candidate1 = tops[0];
        int candidate2 = bottoms[0];

        int rotations = check(candidate1, tops, bottoms);
        if (rotations != -1) {
            return rotations;
        } else {
            return check(candidate2, tops, bottoms);
        }
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int rotationTop = 0;
        int rotationBottom = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1; // Cannot make all equal to target
            } else if (tops[i] != target) {
                rotationTop++; // Need to rotate to bring target to top
            } else if (bottoms[i] != target) {
                rotationBottom++; // Need to rotate to bring target to bottom
            }
        }
        return Math.min(rotationTop, rotationBottom);
}
}