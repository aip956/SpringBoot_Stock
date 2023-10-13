package com.example.stock_port;
import com.example.stock_port.Investment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

//import javax.persistence.criteria.CriteriaBuilder;
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
        System.out.println("created new investment: " + investment);
        // Add operation
        investmentService.addInvestment(investment);
        System.out.println("added investment");
        // Verify that save method of the repo was called with the investment ob
        // Print repository interactions
        System.out.println("Saving investment with name: " + investment.getInvestmentName());
        verify(mockInvestmentRepository, times(1)).save(investment);
        System.out.println("verified investment");
    }
    @Test
    public void testGetInvestmentById() {
        System.out.println("34Running the get by id test");

        // Create test investment
        Investment testInvestment = new Investment("Example2", new BigDecimal("1500.0"));
        System.out.println("37testInv: " + testInvestment);

        // Mock the behavior of the save method to return the testInvestment
        when(mockInvestmentRepository.save(any(Investment.class))).thenAnswer(invocation -> {
            System.out.println("44In when mock save");
            Investment savedInvestment = invocation.getArgument(0);
            savedInvestment.setId(1L);
            System.out.println("47savedInv: " + savedInvestment);
            return savedInvestment;
        });


        // Save the test investment to the test DB
        System.out.println("46Before saving test investment");
        Investment savedInvestment = mockInvestmentRepository.save(testInvestment);
        System.out.println("48After saving test investment");
        System.out.println("49savedInv: " + savedInvestment);

        long testInvestmentId = savedInvestment.getId();

        System.out.println("52testInvestment.getInvestmentName: " + testInvestment.getInvestmentName());
        verify(mockInvestmentRepository, times(1)).save(testInvestment);
        System.out.println("54testInvestmentId: " + testInvestmentId);
        verify(mockInvestmentRepository).findById(testInvestmentId);

        // Get the ID of the saved investment
        System.out.println("id: " + testInvestmentId);
        InvestmentService investmentService = new InvestmentService(mockInvestmentRepository);

        // create an optional to return
        System.out.println("63Before calling the service method");
        Optional<Investment> optionalInvestment = Optional.of(testInvestment);
        when(mockInvestmentRepository.findById(testInvestmentId)).thenReturn(optionalInvestment);

        // Call the service method to get the investment by Id
        System.out.println("68Before calling the service method");
        Optional<Investment> result = investmentService.getInvestmentById(testInvestmentId);
        System.out.println("70After calling the service method");
        System.out.println("71result: " + result);
        System.out.println(("73testInvestment: " + testInvestment));
//        investmentService.getInvestmentById((testInvestmentId));



        Assertions.assertTrue(result.isPresent()); // Check if it's present in the Optional
        Assertions.assertEquals(testInvestment, result.get()); // Get the Investmenet from the Optional and assert
    }
}
