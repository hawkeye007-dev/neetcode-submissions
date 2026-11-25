class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length-k+1];

        int right = k-1;
        int max = 0;
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= nums[max])
                max = i;

            if (i == right) {
                arr[counter++] = nums[max];
                right++;

                if (max < right-k+1) {
                    i = right-k;
                    max = i+1;
                }
            }
        }

        return arr;
    }
}