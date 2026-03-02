package it.unibo.pps.e1;

public class SilverBankAccount implements BankAccount{

    private final BankAccount base;

    public SilverBankAccount(BankAccount base) {
        this.base = base;
    }

    public int getBalance() {
        return this.base.getBalance();
    }

    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        this.base.withdraw(amount + 1);
    }
}
