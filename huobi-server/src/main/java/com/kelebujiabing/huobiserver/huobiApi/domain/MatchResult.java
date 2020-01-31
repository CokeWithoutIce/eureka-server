package com.kelebujiabing.huobiserver.huobiApi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kelebujiabing.huobiserver.huobiApi.domain.enums.OrderSource;
import com.kelebujiabing.huobiserver.huobiApi.domain.enums.OrderType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * created by jacky. 2018/7/26 11:01 AM
 */
@Getter
@Setter
public class MatchResult {
    private String id;
    @JsonProperty("order-id")
    private String orderId;
    @JsonProperty("match-id")
    private String matchId;
    private String symbol;
    private OrderType type;
    private OrderSource source;
    private BigDecimal price;
    @JsonProperty("filled-amount")
    private BigDecimal filledAmount;
    @JsonProperty("filled-fees")
    private BigDecimal filledFees;
    @JsonProperty("created-at")
    private String createdAt;
}