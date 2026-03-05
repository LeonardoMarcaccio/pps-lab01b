package it.unibo.pps.e2.Pieces;

import it.unibo.pps.e2.Pair;

public interface Piece {
    void move(int row, int col);
    boolean isMoveValid(int row, int col);
    Pair<Integer, Integer> getCurrentPos();
}
