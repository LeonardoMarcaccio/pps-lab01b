package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoreBankAccountTest implements BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void init(){
        this.account = createBankAccount();
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
    @CsvSource({"1000, 200, 800"})
    public void testCanWithdraw(
            int depositAmount,
            int withdrawAmount,
            int expectedAmount
    ) {
        this.account.deposit(depositAmount);
        this.account.withdraw(withdrawAmount);
        assertEquals(expectedAmount, this.account.getBalance());
    }

    protected BankAccount getAccount() {
        return account;
    }

    protected BankAccount createBankAccount() {
        return new CoreBankAccount();
    }
}
