package it.unibo.pps.e2;

import it.unibo.pps.e2.Pieces.Knight;
import it.unibo.pps.e2.Pieces.Piece;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest extends BasicPieceTest{

    @ParameterizedTest
    @CsvSource({
        "3, 4",
        "3, 6",
        "4, 3",
        "4, 7",
        "6, 3",
        "6, 7",
        "7, 4",
        "7, 6"
    })
    void testRightMoves(int row, int col) {
        this.piece.move(row, col);
        assertTrue(this.piece.isCurrentPosition(row,col));
    }

    @ParameterizedTest
    @CsvSource({
        "5, 0",
        "0, 5",
        "8, 8",
        "2, 2"
    })
    void testWrongMoves(int row, int col) {
        this.piece.move(row, col);
        assertFalse(this.piece.isCurrentPosition(row,col));
    }

    @Override
    protected Piece createPiece() {
        return new Knight(BASE_POSITION_X, BASE_POSITION_Y);
    }
}
