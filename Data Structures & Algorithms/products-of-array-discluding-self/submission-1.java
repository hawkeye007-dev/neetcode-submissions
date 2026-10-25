class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length ;
        int[] prefix = new int[n+1] ;
        int[] suffix = new int[n+1] ;
        int[] res = new int[n] ;
        prefix[0] = 1;
        suffix[n] = 1;


        for(int i = n-1 ; i >= 0 ; i--){
            suffix[i] = suffix[i+1] * nums[i] ;
        }
        for(int i = 0 ; i < n ; i++){
            prefix[i+1] = prefix[i] * nums[i] ;
            res[i] = prefix[i] * suffix[i+1] ;
        }
        return res ;
    }
}  
