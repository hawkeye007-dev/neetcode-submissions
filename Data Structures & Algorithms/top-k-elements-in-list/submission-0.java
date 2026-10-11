class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int num : count.keySet()) {
            int freq = count.get(num);

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(num);
        }

        int[] res = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    res[index++] = num;

                    if (index == k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }
}