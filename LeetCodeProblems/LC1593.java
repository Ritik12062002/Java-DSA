class Solution {
    public int maxUniqueSplit(String s) {
        return splitCount(s,0,new HashSet<>());
    }

    private int splitCount(String s , int start , HashSet<String> seen){
        int maxCount=0;

        for(int i=start+1; i<=s.length() ; i++){

            String substr =s.substring(start,i);

            if(!seen.contains(substr)){
                seen.add(substr);
                maxCount =Math.max(maxCount, 1+splitCount(s,i,seen));
                seen.remove(substr);

            }
        }

        return maxCount;
    }
}