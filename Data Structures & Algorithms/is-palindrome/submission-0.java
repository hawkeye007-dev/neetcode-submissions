class Solution {
    public boolean isPalindrome(String s) {
        String onlyLetters = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""); 
        char first , last ;
        int n = onlyLetters.length() ;
        for(int i = 0 ; i < n / 2 ; i++){
            first = onlyLetters.charAt(i) ;
            last = onlyLetters.charAt(n-1-i);
            if(first != last){
                return false ;
            }
        }
        return true ;
    }
}
