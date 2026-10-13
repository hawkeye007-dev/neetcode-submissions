class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0 ;
        int n = nums.length ;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > low){
                low = nums[i] ;
            }
            high += nums[i] ;
        }

        while(low<high){
            int mid = (low+high)/2 ;
            int count = 1;
            int temp_sum = 0 ;
            for(int i = 0 ; i < n ; i++){
                if(temp_sum + nums[i] <= mid){
                    temp_sum += nums[i] ;
                }
                else{
                    temp_sum = nums[i]; ;
                    count+=1 ;
                }
            }
            if(count <= k){
                high = mid ;
            }
            if(count > k){
                low = mid + 1;
            }
            if(low == high){
                return low ;
            }
        }
        return low  ;
    }
}