class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // Set for exact word matches (case-sensitive)
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        
        // Map for case-insensitive matches: lower-case word -> original word
        Map<String, String> caseMap = new HashMap<>();
        
        // Map for vowel-error matches: devoweled lower-case word -> original word
        Map<String, String> vowelMap = new HashMap<>();

        // Preprocess the wordlist to fill the maps
        for (String w : wordlist) {
            String lower = toLower(w);           // Convert word to lower-case
            String devowel = deVowel(lower);     // Replace vowels with '*'
            // Only put the first occurrence to preserve order
            caseMap.putIfAbsent(lower, w);
            vowelMap.putIfAbsent(devowel, w);
        }

        // Prepare the result array for answers
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            // 1. Exact match (case-sensitive)
            if (exact.contains(q)) {
                result[i] = q;
            } else {
                String lower = toLower(q);
                String devowel = deVowel(lower);
                // 2. Case-insensitive match
                if (caseMap.containsKey(lower)) result[i] = caseMap.get(lower);
                // 3. Vowel-error match
                else if (vowelMap.containsKey(devowel)) result[i] = vowelMap.get(devowel);
                // 4. No match found
                else result[i] = "";
            }
        }
        return result;
    }

    // Helper to convert a string to lower-case
    private String toLower(String s) {
        return s.toLowerCase();
    }

    // Helper to replace all vowels in a string with '*'
    private String deVowel(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (isVowel(ch[i])) ch[i] = '*';
        }
        return new String(ch);
    }

    // Helper to check if a character is a vowel (case-insensitive)
    private boolean isVowel(char c) {
        return "aeiou".indexOf(Character.toLowerCase(c)) >= 0;
    }
}
