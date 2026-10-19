class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer> set = new HashSet<>();
       for(int num:nums) set.add(num);
       int max = 0;
     
       for(int num:nums){
        int count = 1;
        if(!set.contains(num-1)){
            while(set.contains(num + 1)){count++;num++;}
        }
        max = Math.max(max,count);
       }
       return max;

    }
}
