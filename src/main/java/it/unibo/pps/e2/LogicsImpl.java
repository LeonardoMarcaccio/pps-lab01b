package it.unibo.pps.e2;

import it.unibo.pps.e2.Pieces.BasicPiece;
import it.unibo.pps.e2.Pieces.Knight;
import it.unibo.pps.e2.Pieces.Piece;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Piece pawn;
	private final Piece knight;
	private final Random random = new Random();
	private final int size;
	 
    public LogicsImpl(int size){
    	this.size = size;
        Pair<Integer, Integer> randomPosition = this.randomEmptyPosition();
        this.pawn = new BasicPiece(
            randomPosition.getX(),
            randomPosition.getY()
        );
        randomPosition = this.randomEmptyPosition();
        this.knight = new Knight(
            randomPosition.getX(),
            randomPosition.getY()
        );
    }

    public LogicsImpl(
        Pair<Integer, Integer> pawn,
        Pair<Integer, Integer> knight,
        int size
    ) {
        this.pawn = new BasicPiece(pawn.getX(), pawn.getY());
        this.knight = new BasicPiece(knight.getX(), knight.getY());
        this.size = size;
    }
    
	private Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(
            this.random.nextInt(size),
            this.random.nextInt(size)
        );
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.isCurrentPosition(pos.getX(), pos.getY())
            ? randomEmptyPosition()
            : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
        if (this.knight.isMoveValid(row, col)) {
            this.knight.move(row, col);
            return this.pawn.isCurrentPosition(row, col);
        }
        return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
        return this.knight.isCurrentPosition(row, col);
	}

	@Override
	public boolean hasPawn(int row, int col) {
        return this.pawn.isCurrentPosition(row, col);
	}
}
