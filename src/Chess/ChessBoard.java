package Chess;

import GameEntities.ChessPiece;

/**
 * The Chessboard class is responsiable for mulipulating the board
 * by moving and removing pieces.
 */
public class ChessBoard {
    private ChessPiece[][] board;

    /**
     * Creates the board instance.
     */
    public ChessBoard() {
        board = new ChessPiece[8][8];
    }

    /**
     * Checks if piece is at a specificed location.
     * @param row Row of the location.
     * @param col Col of the location.
     * @return Boolean of if theres a piece on location or not.
     */
    public boolean isPieceAt(int row, int col) {
        return board[row][col] != null;
    }

    /**
     * Places piece at location, if piece already exisit there, the old piece will be overwritten.
     * @param piece The piece to move.
     * @param location The location to move to.
     */
    public void placePieceAt(ChessPiece piece, ChessLocation location) {
        removePieceAt(location);
        removePieceAt(piece.getChessLocation());
        board[location.getRow()][location.getCol()] = piece;
        /*
        if (piece.validMove(location)) {
            if (isPieceAt(location.getRow(), location.getCol()) && 
                getPieceAt(location).getOwner().equals(piece.getOwner())) {

                System.out.println("Piece is on your team is here.");
                System.out.println("Not a valid move, try again.");
            } else {
                removePieceAt(location);
                removePieceAt(piece.getChessLocation());
                board[location.getRow()][location.getCol()] = piece;
                piece.moveTo(location);
            }
        } else {
            System.out.println("Not a valid move, try again.");
        }
        */
    }

    /**
     * Removes piece at location.
     * @param location The location to remove at.
     */
    private void removePieceAt(ChessLocation location) {
        board[location.getRow()][location.getCol()] = null;
    }

    /**
     * Setup piece which bypasses valid move check from piece.
     * Used for initalizing piece on board.
     * @param piece The piece to set up.
     * @param location The location to set up at.
     */
    public void setupPieceAt(ChessPiece piece, ChessLocation location) {
        if (board[location.getRow()][location.getCol()] == null) {
            board[location.getRow()][location.getCol()] = piece;
            piece.moveTo(location);
        }
    }

    /**
     * Checks if the location is within the board.
     * @param location The location to check.
     * @return Boolean of if the location is in bounds or not.
     */
    public static boolean locationInBounds(ChessLocation location) {
        return location.getRow() >= 0 && 
               location.getRow() < 8 && 
               location.getRow() >= 0 && 
               location.getCol() < 8;
    }

    /**
     * Gets piece at location of board.
     * @param location Location to find piece at.
     * @return Piece at location/
     */
    public ChessPiece getPieceAt(ChessLocation location) {
        return board[location.getRow()][location.getCol()];
    }

    /**
     * Displays board with P being Piece.
     */
    @Override
    public String toString() {
        String s = "  0 1 2 3 4 5 6 7\n";
        for (int row = 0; row < 8; row++) {
            s += row;
            for (int col = 0; col < 8; col++) {
                if (board[row][col] != null) {
                    s += " " + board[row][col].getId();
                } else {
                    s += " -";
                }
            }
            s += "\n";
        }
        return s;
    }
}
