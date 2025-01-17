class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Initialize a stack to keep track of surviving asteroids after collisions
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through each asteroid in the input array
        for (int i=0;i<asteroids.length;i++) {
            // If the asteroid is moving to the right (positive value), push it onto the stack
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } 
            // If the asteroid is moving to the left (negative value)
            else {
                // Handle potential collisions with right-moving asteroids
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();
                }
                // If both asteroids are of equal size, both explode
                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroids[i])) {
                        stack.pop(); // Remove the right-moving asteroid
                }
                // If the stack is empty or the top of the stack is a left-moving asteroid,
                // the current left-moving asteroid survives and is pushed onto the stack
                else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                }
            }
        }
        
        // Prepare the result array to hold the surviving asteroids
        int[] after_collision = new int[stack.size()];
        // Pop the remaining asteroids from the stack into the result array
        for (int i = stack.size() - 1; i >= 0; i--) {
            after_collision[i] = stack.pop(); // Fill the result array in reverse order
        }
        
        return after_collision; // Return the array of surviving asteroids
    }
}
