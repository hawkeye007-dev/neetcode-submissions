class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer>  map = new HashMap<>();
        int i = 0;
        while(i<nums.length){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            else{
                map.put(target-nums[i], i);
                i++;
            }
        }
        return new int[]{-i, -i};

        
    }
}
