class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int l = 0, r = 0, cnt = 0;

        int count[] = new int[3];

        while (r < n) {
            if (s.charAt(r) == 'a' || s.charAt(r) == 'b' || s.charAt(r) == 'c') {
                count[s.charAt(r) - 'a']++;
            }

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                cnt += n - r;
                count[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }

        return cnt;
    }
}