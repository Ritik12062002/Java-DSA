class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Step 1: Find the longest non-decreasing prefix
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        
        // If the whole array is already non-decreasing, no removal is needed
        if (left == n - 1) return 0;

        // Step 2: Find the longest non-decreasing suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        
        // Step 3: Calculate minimum length to remove by removing everything between left and right
        int minLength = Math.min(n - left - 1, right);

        // Step 4: Try to merge part of the prefix with the suffix
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                minLength = Math.min(minLength, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return minLength;
    }
}


