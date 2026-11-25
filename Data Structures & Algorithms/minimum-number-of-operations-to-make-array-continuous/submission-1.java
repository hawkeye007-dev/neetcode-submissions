class Solution {
    public int minOperations(int[] nums) {
        
        int n = nums.length;

        if (n <= 1) return 0;

        ArrayList<Integer> distinctElements = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++)
        {
            if (i < n - 1 && nums[i] == nums[i + 1])
            continue;

            distinctElements.add(nums[i]);
        }
        
        int minOps = n - 1;

        for (int i = 0; i < distinctElements.size(); i++)
        {
            int element = distinctElements.get(i);

            int left = element; 
            int right = element + n - 1;

            int index = binarySearch(distinctElements, right);
            int sizeOfRange = index - i + 1;
            int operationsNeeded = n - sizeOfRange;

            minOps = Math.min(minOps, operationsNeeded);
        }

        return minOps;  
    }

    int binarySearch(ArrayList<Integer> list, int element)
    {
        int left = 0;
        int right = list.size() - 1;

        int answer = list.get(0);

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == element)
            return mid;

            else if (list.get(mid) > element)
            {
                right = mid - 1;
            }
            else if (list.get(mid) < element)
            {
                answer = mid;
                left = mid + 1;
            }
        }

        return answer;
    }
}
