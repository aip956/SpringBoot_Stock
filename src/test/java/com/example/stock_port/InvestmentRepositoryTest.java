package com.example.stock_port;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

//@SpringBootTest
//class InvestmentRepositoryTest {
//    @Autowired
//    private InvestmentRepository investmentRepository;
//
//    @Test
//    @Disabled("Disabling to troubleshoot")
//    public void testFindByInvestmentName() {
//        Investment investment = new Investment("Example", new BigDecimal("1000.0"));
//        investmentRepository.save(investment);
//
//        Investment foundInvestment = investmentRepository.findByInvestmentName("Example");
//        assertNotNull(foundInvestment);
//        assertEquals("Example", foundInvestment.getInvestmentName());
//
//    }
//}
