class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;     
        int total = 0;    
        int start = 0;    

        for (int i = 0; i < gas.length; i++) {
            int consume = gas[i] - cost[i];
            tank += consume;
            total += consume;

    

            // If the tank is negative, it means starting from 'start' to 'i' is not possible.
            // Reset the starting index to 'i + 1' and reset the tank.
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ? start : -1;
    }
}