class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        int count = 0;

        for(char c : s.toCharArray()) {
            if(freq[c] == 0) {
                freq[c]++;
            } else {
                freq[c]--;
                count += 2;
            }
        }

        boolean off = false;

        for(int i = 0; i < 128; i++) {
            if(freq[i] == 1 && !off) {
                off = true;
                count++;
                break ;
            }
        }

        return count;
    }
}