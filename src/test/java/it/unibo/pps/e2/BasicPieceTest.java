package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicPieceTest {
    private Piece piece;
    private static final int BASE_POSITION_X = 3;
    private static final int BASE_POSITION_Y = 3;

    @BeforeEach
    void beforeEach() {
        this.piece = this.createPiece();
    }

    @Test
    void testGivenPositionConstructor() {
        assertTrue(
            this.piece.isCurrentPosition(
                BASE_POSITION_X,
                BASE_POSITION_Y
            )
        );
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "1, 0",
        "0, 1"
    })
    void testRightMoves(int row, int col) {
        this.piece.move(row, col);
        assertTrue(this.piece.isCurrentPosition(row,col));
    }

    @Test
    void testCanTakeValidPiece() {
        Piece pieceToTake = new BasicPiece(
            BASE_POSITION_X,
            BASE_POSITION_Y
        );
        assertTrue(this.piece.canTake(pieceToTake));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "1, 0",
        "0, 1"
    })
    void testCannotTakeInvalidPiece(int row, int col) {
        Piece pieceToTake = new BasicPiece(row, col);
        assertFalse(this.piece.canTake(pieceToTake));
    }

    protected Piece createPiece() {
        return new BasicPiece(
            BASE_POSITION_X,
            BASE_POSITION_Y
        );
    }
}
