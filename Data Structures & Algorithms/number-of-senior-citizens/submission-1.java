class Solution {
    public int countSeniors(String[] details) {
        int res = 0;
        for (String s : details) {
            if ((s.charAt(11) - '0') * 10 + (s.charAt(12) - '0') > 60) {
                res++;
            }
        }
        return res;
    }
}