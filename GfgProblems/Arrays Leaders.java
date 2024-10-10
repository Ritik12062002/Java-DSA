

class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int n, int arr[]) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int maxfromLast =arr[n-1];
        ans.add(maxfromLast);
        
        for(int i=n-2; i>=0;i--){
            
            if(arr[i] >= maxfromLast){
                maxfromLast=arr[i];
                ans.add(maxfromLast);
            }
        }
        
        Collections.reverse(ans);
        
        return ans;
        
    }
}