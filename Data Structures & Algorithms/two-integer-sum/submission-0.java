class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value_needed = target - nums[i];

            if (seen.containsKey(value_needed)) {
                return new int[]{seen.get(value_needed), i};
            }

            seen.put(nums[i], i);
        }

        return new int[]{};
    }
}