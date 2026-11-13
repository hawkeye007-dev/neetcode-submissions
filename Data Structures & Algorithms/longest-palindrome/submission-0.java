class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128] ;
        for(char c : s.toCharArray()){
            freq[c]++ ;
        }
        int res = 0 ;
        for(int i : freq){
            res += (i/2)*2 ; 
        }
        return res < s.length() ? res+1 : res  ;
    }
}