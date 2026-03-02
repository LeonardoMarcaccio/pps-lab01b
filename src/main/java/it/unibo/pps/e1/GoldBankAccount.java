package it.unibo.pps.e1;

public class GoldBankAccount extends CoreBankAccount{

    private static final int WITHDRAW_THRESHOLD = 500;

    @Override
    protected boolean canWithdraw(int amount) {
        return this.getBalance() + WITHDRAW_THRESHOLD >= amount;
    };
}
