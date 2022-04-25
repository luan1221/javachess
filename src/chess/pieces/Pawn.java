package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
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

            // #special move en passant white
            if (position.getRow() == 3) {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    mat[left.getRow() - 1][left.getColumn()] = true;
                }

                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    mat[right.getRow() - 1][right.getColumn()] = true;
                }
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

            // #special move en passant white
            if (position.getRow() == 4) {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    mat[left.getRow() + 1][left.getColumn()] = true;
                }

                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    mat[right.getRow() + 1][right.getColumn()] = true;
                }
            }
        }

        return mat;
    }
}
