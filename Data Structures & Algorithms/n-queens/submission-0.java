class Solution {
    List<List<String>> ans = new ArrayList<>();
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        int[] queens = new int[n];
        solve(0, 0, 0, 0, queens);
        return ans;
    }

    void solve(int row, int cols, int d1, int d2, int[] queens) {
        if (row == n) {
            List<String> board = new ArrayList<>();
            for (int c : queens) {
                char[] arr = new char[n];
                Arrays.fill(arr, '.');
                arr[c] = 'Q';
                board.add(new String(arr));
            }
            ans.add(board);
            return;
        }

        int available = ((1 << n) - 1) & ~(cols | d1 | d2);

        while (available != 0) {
            int bit = available & -available;
            available -= bit;

            queens[row] = Integer.bitCount(bit - 1);

            solve(row + 1,
                  cols | bit,
                  (d1 | bit) << 1,
                  (d2 | bit) >> 1,
                  queens);
        }
    }
}