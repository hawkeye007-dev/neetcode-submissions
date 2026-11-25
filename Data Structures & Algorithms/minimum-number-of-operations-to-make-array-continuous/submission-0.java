public class Solution {
    public int minOperations(int[] nums) {
        int N = nums.length;
        int res = Integer.MAX_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Integer[] sortedNums = set.toArray(new Integer[0]);
        int n = sortedNums.length;

        for (int i = 0; i < n; i++) {
            int l = i, r = n;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (sortedNums[mid] < sortedNums[i] + N) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int noChange = l - i;
            res = Math.min(res, N - noChange);
        }

        return res;
    }
}