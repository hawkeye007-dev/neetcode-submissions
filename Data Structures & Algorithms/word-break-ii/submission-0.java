class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(s, 0, words, memo);
    }

    private List<String> dfs(String s, int start, Set<String> words,
                             Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) return memo.get(start);

        List<String> result = new ArrayList<>();

        if (start == s.length()) {
            result.add("");
            return result;
        }

        for (int end = start + 1; end <= Math.min(s.length(), start + 10); end++) {
            String word = s.substring(start, end);

            if (!words.contains(word)) continue;

            for (String suffix : dfs(s, end, words, memo)) {
                result.add(word + (suffix.isEmpty() ? "" : " " + suffix));
            }
        }

        memo.put(start, result);
        return result;
    }
}