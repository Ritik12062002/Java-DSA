
class GfG
{
    int maxLen(int arr[], int n)
    {
        int maxL=0; 
        int sum=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<n;i++){
            
            sum += arr[i];
            
            
            if(sum==0)
            maxL=i+1;
            
            
            if(hm.containsKey(sum)){
                maxL=Math.max(maxL,i-hm.get(sum));
            }else{
                hm.put(sum,i);
            }
        }
        
        return maxL;
    }
}