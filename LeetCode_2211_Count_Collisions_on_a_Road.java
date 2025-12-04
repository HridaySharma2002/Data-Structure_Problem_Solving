class Solution {
    public int countCollisions(String directions) {
        // Initialize collision count to zero
        int col = 0;
        
        // Initialize two pointers: left starts at beginning, right at end of string
        int left = 0;
        int right = directions.length() - 1;
        
        // If there is only one car, no collisions can occur
        if (directions.length() == 1) {
            return 0;
        }
        
        // Move left pointer forward while cars are moving left ('L') at the start,
        // because these cars will never collide (they move away from others)
        while (left <= right && directions.charAt(left) == 'L') {
            left++;
        }
        
        // Move right pointer backward while cars are moving right ('R') at the end,
        // because these cars will never collide (they move away from others)
        while (right >= left && directions.charAt(right) == 'R') {
            right--;
        }
        
        // Count all cars between left and right pointers that are not stationary ('S')
        // These cars will eventually collide because they are "trapped" between others
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                col++;
            }
        }
        
        // Return the total number of collisions counted
        return col;
    }
}
