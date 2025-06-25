class Solution {
    public String answerString(String word, int numFriends) {
        // If there is only one friend, return the entire word as the only possible split
        if(numFriends == 1) {
            return word;
        }
        
        // Initialize an empty string to hold the result
        String result = "";
        
        // Calculate the maximum length of the substring we can take
        // This ensures that we can still split the remaining characters into numFriends parts
        int length = word.length() - numFriends + 1;
        
        // Iterate through each character in the word
        for(int i = 0; i < word.length(); i++) {
            String temp; // Temporary variable to hold the current substring
            
            // Check if we can take a substring of the calculated length from the current index
            if(i + length <= word.length()) {
                // Extract substring from index i to i + length
                temp = word.substring(i, i + length);
            } else {
                // If not enough characters left, take substring from index i to the end of the word
                temp = word.substring(i);
            }
            
            // Compare the current substring with the result
            // If the current substring is lexicographically larger, update the result
            if(temp.compareTo(result) > 0) {
                result = temp;
            }
        }
        
        // Return the lexicographically largest substring found
        return result;
    }
}
