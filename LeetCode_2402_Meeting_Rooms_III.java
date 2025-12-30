class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by their start time in ascending order
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // count[i] stores how many meetings room i has hosted
        int count[] = new int[n];
        // timer[i] stores the time when room i becomes free (end time of last meeting)
        long timer[] = new long[n];

        int itr = 0; // iterator over meetings array

        // Process each meeting in chronological order
        while (itr < meetings.length) {
            int curr[] = meetings[itr];
            int start = curr[0]; // meeting start time
            int end = curr[1];   // meeting end time
            long durr = end - start; // duration of current meeting

            int room = -1;           // room available at or before meeting start
            long earliest = Long.MAX_VALUE; // earliest time any room becomes free
            int earliest_rooms = -1; // room that becomes free earliest

            // Find a room that is free at or before the meeting start time
            // Also track the room that becomes free the earliest (for delay)
            for (int i = 0; i < n; i++) {
                if (timer[i] < earliest) {
                    earliest = timer[i];
                    earliest_rooms = i;
                }
                if (timer[i] <= start) {
                    // Room i is free before meeting start, assign this room
                    room = i;
                    break; // assign the lowest numbered free room
                }
            }

            if (room != -1) {
                // Room is free at meeting start, schedule meeting normally
                timer[room] = end; // update room's next free time
                count[room]++;     // increment meeting count for this room
            } else {
                // No room free at meeting start, delay meeting to earliest free room's time
                timer[earliest_rooms] += durr; // delay meeting by adding duration to earliest free time
                count[earliest_rooms]++;       // increment meeting count for this room
            }

            itr++; // move to next meeting
        }

        // Find the room with the maximum meetings hosted
        int max = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                idx = i;
            }
        }

        return idx; // return the room number with the most meetings
    }
}
