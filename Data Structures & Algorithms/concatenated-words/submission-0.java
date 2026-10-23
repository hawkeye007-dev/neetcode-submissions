class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (canForm(word, set)) {
                res.add(word);
            }
            set.add(word);
        }

        return res;
    }

    private boolean canForm(String word, Set<String> set) {
        int n = word.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}