package it.unibo.pps.e1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends CoreBankAccountTest {

    @ParameterizedTest
    @CsvSource({"1000, 200, 799"})
    public void testCanWithdraw(
        int depositAmount,
        int withdrawAmount,
        int expectedAmount
    ) {
        super.testCanWithdraw(
            depositAmount,
            withdrawAmount,
            expectedAmount
        );
    }

    @ParameterizedTest
    @CsvSource({"1000, 1200"})
    public void testCannotWithdrawMoreThanAvailable(
        int depositAmount,
        int impossibleWithdrawAmount
    ){
        this.getAccount().deposit(depositAmount);
        assertThrows(
            IllegalStateException.class,
            () -> this.getAccount().withdraw(impossibleWithdrawAmount)
        );
    }

    @Override
    protected BankAccount createBankAccount() {
        return new SilverBankAccount();
    }
}
