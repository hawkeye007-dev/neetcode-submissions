class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] a = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            a[magazine.charAt(i) - 'a']++; 
            if (i < ransomNote.length()) {
                a[ransomNote.charAt(i) - 'a']--;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            if (a[i] < 0) return false;
        }
        return true ;
    }
}