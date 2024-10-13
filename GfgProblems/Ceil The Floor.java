class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
         Arrays.sort(arr);
        int floor = -1, ceil = -1;
        int low = 0, high = arr.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (arr[mid] == x) {
                return new int[]{arr[mid], arr[mid]};
            }
            
            if (arr[mid] < x) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }
        
        return new int[]{floor, ceil};
    }
}
