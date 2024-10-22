class Solution {
    public boolean rotateString(String s, String goal) {
        char arr1[] = s.toCharArray();
        char arr2[] = goal.toCharArray();
        if(arr1.length!=arr2.length)
        {
            return false;
        }
        for(int i=0;i<s.length();i++)
        {
            if(Arrays.equals(arr1,arr2))
            {
                return true;
            }
            char ch = arr2[0];
            for(int j=0;j<arr2.length-1;j++)
            {
                arr2[j] = arr2[j+1];
            }
            arr2[arr2.length-1] = ch;
        }
        return false;
    }
}