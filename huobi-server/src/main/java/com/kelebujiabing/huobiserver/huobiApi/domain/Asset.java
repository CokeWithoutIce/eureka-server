package com.kelebujiabing.huobiserver.huobiApi.domain;

import com.kelebujiabing.huobiserver.huobiApi.domain.enums.AssetType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * created by jacky. 2018/7/23 3:28 PM
 */
@Getter
@Setter
public class Asset {
    private String currency;
    private AssetType type;
    private BigDecimal balance;
}
