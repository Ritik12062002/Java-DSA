
class Solution{
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i=0,j=0;
        
        while(i<n && j< m){
            
            if(arr1[i] < arr2[j]){
                if(ans.isEmpty() || ans.get(ans.size() -1) != arr1[i]){
                    ans.add(arr1[i]);
                }
                i++;
            }
            
            
            else if(arr2[j] < arr1[i]){
                
                if(ans.isEmpty() || ans.get(ans.size() -1) != arr2[j]){
                    ans.add(arr2[j]);
                }
                j++;
            }
            
            else{
                
                if(ans.isEmpty() || ans.get(ans.size()-1) != arr1[i]){
                    ans.add(arr1[i]);
                }
                
                i++;
                j++;
            }
        }
        
        
        while(i<n){
            
            if(ans.isEmpty() || ans.get(ans.size() -1) != arr1[i]){
                ans.add(arr1[i]);
            }
            i++;
        }
        
        while(j<m){
            
            if(ans.isEmpty() || ans.get(ans.size() -1) != arr2[j]){
                ans.add(arr2[j]);
                
            }
            j++;
        }
        
        Collections.sort(ans);
        return ans;
    }
}

