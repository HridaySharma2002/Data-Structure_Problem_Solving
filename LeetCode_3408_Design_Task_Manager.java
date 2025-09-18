class TaskManager {
    // Inner class to represent a Task with userId, taskId, and priority
    private static class Task {
        int userId, taskId, priority;
        // Constructor to initialize a Task object
        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    // HashMap to quickly find a Task by its taskId (O(1) lookup)
    private Map<Integer, Task> taskMap;
    // TreeSet to keep all tasks sorted by priority (desc), then taskId (desc)
    private TreeSet<Task> taskSet;

    /**
     * Constructor: Initializes the TaskManager with a list of tasks.
     * Each task is represented as a list: [userId, taskId, priority]
     */
    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        // Custom comparator: higher priority first, then higher taskId first
        taskSet = new TreeSet<>((a, b) -> {
            if (a.priority != b.priority) {
                return b.priority - a.priority; // higher priority first
            }
            return b.taskId - a.taskId; // if tie, higher taskId first
        });
        // Add each initial task to both data structures
        for (List<Integer> t : tasks) {
            int userId = t.get(0);
            int taskId = t.get(1);
            int priority = t.get(2);
            Task task = new Task(userId, taskId, priority);
            taskMap.put(taskId, task);
            taskSet.add(task);
        }
    }
    
    /**
     * Adds a new task for a user with a given priority.
     * The taskId is guaranteed to be unique.
     */
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task); // Add to map for quick lookup
        taskSet.add(task);         // Add to set for ordering
    }
    
    /**
     * Edits the priority of an existing task.
     * Removes the old task from the set, updates its priority, and re-inserts it.
     */
    public void edit(int taskId, int newPriority) {
        Task task = taskMap.get(taskId); // Get the task object
        taskSet.remove(task);            // Remove from set (old priority)
        task.priority = newPriority;     // Update priority
        taskSet.add(task);               // Re-insert with new priority
    }
    
    /**
     * Removes a task from the system by its taskId.
     * Removes from both the map and the set.
     */
    public void rmv(int taskId) {
        Task task = taskMap.remove(taskId); // Remove from map
        taskSet.remove(task);               // Remove from set
    }
    
    /**
     * Executes (removes and returns) the userId of the highest-priority task.
     * If multiple tasks have the same priority, the one with the highest taskId is chosen.
     * Returns -1 if there are no tasks.
     */
    public int execTop() {
        if (taskSet.isEmpty()) {
            return -1; // No tasks to execute
        }
        Task top = taskSet.first();        // Get the top task
        taskSet.remove(top);               // Remove from set
        taskMap.remove(top.taskId);        // Remove from map
        return top.userId;                 // Return the userId of executed task
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
