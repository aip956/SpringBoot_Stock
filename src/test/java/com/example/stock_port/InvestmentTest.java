package com.example.stock_port;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvestmentTest {
    @Test
    public void testInvestmentCreation() {
        Investment investment = new Investment("Example", 1000.0);

        // Assertions
        assertEquals("Example", investment.getInvestmentName());
        assertEquals(1000.0, investment.getDollarAmountInvested(), 0.001);
    }
}
