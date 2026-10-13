class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0 ;
        while(i < nums.length){
            int ci = nums[i] - 1 ;
            if(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[ci]){
                int temp = nums[i] ;
                nums[i] = nums[ci] ;
                nums[ci] = temp ;
            }
            else {
                i++ ;
            }
        }

        for(int j = 0 ; j < nums.length ; j++ ){
            if(nums[j] != j+1){
                return j+1 ;
            }
        }
        return nums.length + 1 ;
    }
}