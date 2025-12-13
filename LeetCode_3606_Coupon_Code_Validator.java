class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        // Map to assign priority to each business line for sorting
        Map<String,Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);

        // List to store valid coupons along with their priority
        List<Pair> valid = new ArrayList<>();

        // Iterate through all coupons
        for (int i = 0; i < code.length; i++) {
            // Check if coupon is active, business line is valid, and code is valid
            if (isActive[i] && priority.containsKey(businessLine[i]) && isValidCode(code[i])) {
                // Add valid coupon as a Pair (priority, code)
                valid.add(new Pair(priority.get(businessLine[i]), code[i]));
            }
        }

        // Sort valid coupons first by priority, then lexicographically by code
        Collections.sort(valid, (a, b) -> {
            if (a.priority != b.priority) {
                return a.priority - b.priority; // Sort by priority
            }
            return a.code.compareTo(b.code); // If same priority, sort by code
        });

        // Extract sorted coupon codes into result list
        List<String> result = new ArrayList<>();
        for (Pair pair : valid) {
            result.add(pair.code);
        }
        return result;
    }

    // Helper method to check if a coupon code is valid
    private boolean isValidCode(String code) {
        if (code.length() == 0) {
            return false; // Code must not be empty
        }
        for (char ch : code.toCharArray()) {
            // Code must be alphanumeric or underscore
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                return false;
            }
        }
        return true;
    }

    // Helper class to store coupon's priority and code together
    class Pair {
        int priority;
        String code;
        Pair(int priority, String code) {
            this.priority = priority;
            this.code = code;
        }
    }
}
