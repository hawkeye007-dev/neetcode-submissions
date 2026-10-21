
class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        int full = (1 << n) - 1;

        int[][] counts = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                counts[i][c - 'a']++;
            }
        }

        int[] dp = new int[full + 1];
        Arrays.fill(dp, 16);
        dp[0] = 0;

        for (int mask = 0; mask < full; mask++) {
            if (dp[mask] == 16) continue;

            int first = 0;
            while ((mask & (1 << first)) != 0) {
                first++;
            }

            for (int[] row : counts) {
                if (row[target.charAt(first) - 'a'] == 0) continue;

                int[] left = row.clone();
                int next = mask;

                for (int j = 0; j < n; j++) {
                    int c = target.charAt(j) - 'a';
                    if ((next & (1 << j)) == 0 && left[c] > 0) {
                        next |= (1 << j);
                        left[c]--;
                    }
                }

                dp[next] = Math.min(dp[next], dp[mask] + 1);
            }
        }

        return dp[full] == 16 ? -1 : dp[full];
    }
}