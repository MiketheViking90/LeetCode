package objectorienteddesign.tetris;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public Direction getNext() {
        Direction[] values = Direction.values();
        return values[this.ordinal()+1 % values.length];
    }
}
