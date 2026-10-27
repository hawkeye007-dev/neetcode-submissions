class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            left = Math.max(left, lastSeen[currentChar]);
            lastSeen[currentChar] = right + 1;
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}