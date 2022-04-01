/**
  * 题目Id：355
  * 题目：Design Twitter
  * 日期：2022-04-01 02:19:49
*/
//Design a simplified version of Twitter where users can post tweets, follow/
//unfollow another user, and is able to see the 10 most recent tweets in the user's 
//news feed. 
//
// Implement the Twitter class: 
//
// 
// Twitter() Initializes your twitter object. 
// void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId 
//by the user userId. Each call to this function will be made with a unique 
//tweetId. 
// List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs 
//in the user's news feed. Each item in the news feed must be posted by users who 
//the user followed or by the user themself. Tweets must be ordered from most 
//recent to least recent. 
// void follow(int followerId, int followeeId) The user with ID followerId 
//started following the user with ID followeeId. 
// void unfollow(int followerId, int followeeId) The user with ID followerId 
//started unfollowing the user with ID followeeId. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", 
//"unfollow", "getNewsFeed"]
//[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
//Output
//[null, null, [5], null, null, [6, 5], null, [5]]
//
//Explanation
//Twitter twitter = new Twitter();
//twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
//twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 
//tweet id -> [5]. return [5]
//twitter.follow(1, 2);    // User 1 follows user 2.
//twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
//twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 
//tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted 
//after tweet id 5.
//twitter.unfollow(1, 2);  // User 1 unfollows user 2.
//twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 
//tweet id -> [5], since user 1 is no longer following user 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= userId, followerId, followeeId <= 500 
// 0 <= tweetId <= 10⁴ 
// All the tweets have unique IDs. 
// At most 3 * 10⁴ calls will be made to postTweet, getNewsFeed, follow, and 
//unfollow. 
// 
// Related Topics 设计 哈希表 链表 堆（优先队列） 👍 288 👎 0

package leetcode.editor.cn;

import java.util.*;

public class DesignTwitter {
    public static void main(String[] args) {
        Solution solution = new DesignTwitter().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Twitter {

    private class Tweet {
        private int id;
        private int timestamp;
        private Tweet next;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    // userId, tweet
    private Map<Integer, Tweet> twitter;

    // userId, follower ID
    private Map<Integer, Set<Integer>> followings;

    private int timestamp = 0;

    private PriorityQueue<Tweet> maxHeap;

    public Twitter() {
        followings = new HashMap<>();
        twitter = new HashMap<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2.timestamp - o1.timestamp);
    }
    
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if (twitter.containsKey(userId)) {
            Tweet oldHead = twitter.get(userId);
            Tweet newHead = new Tweet(tweetId, timestamp);
            newHead.next = oldHead;
            twitter.put(userId, newHead);
        } else {
            twitter.put(userId, new Tweet(tweetId, timestamp));
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // 由于是全局使用的，使用之前需要清空
        maxHeap.clear();

        // 如果自己发了推文也要算上
        if (twitter.containsKey(userId)) {
            maxHeap.offer(twitter.get(userId));
        }

        Set<Integer> followingList = followings.get(userId);
        if (followingList != null && followingList.size() > 0) {
            for (Integer followingId : followingList) {
                Tweet tweet = twitter.get(followingId);
                if (tweet != null) {
                    maxHeap.offer(tweet);
                }
            }
        }

        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet head = maxHeap.poll();
            res.add(head.id);

            // 这里最好的操作应该是 replace，但是 Java 没有提供
            if (head.next != null) {
                maxHeap.offer(head.next);
            }
            count++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        // 被关注人不能是自己
        if (followeeId == followerId) {
            return;
        }

        // 获取我自己的关注列表
        Set<Integer> followingList = followings.get(followerId);
        if (followingList == null) {
            Set<Integer> init = new HashSet<>();
            init.add(followeeId);
            followings.put(followerId, init);
        } else {
            if (followingList.contains(followeeId)) {
                return;
            }
            followingList.add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }

        // 获取我自己的关注列表
        Set<Integer> followingList = followings.get(followerId);

        if (followingList == null) {
            return;
        }
        // 这里删除之前无需做判断，因为查找是否存在以后，就可以删除，反正删除之前都要查找
        followingList.remove(followeeId);
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
//leetcode submit region end(Prohibit modification and deletion)

} 
