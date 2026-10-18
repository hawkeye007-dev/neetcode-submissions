class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) ->
            a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] dp = new int[envelopes.length];
        int len = 0;

        for (int[] e : envelopes) {
            int idx = Arrays.binarySearch(dp, 0, len, e[1]);
            if (idx < 0) idx = -(idx + 1);
            dp[idx] = e[1];
            if (idx == len) len++;
        }

        return len;
    }
}