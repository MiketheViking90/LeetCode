package objectorienteddesign.tetris;

import lombok.*;

@Getter @Setter
@EqualsAndHashCode
@ToString
public class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
