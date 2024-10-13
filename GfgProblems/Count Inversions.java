class Solution {
    static long inversionCount(long arr[]) {
        return mergesort(arr, 0, arr.length - 1);
    }

    public static long mergesort(long arr[], int low, int high) {
        long cnt = 0;
        
        if (low >= high) return cnt;
        
        int mid = (low + high) / 2;
        
        cnt += mergesort(arr, low, mid);
        cnt += mergesort(arr, mid + 1, high);
        cnt += merge(arr, low, mid, high);
        
        return cnt;
    }

    public static long merge(long arr[], int low, int mid, int high) {
        ArrayList<Long> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        long cnt = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return cnt;
    }
}
