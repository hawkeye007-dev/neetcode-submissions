class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        int max = 0;
        for(int i = 0; i < hand.length; i++){
            max = Math.max(max, hand[i]);
        }
        int [] count = new int[max + 1];
        for(int i = 0; i < hand.length; i++){
            count[hand[i]]++;
        }
        for(int i = 0; i < count.length; i++){
            while(count[i] != 0){
                for(int j = i; j < i + groupSize; j++){
                    if(j >= count.length || count[j] == 0){
                        return false;
                    }
                    count[j]--;
                }
            }
        }
        return true;
    }
}
