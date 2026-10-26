class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        final int rows = matrix.length, cols = matrix[0].length;
        int top = 0, left = 0, bottom = rows - 1, right = cols - 1;

        List<Integer> res = new ArrayList<>();
        while (top <= bottom && left <= right) {
            // First loop (top)
            for (int c = left; c <= right; c++) {
                res.add(matrix[top][c]);
            }
            ++top;
            
            // 2nd loop (right)
            for (int r = top; r <= bottom; r++) {
                res.add(matrix[r][right]);
            }
            --right;

            if (top > bottom || left > right) {
                break;
            }
            // 3rd loop (bottom)
            for (int c = right; c >= left; c--) {
                res.add(matrix[bottom][c]);
            }
            --bottom;

            // 4th loop (left)
            for (int r = bottom; r >= top; r--) {
                res.add(matrix[r][left]);
            }
            ++left;
        }
        return res;
    }
}
