package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public boolean[][] possibleMoves(Position position) {
        return null;
    }

    public Color getColor() {
        return color;
    }
}
