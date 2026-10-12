class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i;
            int length = 0;

            // Step 1: Take as many words as possible
            while (j < words.length &&
                   length + words[j].length() + (j - i) <= maxWidth) {
                length += words[j].length();
                j++;
            }

            int wordCount = j - i;
            int totalSpaces = maxWidth - length;

            StringBuilder line = new StringBuilder();

            // Step 2: Last line or only one word
            if (j == words.length || wordCount == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            }

            // Step 3: Distribute spaces between words
            else {
                int spaces = totalSpaces / (wordCount - 1);
                int extra = totalSpaces % (wordCount - 1);

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        for (int s = 0; s < spaces; s++) {
                            line.append(" ");
                        }

                        if (extra > 0) {
                            line.append(" ");
                            extra--;
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}