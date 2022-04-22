package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "♟";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position cursor = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            cursor.setValues(position.getRow()-1, position.getColumn());
            if (getBoard().positionExists(cursor) && !getBoard().thereIsAPiece(cursor)) {
                mat[cursor.getRow()][cursor.getColumn()] = true;
                cursor.setValues(position.getRow()-2, position.getColumn());
                if (getBoard().positionExists(cursor) && !getBoard().thereIsAPiece(cursor) && getMoveCount() == 0) {
                    mat[cursor.getRow()][cursor.getColumn()] = true;
                }
            }
            cursor.setValues(position.getRow()-1, position.getColumn()-1);
            if (getBoard().positionExists(cursor) && isThereOpponentPiece(cursor)) {
                mat[cursor.getRow()][cursor.getColumn()] = true;
            }
            cursor.setValues(position.getRow()-1, position.getColumn()+1);
            if (getBoard().positionExists(cursor) && isThereOpponentPiece(cursor)) {
                mat[cursor.getRow()][cursor.getColumn()] = true;
            }
        } else {
            cursor.setValues(position.getRow()+1, position.getColumn());
            if (getBoard().positionExists(cursor) && !getBoard().thereIsAPiece(cursor)) {
                mat[cursor.getRow()][cursor.getColumn()] = true;
                cursor.setValues(position.getRow()+2, position.getColumn());
                if (getBoard().positionExists(cursor) && !getBoard().thereIsAPiece(cursor) && getMoveCount() == 0) {
                    mat[cursor.getRow()][cursor.getColumn()] = true;
                }
            }
            cursor.setValues(position.getRow()+1, position.getColumn()-1);
            if (getBoard().positionExists(cursor) && isThereOpponentPiece(cursor)) {
                mat[cursor.getRow()][cursor.getColumn()] = true;
            }
            cursor.setValues(position.getRow()+1, position.getColumn()+1);
            if (getBoard().positionExists(cursor) && isThereOpponentPiece(cursor)) {
                mat[cursor.getRow()][cursor.getColumn()] = true;
            }
        }

        return mat;
    }
}
