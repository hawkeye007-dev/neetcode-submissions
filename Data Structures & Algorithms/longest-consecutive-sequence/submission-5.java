class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seen = new HashSet<>() ;
        for(int i = 0 ; i < nums.length ; i++){
            seen.add(nums[i]);
        }

        int max = 0 ;
        for(int num : nums){
            int count = 1 ;
            if(!seen.contains(num-1)){
                while(seen.contains(num+1)){
                    count += 1 ;
                    num++ ;
                }
            }
            if(count > max){
                max = count ;
            }
        }
        return max ;
    }
}
