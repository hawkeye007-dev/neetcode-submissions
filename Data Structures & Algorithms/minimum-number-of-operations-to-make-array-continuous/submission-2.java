public class Solution {
    public int minOperations(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int n = 1;

        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[n] = nums[i];
                n++;
            }
        }

        int l = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] - nums[l] > length - 1) {
                l++;
            }
        }

        return length - (n - l);
    }
}