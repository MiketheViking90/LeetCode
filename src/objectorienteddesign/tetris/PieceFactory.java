package objectorienteddesign.tetris;

public class PieceFactory {
    public static Piece getRandomPiece(int width) {
        int mid = width/2;
        PieceType type = PieceType.getRandom();
        return new Piece(type, new Pair(0, mid));
    }
}
