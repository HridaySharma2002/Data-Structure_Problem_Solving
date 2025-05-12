class Solution {
    public String pushDominoes(String dominoes) {
        // Add boundaries 'L' at the start and 'R' at the end to handle edge cases
        dominoes = "L" + dominoes + "R";
        int prev = 0; // Initialize previous index of a non-dot character
        StringBuilder res = new StringBuilder(); // StringBuilder to build the result

        // Iterate through the dominoes string starting from the first character
        for (int cur = 1; cur < dominoes.length(); cur++) {
            // Skip if the current character is a dot
            if (dominoes.charAt(cur) == '.') {
                continue;
            }

            // Calculate the number of dots (span) between the last non-dot character and the current one
            int span = cur - prev - 1;

            // If prev is greater than 0, append the character at prev to the result
            if (prev > 0) {
                res.append(dominoes.charAt(prev));
            }

            // Check if both characters are the same (either both 'L' or both 'R')
            if (dominoes.charAt(prev) == dominoes.charAt(cur)) {
                // Fill the span with the same character
                for (int i = 0; i < span; i++) {
                    res.append(dominoes.charAt(prev));
                }
            }
            // Check for the case where 'L' is followed by 'R'
            else if (dominoes.charAt(prev) == 'L' && dominoes.charAt(cur) == 'R') {
                // Fill the span with dots since they cancel each other out
                for (int i = 0; i < span; i++) {
                    res.append('.');
                }
            }
            // Handle the case where 'R' is followed by 'L'
            else {
                // Fill half of the span with 'R'
                for (int i = 0; i < span / 2; i++) {
                    res.append('R');
                }
                // If the span is odd, add a dot in the middle
                if (span % 2 == 1) {
                    res.append('.');
                }
                // Fill the other half of the span with 'L'
                for (int i = 0; i < span / 2; i++) {
                    res.append('L');
                }
            }
            // Update prev to the current index
            prev = cur;
        }
        // Return the final result as a string
        return res.toString();
    }
}
