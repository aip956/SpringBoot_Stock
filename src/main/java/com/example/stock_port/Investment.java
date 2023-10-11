package com.example.stock_port;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter
    private String investmentName;
    @Getter @Setter
    private double dollarAmountInvested;

    public Investment(String investmentName, double dollarAmountInvested) {
        this.investmentName = investmentName;
        this.dollarAmountInvested = dollarAmountInvested;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

}
