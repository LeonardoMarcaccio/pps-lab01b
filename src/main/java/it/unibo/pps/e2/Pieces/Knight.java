package it.unibo.pps.e2.Pieces;

import it.unibo.pps.e2.Pair;

public class Knight extends BasicPiece{
    public Knight(int basePositionX, int basePositionY) {
        super(basePositionX, basePositionY);
    }

    @Override
    public boolean isMoveValid(int row, int col) {
        Pair<Integer, Integer> currentPos = this.getCurrentPos();
        int deltaX = row-currentPos.getX();
        int deltaY = col-currentPos.getY();
        if (deltaX !=0 && deltaY !=0 && Math.abs(deltaX)+Math.abs(deltaY)==3) {
            this.setCurrentPos(new Pair<>(row, col));
            return true;
        }
        return false;
    }
}
