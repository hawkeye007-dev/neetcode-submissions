class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1 ;
        int suffix = 1 ;

        int[] res = new int[nums.length] ;
        int n = nums.length ;


        for(int i = 0 ; i < n ; i++){
            res[i] = 1 ;
        }

        for(int i = 0 ; i < n ; i++){
            res[i] *= prefix ;
            prefix *= nums[i] ; 
        }
        for(int i = n-1 ; i >= 0 ; i--){
            res[i] *= suffix ;
            suffix *= nums[i] ;
        }
        return res ;
    }
}  
