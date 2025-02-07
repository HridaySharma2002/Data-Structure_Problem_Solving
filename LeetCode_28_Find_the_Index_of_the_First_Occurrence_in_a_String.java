class Solution {
    public int strStr(String haystack, String needle) {
        // Check if the needle is an empty string
        if (needle.isEmpty()) {
            return 0; // If needle is empty, return 0 as per convention
        }

        // Loop through the haystack until the point where the remaining substring can still fit the needle
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Extract the substring from the haystack starting at index i with the length of the needle
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // If the substring matches the needle, return the starting index
            }
        }
        
        // If no match is found after checking all possible starting positions, return -1
        return -1;
    }
}
