class Solution {
    public int appendCharacters(String s, String t) {
        char[] checklist = t.toCharArray() ;
        int i = 0 ;
        for(char c : s.toCharArray()){
            if (i < checklist.length && c == checklist[i]){
                i+= 1 ;
            }
        }
        return checklist.length - i ;
    }
}