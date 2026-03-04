package it.unibo.pps.e2.Pieces;

public interface Piece {
    void move(int row, int col);
    boolean isCurrentPosition(int row, int col);
    boolean isMoveValid(int row, int col);
    boolean canTake(Piece piece);
}
