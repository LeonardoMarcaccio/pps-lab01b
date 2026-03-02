package it.unibo.pps.e1;

public class SilverBankAccount extends CoreBankAccount{

    private static final int FEE = 1;

    @Override
    protected boolean canWithdraw(int amount) {
        return this.getBalance() > computeAmountWithFee(amount);
    };

    @Override
    protected int computeAmountWithFee(int amount) {
        return amount + FEE;
    };
}
