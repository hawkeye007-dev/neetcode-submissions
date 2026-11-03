class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] count = new int[n];
        int[] depth = new int[n];

        for (int i = 0; i < n; i++) {
            count[favorite[i]]++;
            depth[i] = 1;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (count[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int i = q.poll();
            int j = favorite[i];

            depth[j] = Math.max(depth[j], depth[i] + 1);

            count[j]--;

            if (count[j] == 0) q.offer(j);
        }

        int longestCycle = 0;
        int pairs = 0;

        for (int i = 0; i < n; i++) {
            if (count[i] == 0) continue;

            if (favorite[favorite[i]] == i) {
                pairs += depth[i] + depth[favorite[i]];
                count[i] = 0;
                count[favorite[i]] = 0;
            } else {
                int len = 0;
                int j = i;

                while (count[j] != 0) {
                    count[j] = 0;
                    len++;
                    j = favorite[j];
                }

                longestCycle = Math.max(longestCycle, len);
            }
        }

        return Math.max(longestCycle, pairs);
    }
}