package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest {

    private SilverBankAccount account;

    @BeforeEach
    void init(){
        this.account = new SilverBankAccount(new CoreBankAccount());
    }

    @ParameterizedTest
    @CsvSource({"0"})
    public void testInitiallyEmpty(int initialBalance) {
        assertEquals(initialBalance, this.account.getBalance());
    }

    @ParameterizedTest
    @CsvSource({"1000, 1000"})
    public void testCanDeposit(int depositAmount, int expectedAmount) {
        this.account.deposit(depositAmount);
        assertEquals(expectedAmount, this.account.getBalance());
    }

    @ParameterizedTest
    @CsvSource({"1000, 200, 799"})
    public void testCanWithdraw(
        int depositAmount,
        int withdrawAmount,
        int expectedAmount
    ) {
        this.account.deposit(depositAmount);
        this.account.withdraw(withdrawAmount);
        assertEquals(expectedAmount, this.account.getBalance());
    }

    @ParameterizedTest
    @CsvSource({"1000, 1200"})
    public void testCannotWithdrawMoreThanAvailable(
        int depositAmount,
        int impossibleWithdrawAmount
    ){
        this.account.deposit(depositAmount);
        assertThrows(
            IllegalStateException.class,
            () -> this.account.withdraw(impossibleWithdrawAmount)
        );
    }
}
