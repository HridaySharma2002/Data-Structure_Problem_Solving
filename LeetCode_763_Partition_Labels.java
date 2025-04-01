class Solution {
    public List<Integer> partitionLabels(String s) {
        // Step 1: Create an array to store the last occurrence of each character
        int[] last_occurence = new int[26]; // Array to hold the last index of each character (a-z)
        
        // Populate the last occurrence array
        for (int i = 0; i < s.length(); i++) {
            // Update the last occurrence index for the character at position i
            last_occurence[s.charAt(i) - 'a'] = i;
        }

        // Step 2: Initialize variables for partitioning
        int start = 0; // Start index of the current partition
        int end = 0;   // End index of the current partition
        List<Integer> result = new ArrayList<>(); // List to store the sizes of the partitions

        // Step 3: Iterate through the string to find partitions
        for (int i = 0; i < s.length(); i++) {
            // Update the end index to the maximum last occurrence of the current character
            end = Math.max(end, last_occurence[s.charAt(i) - 'a']);
            
            // If the current index reaches the end of the partition
            if (i == end) {
                // Calculate the size of the current partition and add it to the result list
                result.add(end - start + 1);
                // Move to the next partition by updating the start index
                start = i + 1;
            }
        }

        // Step 4: Return the list of partition sizes
        return result;
    }
}
