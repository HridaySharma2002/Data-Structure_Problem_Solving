class Solution {
    public String clearStars(String s) {
        // Create a StringBuilder to hold the result, initialized with the input string
        StringBuilder result = new StringBuilder(s);
        
        // Create an array of lists to store indices of each character ('a' to 'z')
        List<Integer>[] buckets = new List[26];

        // Initialize each bucket as an empty ArrayList
        for (int i = 0; i < 26; ++i) {
            buckets[i] = new ArrayList<>();
        }

        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); ++i) {
            // Check if the current character is a '*'
            if (s.charAt(i) == '*') {
                // Mark the position of '*' in the result as a space
                result.setCharAt(i, ' ');

                // Find the first non-empty bucket (which contains indices of characters)
                int j = 0;
                while (buckets[j].isEmpty()) {
                    j++; // Increment j until a non-empty bucket is found
                }

                // Remove the last index from the found bucket and mark that position as a space
                result.setCharAt(buckets[j].remove(buckets[j].size() - 1), ' ');
            } else {
                // If it's a regular character, add its index to the corresponding bucket
                buckets[s.charAt(i) - 'a'].add(i);
            }
        }

        // Convert the StringBuilder to a string and remove all spaces
        return result.toString().replaceAll(" ", "");
    }
}
