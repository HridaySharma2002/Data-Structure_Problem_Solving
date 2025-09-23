class Solution {
    public int compareVersion(String version1, String version2) {
        // Initialize pointers for both version strings
        int i1 = 0;
        int i2 = 0;
        // Get the lengths of both version strings
        int n1 = version1.length();
        int n2 = version2.length();
        
        // Loop until both pointers reach the end of their respective strings
        while (i1 < n1 || i2 < n2) {
            int v1 = 0; // To store the current revision number from version1
            int v2 = 0; // To store the current revision number from version2
            
            // Parse the next revision number from version1 until '.' or end of string
            while (i1 < n1 && version1.charAt(i1) != '.') {
                v1 = v1 * 10 + (version1.charAt(i1) - '0');
                i1++;
            }
            
            // Parse the next revision number from version2 until '.' or end of string
            while (i2 < n2 && version2.charAt(i2) != '.') {
                v2 = v2 * 10 + (version2.charAt(i2) - '0');
                i2++;
            }
            
            // Compare the two revision numbers
            if (v1 < v2) {
                return -1; // version1 is smaller
            }
            if (v1 > v2) {
                return 1;  // version1 is greater
            }
            
            // Move past the '.' delimiter for the next revision number
            i1++;
            i2++;
        }
        
        // All revisions are equal
        return 0;
    }
}
