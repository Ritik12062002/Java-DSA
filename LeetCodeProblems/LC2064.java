class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        Arrays.sort(quantities);
        int left = 1, right = quantities[quantities.length - 1];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(mid, n, quantities)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canDistribute(int maxProductsPerStore, int stores, int[] quantities) {
        int requiredStores = 0;
        
        for (int quantity : quantities) {
            requiredStores += (quantity + maxProductsPerStore - 1) / maxProductsPerStore;
            if (requiredStores > stores) {
                return false;
            }
        }
        
        return true;
    }
}