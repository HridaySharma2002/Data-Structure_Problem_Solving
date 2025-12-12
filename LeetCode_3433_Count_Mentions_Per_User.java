class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        // Array to store the mention count for each user
        int[] mentions = new int[numberOfUsers];
        // Array to store the last offline timestamp for each user (0 means online)
        int[] offlinetime = new int[numberOfUsers];

        // Sort events by timestamp ascending.
        // If timestamps are equal, process OFFLINE before MESSAGE.
        events.sort((a, b) -> {
            int timea = Integer.parseInt(a.get(1));
            int timeb = Integer.parseInt(b.get(1));
            // If timestamps are equal, OFFLINE comes before MESSAGE (because "OFFLINE" > "MESSAGE" lexicographically)
            return timea == timeb ? b.get(0).compareTo(a.get(0)) : timea - timeb;
        });

        // Process each event in order
        for (List<String> event : events) {
            if (event.get(0).equals("MESSAGE")) {
                // Handle MESSAGE event: update mentions based on tokens
                handleMessage(event, mentions, offlinetime);
            } else if (event.get(0).equals("OFFLINE")) {
                // Handle OFFLINE event: update user's offline timestamp
                handleOffline(event, offlinetime);
            }
        }
        // Return the final mention counts
        return mentions;
    }

    /**
     * Handles a MESSAGE event: parses tokens and updates mention counts.
     * @param event The MESSAGE event: ["MESSAGE", timestamp, mentions_string]
     * @param mentions The array tracking mention counts for each user
     * @param offlinetime The array tracking last offline timestamp for each user
     */
    private void handleMessage(List<String> event, int[] mentions, int[] offlinetime) {
        int timestamp = Integer.parseInt(event.get(1));
        // Split the mentions string into tokens (e.g., "id1 id0", "ALL", "HERE")
        String[] tokens = event.get(2).split(" ");
        for (String token : tokens) {
            if (token.equals("ALL")) {
                // "ALL" mentions every user, regardless of online/offline status
                for (int i = 0; i < mentions.length; i++) {
                    mentions[i]++;
                }
            } else if (token.equals("HERE")) {
                // "HERE" mentions only users who are currently online
                for (int i = 0; i < mentions.length; i++) {
                    // User is online if never went offline, or offline period has expired
                    if (offlinetime[i] == 0 || offlinetime[i] + 60 <= timestamp) {
                        mentions[i]++;
                    }
                }
            } else {
                // "idX" mentions a specific user X (even if offline)
                int id = Integer.parseInt(token.substring(2)); // Extract user ID from "idX"
                mentions[id]++;
            }
        }
    }

    /**
     * Handles an OFFLINE event: updates the user's offline timestamp.
     * @param event The OFFLINE event: ["OFFLINE", timestamp, id]
     * @param offlinetime The array tracking last offline timestamp for each user
     */
    private void handleOffline(List<String> event, int[] offlinetime) {
        int timestamp = Integer.parseInt(event.get(1));
        int id = Integer.parseInt(event.get(2));
        // Mark the time when the user went offline
        offlinetime[id] = timestamp;
        // The user will be considered offline until timestamp + 60
    }
}
