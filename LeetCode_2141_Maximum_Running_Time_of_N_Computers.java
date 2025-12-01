class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long total_energy = 0; // Initialize total energy to 0

        // Sum up the total energy available from all batteries
        for (int battery : batteries) {
            total_energy += battery;
        }

        // Sort the batteries in ascending order to process the largest batteries last
        Arrays.sort(batteries);

        // Iterate from the largest battery downwards
        for (int i = batteries.length - 1; i >= 0; i--) {
            // If the current largest battery is greater than the average energy per computer,
            // it cannot be evenly distributed, so we remove it from the pool
            if (batteries[i] > total_energy / n) {
                total_energy -= batteries[i]; // Remove this battery's energy from the total
                n--; // Reduce the number of computers to distribute energy to
            } else {
                // If the current battery can be distributed, stop removing batteries
                break;
            }
        }

        // The maximum running time is the total energy divided evenly among the remaining computers
        return total_energy / n;
    }
}
