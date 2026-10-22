class Solution {
    public String minWindow(String s, String t) {
        int[] counts = new int[128];
        for (char c : t.toCharArray()) counts[c]++;

        int left = 0, count = t.length(), minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            if (counts[s.charAt(right)]-- > 0) count--;

            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                if (++counts[s.charAt(left++)] > 0) count++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}