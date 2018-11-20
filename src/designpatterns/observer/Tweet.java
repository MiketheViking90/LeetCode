package designpatterns.observer;

import lombok.Getter;

public class Tweet {

    @Getter
    private final String content;

    public Tweet(String content) {
        this.content = content;
    }

}
