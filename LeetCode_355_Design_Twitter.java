class Twitter {
    // Global timestamp to track the order of tweets
    private static int timestamp = 0;

    // Map to store the followers of each user
    // Key: userId, Value: Set of userIds that the user is following
    private Map<Integer, Set<Integer>> followers;

    // Map to store the tweets of each user
    // Key: userId, Value: List of Tweet objects representing the user's tweets
    private Map<Integer, List<Tweet>> tweets;

    // Inner class to represent a Tweet
    class Tweet {
        int tweetId; // Unique ID of the tweet
        int time;    // Timestamp when the tweet was posted

        // Constructor to initialize a Tweet object
        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    // Constructor to initialize the Twitter object
    public Twitter() {
        followers = new HashMap<>(); // Initialize the followers map
        tweets = new HashMap<>();    // Initialize the tweets map
    }

    // Method to post a tweet
    public void postTweet(int userId, int tweetId) {
        // If the user has not posted any tweets before, initialize their tweet list
        tweets.putIfAbsent(userId, new ArrayList<>());

        // Add the new tweet to the user's tweet list with the current timestamp
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    // Method to retrieve the 10 most recent tweets in the user's news feed
    public List<Integer> getNewsFeed(int userId) {
        // PriorityQueue (min-heap) to store tweets based on their timestamp
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        // Get the set of users that the given user is following
        // If the user is not following anyone, return an empty set by default
        Set<Integer> users = followers.getOrDefault(userId, new HashSet<>());

        // Add the user's own ID to include their own tweets in the news feed
        users.add(userId);

        // Iterate through all users (including the user themselves)
        for (int user : users) {
            // Get the list of tweets for the current user
            List<Tweet> userTweets = tweets.getOrDefault(user, new ArrayList<>());

            // Add each tweet to the priority queue
            for (Tweet tweet : userTweets) {
                pq.offer(tweet);

                // If the size of the priority queue exceeds 10, remove the oldest tweet
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
        }

        // Extract tweets from the priority queue in reverse order (most recent first)
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll().tweetId); // Add tweets to the beginning of the result list
        }

        return result; // Return the list of tweet IDs
    }

    // Method to follow a user
    public void follow(int followerId, int followeeId) {
        // If the followerId is the same as the followeeId, do nothing (a user cannot follow themselves)
        if (followerId == followeeId) {
            return;
        }

        // If the followerId does not exist in the followers map, initialize their followee set
        followers.putIfAbsent(followerId, new HashSet<>());

        // Add the followeeId to the followerId's set of followed users
        followers.get(followerId).add(followeeId);
    }

    // Method to unfollow a user
    public void unfollow(int followerId, int followeeId) {
        // If the followerId exists in the followers map, remove the followeeId from their followee set
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId, tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId, followeeId);
 * obj.unfollow(followerId, followeeId);
 */
