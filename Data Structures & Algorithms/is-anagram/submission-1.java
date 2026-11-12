class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false ;

        int[] count = new int[26] ;
        int n = s.length() ;
        for(int i = 0 ; i < n ; i++){
            count[s.charAt(i) - 'a']++ ;
            count[t.charAt(i) - 'a']-- ;
        }
        for(int c : count){
            if(c!=0) return false ;
        }
        return true ;
    }
}
