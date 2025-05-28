class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length; // Get the number of words
        int dp[] = new int[n]; // Array to store the length of the longest subsequence ending at each index
        int prev[] = new int[n]; // Array to store the previous index in the optimal subsequence
        List<String> result = new ArrayList<>(); // List to store the final result

        // Initialize dp and prev arrays
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Each word can be a subsequence of length 1
            prev[i] = -1; // No previous index initially
        }

        // Fill dp and prev arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if words[i] and words[j] can form a valid subsequence
                if (words[i].length() == words[j].length() && groups[i] != groups[j] && hammingdistance(words[i], words[j]) == 1) {
                    // Update dp[i] if a longer subsequence is found
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1; // Update the length of the longest subsequence
                        prev[i] = j; // Update the previous index for reconstruction
                    }
                }
            }
        }

        // Find the maximum length of subsequence
        int maxlength = 0; // Variable to track the maximum length found
        int maxindex = -1; // Variable to track the index of the last word in the longest subsequence

        for (int i = 0; i < n; i++) {
            if (dp[i] > maxlength) {
                maxlength = dp[i]; // Update maximum length
                maxindex = i; // Update the index of the last word in the longest subsequence
            }
        }

        // Reconstruct the longest subsequence
        while (maxindex != -1) {
            result.add(0, words[maxindex]); // Add the word at maxindex to the front of the result list
            maxindex = prev[maxindex]; // Move to the previous index
        }

        return result; // Return the longest subsequence
    }

    // Helper function to calculate Hamming distance
    private int hammingdistance(String words1, String words2) {
        if (words1.length() != words2.length()) {
            return Integer.MAX_VALUE; // Return a large value if lengths are not equal
        }
        int distance = 0; // Initialize distance counter
        for (int i = 0; i < words1.length(); i++) {
            if (words1.charAt(i) != words2.charAt(i)) {
                distance++; // Increment distance for each differing character
            }
        }
        return distance; // Return the calculated Hamming distance
    }
}
