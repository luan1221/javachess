package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public String toString() {
        return "♚";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position cursor = new Position(0, 0);

        cursor.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        cursor.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        cursor.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        cursor.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        cursor.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        cursor.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        cursor.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }

        cursor.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(cursor) && canMove(cursor)) {
            mat[cursor.getRow()][cursor.getColumn()] = true;
        }


        if (getMoveCount() == 0 && !chessMatch.isCheck()) {

            //#special move castling kingside
            Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(posT1)) {
                Position cur1 = new Position(position.getRow(), position.getColumn() + 1);
                Position cur2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(cur1) == null && getBoard().piece(cur2) == null) {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }

            //#special move castling queenside
            Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(posT2)) {
                Position cur1 = new Position(position.getRow(), position.getColumn() - 1);
                Position cur2 = new Position(position.getRow(), position.getColumn() - 2);
                Position cur3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(cur1) == null && getBoard().piece(cur2) == null && getBoard().piece(cur3) == null) {
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }
}
