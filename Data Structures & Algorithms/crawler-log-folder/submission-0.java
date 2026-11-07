public class Solution {
    public int minOperations(String[] logs) {
        int res = 0;
        for (String log : logs) {
            if (log.equals("./")) {
                continue;
            }
            if (log.equals("../")) {
                res = Math.max(0, res - 1);
            } else {
                res++;
            }
        }
        return res;
    }
}