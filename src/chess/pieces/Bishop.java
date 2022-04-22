package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position cursor = new Position(0, 0);

        // northwest
        cursor.setValues(position.getRow() - 1, position.getColumn() -1);
        while (getBoard().positionExists(cursor) && !getBoard().thereIsAPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
            cursor.setValues(cursor.getRow() - 1, cursor.getColumn() - 1);
        }
        if (getBoard().positionExists(cursor) && isThereOpponentPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        // northeast
        cursor.setValues(position.getRow() - 1, position.getColumn() + 1);
        while (getBoard().positionExists(cursor) && !getBoard().thereIsAPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
            cursor.setValues(cursor.getRow() - 1, cursor.getColumn() + 1);
        }
        if (getBoard().positionExists(cursor) && isThereOpponentPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        // southeast
        cursor.setValues(position.getRow() + 1, position.getColumn() + 1);
        while (getBoard().positionExists(cursor) && !getBoard().thereIsAPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
            cursor.setValues(cursor.getRow() + 1, cursor.getColumn() + 1);
        }
        if (getBoard().positionExists(cursor) && isThereOpponentPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        // southwest
        cursor.setValues(position.getRow() + 1, position.getColumn() - 1);
        while (getBoard().positionExists(cursor) && !getBoard().thereIsAPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
            cursor.setValues(cursor.getRow() + 1, cursor.getColumn() - 1);
        }
        if (getBoard().positionExists(cursor) && isThereOpponentPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }
        return mat;
    }
}
