package it.unibo.pps.e1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends CoreBankAccountTest{

    @ParameterizedTest
    @CsvSource({"1000, 1800"})
    public void testCannotWithdrawMoreThanAvailable(
            int deposit,
            int impossibleWithdraw
    ){
        this.getAccount().deposit(deposit);
        assertThrows(
                IllegalStateException.class,
                () -> this.getAccount().withdraw(impossibleWithdraw)
        );
    }

    @ParameterizedTest
    @CsvSource({"1000, 1500, -500"})
    public void testWithdrawWithDebt(
        int deposit,
        int debtWithdraw,
        int expectedBalance
    ) {
        this.getAccount().deposit(deposit);
        this.getAccount().withdraw(debtWithdraw);
        assertEquals(expectedBalance, this.getAccount().getBalance());
    }

    @Override
    protected BankAccount createBankAccount() {
        return new GoldBankAccount();
    }
}
