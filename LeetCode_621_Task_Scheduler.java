class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Create an array to count the frequency of each task (A-Z)
        int taskCounts[] = new int[26]; // There are 26 letters in the English alphabet
        for (char task : tasks) {
            // Increment the count for the corresponding task
            taskCounts[task - 'A']++;
        }

        // Step 2: Sort the task frequencies in ascending order
        Arrays.sort(taskCounts); // Sort the array to find the most frequent tasks easily
        int maxFreq = taskCounts[25]; // The task with the highest frequency is at the end of the sorted array

        // Step 3: Calculate the number of idle slots needed
        int idleSlots = (maxFreq - 1) * n; // Calculate idle slots based on the most frequent task

        // Step 4: Fill the idle slots with other tasks
        for (int i = 24; i >= 0; i--) { // Start from the second most frequent task
            // Reduce idle slots by the number of available tasks that can fill the gaps
            idleSlots -= Math.min(taskCounts[i], maxFreq - 1);
        }

        // Step 5: If there are still idle slots left, set them to zero if negative
        idleSlots = Math.max(0, idleSlots); // Ensure idle slots are not negative

        // Step 6: Return the total time required to complete all tasks
        // Total time is the number of tasks plus any remaining idle slots
        return tasks.length + idleSlots; 
    }
}
