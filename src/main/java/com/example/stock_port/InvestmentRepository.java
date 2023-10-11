package com.example.stock_port;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface InvestmentRepository extends CrudRepository<Investment, Long> {
    // Find by ID
    Optional<Investment> findById(@NonNull Long id);
    // Find by Investment Name
    List<Investment> findByInvestmentName(String investmentName);

    List<Investment> findByDollarAmountInvestedGreaterThan(BigDecimal amount);

    List<Investment> findByDollarAmountInvestedBetween(BigDecimal minAmount, BigDecimal maxAmount);

    void deleteById(@NonNull Long id);
}
