class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        // Sort the tasks and workers arrays to facilitate assignment
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int n = tasks.length; // Number of tasks
        int m = workers.length; // Number of workers
        int low = 0; // Lower bound for binary search
        int high = Math.min(n, m); // Upper bound for binary search (cannot assign more tasks than workers or tasks)

        // Perform binary search to find the maximum number of tasks that can be assigned
        while (low < high) {
            int mid = (low + high + 1) / 2; // Calculate the midpoint
            // Check if it's possible to assign 'mid' tasks
            if (canAssign_tasks(mid, tasks, workers, pills, strength)) {
                low = mid; // If possible, try for more tasks
            } else {
                high = mid - 1; // If not possible, try fewer tasks
            }
        }
        return low; // Return the maximum number of tasks that can be assigned
    }

    public boolean canAssign_tasks(int x, int[] tasks, int[] workers, int pills, int strength) {
        Deque<Integer> queue = new ArrayDeque<>(); // Deque to manage tasks that can be assigned
        int i = 0; // Index for tasks

        // Iterate over the strongest workers for the last 'x' tasks
        for (int j = workers.length - x; j < workers.length; j++) {
            // Add tasks that can be handled by the current worker (with or without a pill)
            while (i < x && tasks[i] <= workers[j] + strength) {
                queue.offer(tasks[i]); // Add task to the queue
                i++; // Move to the next task
            }
            // If there are no tasks left to assign, return false
            if (queue.isEmpty()) {
                return false;
            }
            // If the current worker can handle the easiest task
            if (queue.peekFirst() <= workers[j]) {
                queue.pollFirst(); // Assign the easiest task
            } else if (pills == 0) {
                return false; // No pills left and can't assign the task
            } else {
                pills--; // Use a pill to assign the task
                queue.pollLast(); // Assign the hardest task that can be handled with a pill
            }
        }
        return true; // All tasks can be assigned
    }
}
