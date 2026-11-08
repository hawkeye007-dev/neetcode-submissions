class Solution {
    public int partitionString(String s) {
        int count=1;
        Map<Character,Integer>mp=new HashMap<>();
        for(char c:s.toCharArray()){
            if(mp.containsKey(c)){
                mp=new HashMap<>();count++;
            }
            mp.put(c,1);
        }
        return count;
    }
}
