class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        
        // pre[i] will store the index of the most recent zero before position i-1 (1-based indexing)
        // pre[0] = -1 as a sentinel value (no zero before start)
        int[] pre = new int[n + 1];
        pre[0] = -1;
        
        // Build the pre array:
        // For each position i in s (0-based),
        // if i == 0 or the previous character is '0', set pre[i+1] = i (current zero position)
        // else inherit the previous zero position pre[i]
        for (int i = 0; i < n; i++) {
            if (i == 0 || (i > 0 && s.charAt(i - 1) == '0')) {
                pre[i + 1] = i;
            } else {
                pre[i + 1] = pre[i];
            }
        }
        
        int result = 0;  // To accumulate the count of substrings with dominant ones
        
        // Iterate over all possible substring end positions i (1-based)
        for (int i = 1; i <= n; i++) {
            // Initialize count of zeros in the current substring ending at i-1
            // If current character is '0', start with 1 zero, else 0 zeros
            int cnt0 = s.charAt(i - 1) == '0' ? 1 : 0;
            
            // j will move backward to find substrings with increasing zeros count
            int j = i;
            
            // While j > 0 and zeros squared is not too large (optimization)
            while (j > 0 && cnt0 * cnt0 <= n) {
                // Calculate number of ones in substring s[pre[j]..i-1]
                // Length of substring = i - pre[j]
                // Number of ones = length - number of zeros (cnt0)
                int cnt1 = (i - pre[j]) - cnt0;
                
                // Check if substring satisfies dominant ones condition:
                // ones >= zeros^2
                if (cnt0 * cnt0 <= cnt1) {
                    // Add the count of valid substrings ending at i-1 with this zero count
                    // Math.min(j - pre[j], cnt1 - cnt0*cnt0 + 1) accounts for overlapping substrings
                    result += Math.min(j - pre[j], cnt1 - cnt0 * cnt0 + 1);
                }
                
                // Move j backward to the previous zero index to consider substrings with more zeros
                j = pre[j];
                
                // Increase zero count as we consider substrings with one more zero
                cnt0++;
            }
        }
        
        return result;  // Return total count of substrings with dominant ones
    }
}
