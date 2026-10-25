class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int n = height.length;
        int l = 0;             
        int r = n - 1;         
        int l_w = height[l];   
        int r_w = height[r];   
        int res = 0;
        
        while (l < r) {        
            if (l_w < r_w) {
                l++;           
                if (l_w < height[l]) {
                    l_w = height[l];
                }
                res += l_w - height[l];
            } else {
                r--;           
                if (r_w < height[r]) {
                    r_w = height[r];
                }
                res += r_w - height[r];
            }
        }
        return res;
    }
}
