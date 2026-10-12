class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i + 1;
            int length = words[i].length();

            while (j < words.length &&
                   length + words[j].length() + (j - i) <= maxWidth) {
                length += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            int spaces = maxWidth - length;

            StringBuilder sb = new StringBuilder();

            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    if (k > i) sb.append(" ");
                    sb.append(words[k]);
                }
            } else {
                int each = spaces / gaps;
                int extra = spaces % gaps;

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);

                    if (k < j - 1) {
                        sb.append(" ".repeat(each));

                        if (extra-- > 0) {
                            sb.append(" ");
                        }
                    }
                }
            }

            while (sb.length() < maxWidth) {
                sb.append(" ");
            }

            res.add(sb.toString());
            i = j;
        }

        return res;
    }
}