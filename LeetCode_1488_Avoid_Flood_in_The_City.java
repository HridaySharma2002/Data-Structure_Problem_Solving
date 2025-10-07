class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int result[] = new int[n];
        // Map to store the last day a lake was filled with rain
        Map<Integer, Integer> lakeToLastRainDay = new HashMap<>();
        // TreeSet to keep track of dry days (days with no rain), sorted for efficient searching
        TreeSet<Integer> dryDays = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                // This is a dry day, add it to dryDays set
                dryDays.add(i);
                // Assign a default lake to dry (1) in case no specific lake needs drying later
                result[i] = 1;
            } else {
                int lake = rains[i];
                // On rainy days, we must output -1
                result[i] = -1;
                
                // If this lake was already full before, we need to dry it before it rains again
                if (lakeToLastRainDay.containsKey(lake)) {
                    // Find the earliest dry day after the last rain day of this lake
                    Integer dryDay = dryDays.higher(lakeToLastRainDay.get(lake));
                    if (dryDay == null) {
                        // No dry day available to prevent flood, return empty array
                        return new int[0];
                    }
                    // Assign the dry day to dry this lake
                    result[dryDay] = lake;
                    // Remove this dry day from available dry days
                    dryDays.remove(dryDay);
                }
                // Update the last rain day for this lake to current day i
                lakeToLastRainDay.put(lake, i);
            }
        }
        return result;
    }
}
