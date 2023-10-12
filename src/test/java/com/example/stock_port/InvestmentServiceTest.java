package com.example.stock_port;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java. util.Optional;
import static org.mockito.Mockito.*;

@SpringBootTest
public class InvestmentServiceTest {
    @MockBean
    private InvestmentRepository mockInvestmentRepository;

    @Test
    public void testAddInvestment() {
        System.out.println("Running the service test");
        InvestmentService investmentService = new InvestmentService(mockInvestmentRepository);
        System.out.println("created the new mockInvestRepo");
        Investment investment = new Investment("Example", new BigDecimal("1000.0"));
        System.out.println("created new investment");
        // Add operation
        investmentService.addInvestment(investment);
        System.out.println("added investment");
        // Verify that save method of the repo was called with the investment ob
        verify(mockInvestmentRepository, times(1)).save(investment);
        System.out.println("verified investment");
    }
    @Test
    public void testGetInvestmentById() {
        System.out.println("Running the get by id test");
        // Create test investment
        Investment testInvestment = new Investment("Example2", new BigDecimal("1500.0"));
        // Save the testinvestment to the test DB
        testInvestment = investmentRepository.sav(testInvestment);
        // Get the ID of the saved investment
        Long testInvestementID
        when(mockInvestmentRepository.findById(1L)).thenReturn(Optional.of(testInvestment));
        // Call the service method to get the investment by ID
        Investment result = investmentService.getInvestmentById(1L);
        System.out.println("result: " + result);
        System.out.println(("testInvestment: " + testInvestment));
        assertEquals(testInvestment, result);
    }

}
