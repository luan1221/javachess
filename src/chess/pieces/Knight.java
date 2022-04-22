package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {


    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position cursor = new Position(0, 0);

        cursor.setValues(position.getRow() - 1, position.getColumn() - 2);
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        cursor.setValues(position.getRow() - 2, position.getColumn() - 1);
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        cursor.setValues(position.getRow() - 2, position.getColumn() + 1);
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        cursor.setValues(position.getRow() - 1, position.getColumn() + 2);
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        cursor.setValues(position.getRow() + 1, position.getColumn() - 2);
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        cursor.setValues(position.getRow() + 1, position.getColumn() + 2);
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        cursor.setValues(position.getRow() + 2, position.getColumn() + 1);
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        cursor.setValues(position.getRow() + 2, position.getColumn() - 1);
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        return mat;
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }
}
