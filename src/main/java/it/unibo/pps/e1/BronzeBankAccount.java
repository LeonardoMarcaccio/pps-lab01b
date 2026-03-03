package it.unibo.pps.e1;

public class BronzeBankAccount extends CoreBankAccount {
    private static final int FEE = 1;
    private static final int FEE_THRESHOLD = 100;

    @Override
    protected boolean canWithdraw(int amount) {
        return this.getBalance() > computeAmountWithFee(amount);
    };

    @Override
    protected int computeAmountWithFee(int amount) {
        return amount >= FEE_THRESHOLD ? amount + FEE : amount;
    };
}
