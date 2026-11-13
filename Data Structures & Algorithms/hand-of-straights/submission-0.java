class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);

        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < hand.length; i++) {
            seen.put(hand[i], seen.getOrDefault(hand[i], 0) + 1);
        }

        for (int i = 0; i < hand.length; i++) {

            int start = hand[i];

            if (seen.get(start) == 0) {
                continue;
            }

            for (int j = 0; j < groupSize; j++) {

                int card = start + j;

                if (seen.getOrDefault(card, 0) == 0) {
                    return false;
                }

                seen.put(card, seen.get(card) - 1);
            }
        }

        return true;
    }
}