class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while(left <= right){
            int mid = left + (right-left)/2 ;
            int days_code = 1 ;
            int load = 0 ;
            for(int w : weights){
                if(load+w > mid){
                    days_code += 1 ;
                    load = 0 ;
                }
                load += w ;
            }

            if(days_code <= days) right = mid - 1 ;
            else left = mid + 1 ;
        }
        return left ;
    }
}