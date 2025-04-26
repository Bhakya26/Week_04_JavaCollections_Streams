package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(100.0); // Start with $100
    }

    @Test
    void testDepositIncreasesBalance() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawDecreasesBalance() {
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawFailsWithInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
    }

    @Test
    void testDepositNegativeAmountThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
    }

    @Test
    void testWithdrawNegativeAmountThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-5.0));
    }
}
