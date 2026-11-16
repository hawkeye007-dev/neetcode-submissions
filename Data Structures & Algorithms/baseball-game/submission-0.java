class Solution {
    public int calPoints(String[] operations) {
        int[] arr = new int[operations.length];
        int idx = 0, sum = 0;

        for (String op : operations) {
            if (op.equals("+")) {
                arr[idx] = arr[idx - 1] + arr[idx - 2];
                idx++;
            } else if (op.equals("D")) {
                arr[idx] = 2 * arr[idx - 1];
                idx++;
            } else if (op.equals("C")) {
                idx--;
            } else {
                arr[idx++] = Integer.parseInt(op);
            }
        }

        for (int i = 0; i < idx; i++) {
            sum += arr[i];
        }

        return sum;
    }
}