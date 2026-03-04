package it.unibo.pps.e2.Pieces;

import it.unibo.pps.e2.Pair;

public class BasicPiece implements Piece {
    private Pair<Integer, Integer> currentPos;

    public BasicPiece(int basePositionX, int basePositionY) {
        this.currentPos = new Pair<>(basePositionX, basePositionY);
    }

    @Override
    public void move(int row, int col) {
        if (isCurrentPosition(row, col)) {
            throw new IllegalStateException(
                "Attempting to move into current location"
            );
        }
        if(this.isMoveValid(row, col)) {
            this.currentPos = new Pair<>(row, col);
        }
    }

    @Override
    public boolean isCurrentPosition(int row, int col) {
        return currentPos.equals(new Pair<>(row, col));
    }

    @Override
    public boolean isMoveValid(int row, int col) {
        return true;
    }

    @Override
    public boolean canTake(Piece piece) {
        return piece.isCurrentPosition(
            this.currentPos.getX(),
            this.currentPos.getY()
        );
    }

    protected Pair<Integer, Integer> getCurrentPos() {
        return new Pair<>(
            this.currentPos.getX(),
            this.currentPos.getY()
        );
    }

    protected void setCurrentPos(Pair<Integer, Integer> newPos) {
        this.currentPos = newPos;
    }
}
