class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // List to store starting indices of anagrams of p in s
        List<Integer> result = new ArrayList<>();
        
        // Frequency arrays for characters in s (current window) and p
        int s_freq[] = new int[26];
        int p_freq[] = new int[26];
        
        // Count frequency of each character in p
        for (char ch : p.toCharArray()) {
            p_freq[ch - 'a']++;
        }
        
        // Iterate over string s with a sliding window
        for (int i = 0; i < s.length(); i++) {
            // Add current character to s_freq frequency array
            s_freq[s.charAt(i) - 'a']++;
            
            // Once window size exceeds length of p, remove the leftmost character
            if (i >= p.length()) {
                s_freq[s.charAt(i - p.length()) - 'a']--;
            }
            
            // Check if current window's frequency matches p's frequency
            if (arecountequal(p_freq, s_freq)) {
                // If yes, add the start index of this anagram substring to result
                result.add(i - p.length() + 1);
            }
        }
        
        // Return all starting indices of anagrams found
        return result;
    }
    
    // Helper method to compare two frequency arrays
    private boolean arecountequal(int arr1[], int arr2[]) {
        // Compare frequency of each character from 'a' to 'z'
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                // If any frequency differs, arrays are not equal
                return false;
            }
        }
        // All frequencies match, arrays are equal
        return true;
    }
}
