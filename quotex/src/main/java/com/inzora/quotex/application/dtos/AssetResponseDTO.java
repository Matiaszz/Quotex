package com.inzora.quotex.application.dtos;

import com.inzora.quotex.domain.asset.Asset;
import com.inzora.quotex.enums.AssetSector;
import com.inzora.quotex.enums.AssetType;

public record AssetResponseDTO(
        String code,
        String name,
        AssetType type,
        AssetSector sector,
        double currentPrice,
        double dividendYield,
        double dailyVariation
) {
    AssetResponseDTO(Asset a){
        this(
                a.getCode(),
                a.getName(),
                a.getType(),
                a.getSector(),
                a.getCurrentPrice(),
                a.getDividendYield(),
                a.getDailyVariation()
                );
    }
}
