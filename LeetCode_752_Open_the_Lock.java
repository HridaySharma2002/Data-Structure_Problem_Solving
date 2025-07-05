class Solution {
    public int openLock(String[] deadends, String target) {
        // Create a set of deadends for quick lookup
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        
        // If the starting combination "0000" is a deadend, return -1
        if (deadendSet.contains("0000")) {
            return -1;
        }
        
        // Initialize a queue for BFS, starting with the combination "0000" and 0 moves
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>("0000", 0));
        
        // Set to keep track of visited combinations to avoid cycles
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        // Perform BFS until the queue is empty
        while (!queue.isEmpty()) {
            // Get the current combination and the number of moves taken to reach it
            Pair<String, Integer> current = queue.poll();
            String currCombination = current.getKey();
            int moves = current.getValue();

            // Check if the current combination matches the target
            if (currCombination.equals(target)) {
                return moves; // Return the number of moves if target is reached
            }

            // Iterate through each digit of the combination
            for (int i = 0; i < 4; i++) {
                // Try both incrementing and decrementing the current digit
                for (int del : new int[]{-1, 1}) {
                    // Calculate the new digit with wrapping around using modulo 10
                    int newDigit = (currCombination.charAt(i) - '0' + del + 10) % 10;
                    
                    // Form the new combination by replacing the digit at index i
                    String newCombination = currCombination.substring(0, i) +
                                            newDigit +
                                            currCombination.substring(i + 1);
                    
                    // Check if the new combination has not been visited and is not a deadend
                    if (!visited.contains(newCombination) && !deadendSet.contains(newCombination)) {
                        // Add the new combination to the queue with incremented move count
                        queue.offer(new Pair<>(newCombination, moves + 1));
                        // Mark the new combination as visited
                        visited.add(newCombination);
                    }
                }
            }
        }
        
        // If the target is not reachable, return -1
        return -1;
    }
}
