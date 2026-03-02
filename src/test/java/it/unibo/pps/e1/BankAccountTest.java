package it.unibo.pps.e1;

public interface BankAccountTest {
    void testInitiallyEmpty(int initialBalance);
    void testCanDeposit(int depositAmount, int expectedAmount);
    void testCanWithdraw(
            int depositAmount,
            int withdrawAmount,
            int expectedAmount
    );
}

