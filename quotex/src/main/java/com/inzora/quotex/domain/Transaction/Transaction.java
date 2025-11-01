package com.inzora.quotex.domain.Transaction;

import com.inzora.quotex.domain.investment.Investment;
import com.inzora.quotex.enums.InvestmentOperation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    @ManyToOne
    @JoinColumn(name = "investment_id")
    private Investment investment;

    private LocalDate date;
    private int quantity;
    private InvestmentOperation operation;
}
