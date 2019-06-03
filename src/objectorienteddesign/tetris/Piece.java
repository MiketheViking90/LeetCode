package objectorienteddesign.tetris;

import lombok.Getter;

import java.util.Set;

@Getter
public class Piece {
    private final PieceType pieceType;
    private Direction direction;
    private Pair center;
    private Set<Pair> area;
    private RotationStrategy rotationStrategy;

    Piece(PieceType type, Pair center) {
        this.pieceType = type;
        this.center = center;

        switch (type) {
            case I:

        }
    }

    public void moveDown() {
        area.stream().forEach((Pair p) -> p.setX(p.getX() + 1));
    }

    public void rotate(boolean[][] grid) {
        direction = direction.getNext();
        area = rotationStrategy.rotate(direction, grid);
    }
}
