package com.inzora.quotex.domain.investment;

import com.inzora.quotex.domain.asset.Asset;
import com.inzora.quotex.domain.user.User;
import com.inzora.quotex.enums.InvestmentOperation;
import com.inzora.quotex.enums.AssetType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="asset_code")
    private Asset asset;

    private InvestmentOperation operation;

    private LocalDate date;

}
