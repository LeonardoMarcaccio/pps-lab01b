package it.unibo.pps.e2;

public class BasicPiece implements Piece{
    private Pair<Integer, Integer> currentPos;

    public BasicPiece(int basePositionX, int basePositionY) {
        this.currentPos = new Pair<>(basePositionX, basePositionY);
    }

    @Override
    public void move(int row, int col) {

    }

    @Override
    public boolean isCurrentPosition(int row, int col) {
        return currentPos.equals(new Pair<>(row, col));
    }

    @Override
    public boolean canTake(Piece piece) {
        return false;
    }
}
