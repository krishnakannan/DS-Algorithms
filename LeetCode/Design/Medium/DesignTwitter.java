class Twitter {

    public static Integer sequenceId = 0;

    class Tweet {
        int id;
        int seq;
        int user;
        public Tweet(int id, int user, int seq) {
            this.id = id;
            this.seq = seq;
            this.user = user;
        }        
    }

    Map<Integer, Set<Integer>> userNetwork;
    Map<Integer, Queue<Tweet>> newsFeed;
    Map<Integer, List<Tweet>> userTweets;


    /** Initialize your data structure here. */
    public Twitter() {
        //FollowedBy Relationship
        userNetwork = new HashMap<>();
        newsFeed = new HashMap<>();
        userTweets = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        checkAndAddUser(userId);
        Tweet tweet = new Tweet(tweetId, userId, getSequence()); 
        userTweets.get(userId).add(tweet);
        updateNewsFeed(tweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        checkAndAddUser(userId);
        List<Tweet> recentTweets = new ArrayList<>();
        List<Integer> recentTweetIds = new ArrayList<>();
        Queue<Tweet> userNewsFeed = newsFeed.get(userId);
        int tweetCount = 10;
        while (userNewsFeed != null && !userNewsFeed.isEmpty() && --tweetCount >= 0) {
            Tweet polledTweet = userNewsFeed.poll();
            recentTweets.add(polledTweet);
            recentTweetIds.add(polledTweet.id);
        }

        for (Tweet tweet : recentTweets) {
            userNewsFeed.add(tweet);
        }
        return recentTweetIds;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        checkAndAddUser(followeeId);
        checkAndAddUser(followerId);
        //The graph has FollowedBy relationships. ie Followee -> [Follower1, Follower2..]
        userNetwork.get(followeeId).add(followerId);
        updateNewsFeed(followeeId, followerId, true);        
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }        
        if (userNetwork.containsKey(followeeId)) {
            userNetwork.get(followeeId).remove(followerId);
            updateNewsFeed(followeeId, followerId, false);         
        }
    }

    public void updateNewsFeed(Tweet tweet) {
        Set<Integer> followers = userNetwork.get(tweet.user);
        if (followers != null) {
            for (Integer follower : followers) {            
                newsFeed.get(follower).add(tweet);
            }    
        }        
    }

    public void updateNewsFeed(int followee, int follower, boolean hasFollowed) {
        if (hasFollowed) {
            List<Tweet> followeeTweets = userTweets.get(followee);
            if (followeeTweets != null) {
                for (Tweet followeeTweet : followeeTweets) {
                    if (newsFeed.containsKey(follower) && !newsFeed.get(follower).contains(followeeTweet)) {
                        newsFeed.get(follower).add(followeeTweet);        
                    }                    
                }    
            }            
        } else {
            List<Tweet> followeeTweets = userTweets.get(followee);
            if (followeeTweets != null) {
                for (Tweet followeeTweet : followeeTweets) {
                    if (newsFeed.containsKey(follower)) {
                        newsFeed.get(follower).remove(followeeTweet);       
                    }                    
                }    
            }            
        }
    }

    public void checkAndAddUser(int userId) {
        if (!userNetwork.containsKey(userId)) {
            userNetwork.put(userId, new HashSet<>());
            userNetwork.get(userId).add(userId);
        }

        if (!newsFeed.containsKey(userId)) {
            newsFeed.put(userId, new PriorityQueue<>(new Comparator<Tweet>(){
                public int compare(Tweet a, Tweet b) {
                    return b.seq - a.seq;
                }
            }));
        }
        
        if (!userTweets.containsKey(userId)) {
            userTweets.put(userId, new ArrayList<>());            
        }
    }

    public int getSequence() {
        return ++sequenceId;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */