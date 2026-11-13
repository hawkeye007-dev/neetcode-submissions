class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length] ;
        int idx = 0 ;
        for(int i : nums1){
            arr[idx++] = i ; 
        }
        for(int i : nums2){
            arr[idx++] = i ; 
        }
        Arrays.sort(arr);

        int n = arr.length;

        if (n % 2 == 1)
            return arr[n / 2];

        return ((double) arr[n / 2 - 1] + arr[n / 2]) / 2;
    }
}
