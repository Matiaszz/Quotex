package com.inzora.quotex.domain.asset;

import com.inzora.quotex.enums.AssetSector;
import com.inzora.quotex.enums.AssetType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String code;

    private String name;

    @Enumerated(EnumType.STRING)
    private AssetType type;

    private AssetSector sector;
    private double currentPrice;
    private double  dividendYield;
    private double dailyVariation;

}
