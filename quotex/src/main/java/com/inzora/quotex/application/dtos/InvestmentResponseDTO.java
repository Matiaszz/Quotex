package com.inzora.quotex.application.dtos;

import com.inzora.quotex.domain.asset.Asset;
import com.inzora.quotex.domain.investment.Investment;
import com.inzora.quotex.enums.InvestmentOperation;
import com.inzora.quotex.enums.AssetType;

import java.time.LocalDate;

public record InvestmentResponseDTO(
        String id,
        Asset asset,
        InvestmentOperation operation,
        LocalDate date
) {
    InvestmentResponseDTO(Investment i){
        this(
                i.getId(),
                i.getAsset(),
                i.getOperation(),
                i.getDate()
        );
    }
}
