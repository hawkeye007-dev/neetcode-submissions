class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1 ;
        int right = 0 ;
        for(int p : piles){
            if(p>right) right = p ;
        }

        while(left < right){
            int mid = left + (right-left)/2 ;
            int hours = 0;
            for(int p : piles){
                hours += p / mid;
                if (p % mid != 0) hours++;
            }
            if(hours<=h) right = mid ;
            else left = mid + 1 ;
        }
        return left ;
    }
}
