package main.com.think101.leetcode.Patterns.HeapPriorityQueue.DesignTwitter;

import java.util.*;

public class Twitter {
    Map<Integer, Set<Integer>> following;
    Map<Integer, List<int[]>> tweets; // userId -> their tweets, each tweet is int[2] while int[0] tweetId int[1] time
    int time;

    public Twitter() {
        this.following = new HashMap<>();
        this.tweets = new HashMap<>();
        this.time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)){
            tweets.put(userId, new ArrayList<>());
        }

        if(tweets.get(userId).size() < 10) {
            tweets.get(userId).add(new int[]{tweetId, time++});
        }
        else {
            tweets.get(userId).remove(0);
            tweets.get(userId).add(new int[]{tweetId, time++});
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> newsFeed = new PriorityQueue<>(10, Comparator.comparingInt(a -> a[1]));

        if(following.get(userId) != null) {
            for(int followee : following.get(userId)) {
                for(int[] tweet : tweets.get(followee)) {
                    if(newsFeed.size() < 10) {
                        newsFeed.add(tweet);
                    }
                    else if(tweet[1] > newsFeed.peek()[1]) {
                        newsFeed.poll();
                        newsFeed.add(tweet);
                    }
                }
            }
        }


        if(tweets.get(userId) != null) {
            for(int[] tweet : tweets.get(userId)) {
                if(newsFeed.size() < 10) {
                    newsFeed.add(tweet);
                }
                else if(tweet[1] > newsFeed.peek()[1]) {
                    newsFeed.poll();
                    newsFeed.add(tweet);
                }
            }
        }


        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < newsFeed.size(); i++) {
            int[] t = newsFeed.poll();
            res.add(t[0]);
        }

        System.out.println("news feed: " + res);
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if(!following.containsKey(followerId)) {
            following.put(followerId, new HashSet<>());
        }

        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(!following.containsKey(followerId)) {
            return;
        }

        following.get(followerId).remove(followeeId);
    }

    public static void main() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.getNewsFeed(1);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        twitter.getNewsFeed(1);
        twitter.unfollow(1, 2);
        twitter.getNewsFeed(1);
    }
}
