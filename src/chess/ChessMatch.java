package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    private void initialSetup() {
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 4));
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
