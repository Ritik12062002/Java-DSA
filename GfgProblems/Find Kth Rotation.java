class Solution {
    public int findKRotation(List<Integer> arr) {
        int low = 0, high = arr.size() - 1;
        int ans = Integer.MAX_VALUE; // Initialize to MAX_VALUE to find the minimum
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If the subarray is sorted, take the minimum of the first element
            if (arr.get(low) <= arr.get(high)) {
                if (arr.get(low) < ans) {
                    index = low;
                    ans = arr.get(low);
                }
                break;
            }

            // Check the left half (sorted half)
            if (arr.get(low) <= arr.get(mid)) {
                if (arr.get(low) < ans) {
                    index = low;
                    ans = arr.get(low);
                }
                low = mid + 1;
            } 
            // Otherwise, check the right half
            else {
                if (arr.get(mid) < ans) {
                    index = mid;
                    ans = arr.get(mid);
                }
                high = mid - 1;
            }
        }

        return index;
    }
}
