package chess;

import boardgame.Board;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] stub = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i = 0; i < board.getRows(); ++i) {
            for(int j = 0; j < board.getColumns(); ++j) {
                stub[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return stub;
    }
}
