package it.unibo.pps.e1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BronzeBankAccountTest extends CoreBankAccountTest {

    @ParameterizedTest
    @CsvSource({
        "1000, 99, 901",
        "1000, 200, 799"
    })
    public void testCanWithdraw(
            int deposit,
            int withdraw,
            int expected
    ) {
        super.testCanWithdraw(
                deposit,
                withdraw,
                expected
        );
    }

    @ParameterizedTest
    @CsvSource({"1000, 1200"})
    public void testCannotWithdrawMoreThanAvailable(
            int deposit,
            int impossibleWithdraw
    ){
        super.testCannotWithdrawMoreThanAvailable(deposit, impossibleWithdraw);
    }

    @Override
    protected BankAccount createBankAccount() {
        return new BronzeBankAccount();
    }
}
