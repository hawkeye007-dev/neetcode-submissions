class Solution {
    public int minOperations(String[] logs) {
        int depth=0;
        for (String string : logs) {
            if (string.equals("../")){
                if(depth!=0)
                    depth--;
                continue;
            }
            if (string.equals("./"))
                continue;
            depth++;
        }
        return depth;
    }
}