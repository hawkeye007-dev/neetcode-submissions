class Solution {
    public long distinctNames(String[] ideas) {
        List<String>[] groups = new ArrayList[26];

        for (int i = 0; i < 26; i++)
            groups[i] = new ArrayList<>();

        for (String s : ideas)
            groups[s.charAt(0) - 'a'].add(s.substring(1));

        for (List<String> group : groups)
            Collections.sort(group);

        long ans = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                List<String> a = groups[i];
                List<String> b = groups[j];

                int x = 0, y = 0, common = 0;

                while (x < a.size() && y < b.size()) {
                    int cmp = a.get(x).compareTo(b.get(y));

                    if (cmp == 0) {
                        common++;
                        x++;
                        y++;
                    } else if (cmp < 0) {
                        x++;
                    } else {
                        y++;
                    }
                }

                long uniqueA = a.size() - common;
                long uniqueB = b.size() - common;

                ans += uniqueA * uniqueB * 2;
            }
        }

        return ans;
    }
}