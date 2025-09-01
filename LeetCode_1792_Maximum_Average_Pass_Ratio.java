class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Create a max-heap (priority queue) to always pick the class with the highest increment in pass ratio
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                // Sort by increment in descending order
                if (a[0] < b[0]) return 1;
                if (a[0] > b[0]) return -1;
                return 0;
            }
        });

        // Initialize the priority queue with each class's current pass, total, and increment if an extra student is added
        for (int i = 0; i < classes.length; i++) {
            double pass = classes[i][0]; // current number of passing students
            double total = classes[i][1]; // current total students
            // Calculate the increment in pass ratio if one more passing student is added
            double inc = (pass + 1.0) / (total + 1.0) - pass / total;
            pq.offer(new double[]{inc, pass, total}); // Add to the priority queue
        }

        // Distribute all extra students
        while (extraStudents > 0) {
            // Get the class with the highest increment
            double[] top = pq.poll();
            double pass = top[1] + 1; // Add one passing student
            double total = top[2] + 1; // Increase total students by one
            // Recalculate the increment for this class after adding the student
            double inc = (pass + 1.0) / (total + 1.0) - pass / total;
            pq.offer(new double[]{inc, pass, total}); // Put the updated class back into the queue
            extraStudents--; // One less extra student to assign
        }

        // Calculate the final average pass ratio after all extra students have been assigned
        double sum = 0.0;
        Object[] arr = pq.toArray();
        for (int i = 0; i < arr.length; i++) {
            double[] c = (double[]) arr[i];
            sum += c[1] / c[2]; // Add the pass ratio of each class
        }

        // Return the average pass ratio across all classes
        return sum / classes.length;
    }
}
