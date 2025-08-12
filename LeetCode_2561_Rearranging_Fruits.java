class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        
        // Map to store the net count difference of each fruit between basket1 and basket2
        Map<Integer, Integer> counts = new HashMap<>();
        
        // Count the frequency of each fruit in basket1
        for (int i = 0; i < n; i++) {
            counts.put(basket1[i], counts.getOrDefault(basket1[i], 0) + 1);
        }
        
        // Subtract the frequency of each fruit in basket2
        for (int i = 0; i < n; i++) {
            counts.put(basket2[i], counts.getOrDefault(basket2[i], 0) - 1);
        }

        // List to hold fruits that need to be swapped to balance baskets
        List<Integer> swaps = new ArrayList<>();
        
        // Track the minimum fruit value across both baskets for cost calculation
        int min = Integer.MAX_VALUE;

        // Iterate over the counts map to check feasibility and prepare swaps
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int num = entry.getKey();      // Fruit value
            int count = entry.getValue();  // Net difference in count
            
            // If the difference is odd, it's impossible to balance baskets
            if (count % 2 != 0) {
                return -1;
            }
            
            // Update the minimum fruit value seen so far
            min = Math.min(min, num);

            // Add half the absolute difference times to swaps list
            // Each swap fixes two fruits, so divide by 2
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                swaps.add(num);
            }
        }
        
        // Sort the swaps list to prioritize swapping cheaper fruits first
        Collections.sort(swaps);

        long result = 0;
        
        // Calculate the minimum cost by pairing the smallest fruits to swap
        // For each pair, cost is the minimum of the fruit value or twice the smallest fruit value
        for (int i = 0; i < swaps.size() / 2; i++) {
            result += Math.min(swaps.get(i), min * 2);
        }

        // Return the total minimum cost to make baskets identical
        return result;
    }
}
