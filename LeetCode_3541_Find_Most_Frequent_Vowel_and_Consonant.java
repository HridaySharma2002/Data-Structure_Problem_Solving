class Solution {
    public int maxFreqSum(String s) {
        // Array to store frequency of each letter 'a' to 'z'
        int freq[] = new int[26];
        
        // Count frequency of each character in the string
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Boolean array to mark vowels for quick lookup
        boolean vowels[] = new boolean[26];
        vowels['a' - 'a'] = true;
        vowels['e' - 'a'] = true;
        vowels['i' - 'a'] = true;
        vowels['o' - 'a'] = true;
        vowels['u' - 'a'] = true;

        // Variables to track max frequency among vowels and consonants
        int maxvowelsfreq = 0;
        int maxconsonantsfreq = 0;

        // Iterate over all letters to find max vowel and consonant frequencies
        for (int i = 0; i < 26; i++) {
            if (vowels[i]) {
                // Update max vowel frequency if current vowel frequency is higher
                if (freq[i] > maxvowelsfreq) {
                    maxvowelsfreq = freq[i];
                }
            } else {
                // Update max consonant frequency if current consonant frequency is higher
                if (freq[i] > maxconsonantsfreq) {
                    maxconsonantsfreq = freq[i];
                }
            }
        }

        // Return sum of max vowel frequency and max consonant frequency
        return maxvowelsfreq + maxconsonantsfreq;
    }
}
