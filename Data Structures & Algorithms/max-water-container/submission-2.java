class Solution {
    public int maxArea(int[] heights) {
        int max=0;
        int left=0;
        int right=heights.length-1;
        while (left<right){
            int length=right-left;
            int height = Math.min(heights[left], heights[right]);
            int water = length*height;
            max=Math.max(water, max);
            if (heights[left]<heights[right]){
                left++;
            }
            else right--;
        }
        return max;
    }
}
