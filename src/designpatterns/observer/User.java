package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<User> follows = new ArrayList<>();
    private final List<User> followers = new ArrayList<>();

    private final List<Tweet> feed = new ArrayList<>();

    private final String name;

    public User(String name) {
        this.name = name;
    }

    public void recieve(Tweet tweet) {
        feed.add(tweet);
    }

    public void tweet(String content) {
        Tweet tweet = new Tweet(content);

        for (User follower : followers) {
            follower.recieve(tweet);
        }
    }

    public void read() {
        System.out.println(name + "'s feed");
        for (Tweet tweet : feed) {
            System.out.println(tweet.getContent());
        }
        System.out.println();
    }

    public void follow(User user) {
        if (user == this) {
            return;
        }
        user.followers.add(this);
    }

    public static void main(String[] args) {
        User u1 = new User("Jim");
        User u2 = new User("Adam");
        User u3 = new User("Ben");
        User u4 = new User("Chuck");
        User u5 = new User("Dave");

        u2.follow(u1);
        u3.follow(u1);
        u3.follow(u2);
        u4.follow(u1);
        u5.follow(u1);

        u1.tweet("hello");
        u1.tweet("world");
        u2.tweet("its Adam");

        u2.read();
        u3.read();
    }
}
