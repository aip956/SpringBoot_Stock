package com.example.stock_port;
import com.example.stock_port.Investment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.List;

@Service
public class InvestmentService {
    private final InvestmentRepository investmentRepository;

    @Autowired
    public InvestmentService(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public void addInvestment(Investment investment) {
        investmentRepository.save(investment);
    }

    public Optional<Investment> getInvestmentById(Long id) {
        return investmentRepository.findById(id);
    }

    public Iterable<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    public List<Investment> getInvestmentByName(String investmentName) {
        return investmentRepository.findByInvestmentName(investmentName);
    }

    public List<Investment> getInvestmentByAmountGreaterThan(BigDecimal dollarAmountInvested) {
        return investmentRepository.findByDollarAmountInvestedGreaterThan(dollarAmountInvested);
    }

    public List<Investment> getInvestmentByAmountBetween(BigDecimal minAmount, BigDecimal maxAmount) {
        return investmentRepository.findByDollarAmountInvestedBetween(minAmount, maxAmount);
    }

    public void deleteInvestmentById(Long id) {
        investmentRepository.deleteById(id);
    }

}
