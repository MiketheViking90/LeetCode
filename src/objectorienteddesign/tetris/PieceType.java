package objectorienteddesign.tetris;

public enum PieceType {
    L,
    J,
    T,
    Z,
    S,
    O,
    I;

    public static PieceType getRandom() {
        int index = (int) (Math.random() * 8);
        return PieceType.values()[index];
    }

    public void rotate(Direction direction, boolean[][] grid) {

    }
}
