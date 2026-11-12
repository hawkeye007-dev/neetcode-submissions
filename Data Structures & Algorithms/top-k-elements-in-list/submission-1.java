class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int[] counts = new int[freq.size()];
        int idx = 0;
        for (int val : freq.values()) {
            counts[idx++] = val;
        }
        Arrays.sort(counts);
        int minFreqNeeded = counts[counts.length - k];
        int[] res = new int[k];
        int resIdx = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() >= minFreqNeeded) {
                res[resIdx++] = entry.getKey();
                if (resIdx == k) break;
            }
        }

        return res;
    }
}
