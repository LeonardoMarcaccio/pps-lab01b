package it.unibo.pps.e1;

class CoreBankAccount implements BankAccount {

    private int balance = 0;

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    public void withdraw(int amount) {
        if (canWithdraw(amount)) {
            this.balance = this.balance - computeAmountWithFee(amount);
        } else {
            throw new IllegalStateException();
        }
    }

    protected boolean canWithdraw(int amount) {
        return true;
    };

    protected int computeAmountWithFee(int amount) {
        return amount;
    };
}
