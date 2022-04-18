package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

import java.util.regex.PatternSyntaxException;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position cursor = new Position(0, 0);

        //Up
        cursor.setValues(position.getRow() - 1, position.getColumn());
        while (getBoard().positionExists(cursor) && !getBoard().thereIsAPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
            cursor.setRow(position.getRow() - 1);
        }
        if (getBoard().positionExists(cursor) && isThereOpponentPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        //Left
        cursor.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExists(cursor) && !getBoard().thereIsAPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
            cursor.setColumn(position.getColumn() - 1);
        }
        if (getBoard().positionExists(cursor) && isThereOpponentPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        //Right
        cursor.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionExists(cursor) && !getBoard().thereIsAPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
            cursor.setColumn(position.getColumn() + 1);
        }
        if (getBoard().positionExists(cursor) && isThereOpponentPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        //Down
        cursor.setValues(position.getRow() + 1, position.getColumn());
        while (getBoard().positionExists(cursor) && !getBoard().thereIsAPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
            cursor.setRow(position.getRow() + 1);
        }
        if (getBoard().positionExists(cursor) && isThereOpponentPiece(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        return mat;
    }
}
