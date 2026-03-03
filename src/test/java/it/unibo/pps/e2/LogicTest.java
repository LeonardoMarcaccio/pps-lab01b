package it.unibo.pps.e2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private LogicsImpl logics;
    private static final int BASE_SIZE = 8;
    private Pair<Integer, Integer> knightBasePosition;
    private Pair<Integer, Integer> pawnBasePosition;

    @BeforeEach
    void beforeEach() {
        this.knightBasePosition = new Pair<Integer, Integer>(2, 2);
        this.pawnBasePosition = new Pair<Integer, Integer>(3, 4);
        this.logics = new LogicsImpl(
            pawnBasePosition,
            knightBasePosition,
            BASE_SIZE
        );
    }

    @Test
    void testGivenPositionConstructor() {
        assertTrue(
            this.logics.hasKnight(
                this.knightBasePosition.getX(),
                this.knightBasePosition.getY()
            )
        );
        assertTrue(
            this.logics.hasPawn(
                this.pawnBasePosition.getX(),
                this.pawnBasePosition.getY()
            )
        );
    }

    @ParameterizedTest
    @CsvSource({
        "-1, 0",
        "0, -1",
        "9, 0",
        "0, 9"
    })
    void testOutOfBoundsMoves(int row, int col) {
        assertThrows(
            IndexOutOfBoundsException.class,
            () -> this.logics.hit(row, col)
        );
    }

    @ParameterizedTest
    @CsvSource({
        "1, 0",
        "0, 1",
        "3, 0",
        "4, 1",
        "4, 3",
        "1, 4",
        "0, 3"
    })
    void testLegalMovesNotReachingThePawn(int row, int col) {
        assertFalse(this.logics.hit(row, col));
    }

    @ParameterizedTest
    @CsvSource({
        "3,4"
    })
    void testPawnHit(int row, int col) {
        assertTrue(this.logics.hit(row, col));
    }

    @Test
    void testCheckKnightRightPosition() {
        assertTrue(
            this.logics.hasKnight(
                this.knightBasePosition.getX(),
                this.knightBasePosition.getY()
            )
        );
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0",
        "3, 4"
    })
    void testCheckKnightWrongPosition(int row, int col) {
        assertFalse(this.logics.hasKnight(row, col));
    }

    @Test
    void testCheckPawnRightPosition() {
        assertTrue(
            this.logics.hasPawn(
                this.pawnBasePosition.getX(),
                this.pawnBasePosition.getY()
            )
        );
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0",
        "2, 2"
    })
    void testCheckPawnWrongPosition(int row, int col) {
        assertFalse(this.logics.hasPawn(row, col));
    }

}
