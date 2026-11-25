class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n-k+1];
        int max = nums[0];

        for (int i = 0; i < k; i++)
            max = Math.max(max, nums[i]);

        arr[0] = max;

        for (int i = k; i < n; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else if (nums[i-k] == max) {
                max = nums[i];

                for (int j = i-k+1; j < i; j++)
                    max = Math.max(max, nums[j]);
            }

            arr[i-k+1] = max;
        }

        return arr;
    }
}