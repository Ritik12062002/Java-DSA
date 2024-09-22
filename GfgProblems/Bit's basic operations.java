class Solution {

   
    public int XOR(int n, int m) { 
        return n ^ m;
    }

   
    public int check(int a, int b) {
        // Convert 1-indexing to 0-indexing by subtracting 1 from a
        if (((b >> (a - 1)) & 1) != 0) {
            return 1;  // a-th bit is 1
        } else {
            return 0;  // a-th bit is 0
        }
    }

    
    public int setBit(int c, int d) {
        return (d | (1 << c));  // Set the c-th bit to 1
    }
}
