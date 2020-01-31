package com.kelebujiabing.huobiserver.huobiApi.domain.resp;

import com.kelebujiabing.huobiserver.huobiApi.domain.Trade;
import lombok.Getter;
import lombok.Setter;

/**
 * created by jacky. 2018/7/21 2:40 PM
 */
@Getter
@Setter
public class TradeResp {
    private RespTick<Trade> tick;
}
