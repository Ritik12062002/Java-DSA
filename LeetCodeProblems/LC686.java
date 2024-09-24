class Solution {
    public int repeatedStringMatch(String a, String b) {
          String strA= a;
          int cnt=1;
          int repeat = b.length()/a.length();

          for(int i=0;i<repeat+2;i++){
            if(a.contains(b))  return cnt;
            else{
                a += strA;
                cnt++;
            }
          }

          return -1;
    }

}