class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<String> si = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);

            String sorted = new String(chars);

            int index = si.indexOf(sorted);

            if (index == -1) {
                si.add(sorted);

                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                res.add(group);
            } else {
                res.get(index).add(strs[i]);
            }
        }

        return res;
    }
}