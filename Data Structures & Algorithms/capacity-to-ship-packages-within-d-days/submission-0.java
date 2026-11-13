class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int daysNeeded = 1, load = 0;

            for (int w : weights) {
                if (load + w > mid) {
                    daysNeeded++;
                    load = 0;
                }
                load += w;
            }

            if (daysNeeded <= days)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}