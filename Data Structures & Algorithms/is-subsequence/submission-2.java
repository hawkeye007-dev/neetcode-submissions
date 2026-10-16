class Solution {
    public boolean isSubsequence(String s, String t) {
        int check = 0 ;
        for(int i = 0 ; i < t.length() ; i++){
            if (check == s.length()) {
                return true;
            }
            if(s.charAt(check) == t.charAt(i)){
                check += 1 ;
            }
        }
        return check == s.length() ;
    }
}