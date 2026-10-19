class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length ;
        int max = 0;
        int l = 0 ;
        int r = n-1 ;
        while(l<r){
            int area = Math.min(heights[l], heights[r]) * (r - l);
            max = Math.max(max , area) ;
            if(heights[l] <= heights[r]){
                l++ ;
            }
            else {
                r-- ;
            }
        }
        return max ;
    }
}
