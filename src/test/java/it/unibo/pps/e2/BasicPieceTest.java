package it.unibo.pps.e2;

import it.unibo.pps.e2.Pieces.BasicPiece;
import it.unibo.pps.e2.Pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class BasicPieceTest {
    Piece piece;
    static final int BASE_POSITION_X = 5;
    static final int BASE_POSITION_Y = 5;
    static final String CURRENT_LOCATION_ERROR =
        "Attempting to move into current location";

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
    void testAttemptToMoveToCurrentPosition() {
        Exception exception = assertThrows(
            IllegalStateException.class,
            () -> this.piece.move(BASE_POSITION_X, BASE_POSITION_Y)
        );
        assertEquals(
            CURRENT_LOCATION_ERROR,
            exception.getMessage()
        );
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
