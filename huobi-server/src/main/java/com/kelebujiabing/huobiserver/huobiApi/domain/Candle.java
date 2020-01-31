package com.kelebujiabing.huobiserver.huobiApi.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

/**
 * created by jacky. 2018/7/20 8:52 PM
 */
@Getter
@Setter
//, shards = 1, replicas = 0, refreshInterval = "-1"
@Document(indexName = "kline", type = "kline")
public class Candle {
    @Id
    private long id;
    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal low;
    private BigDecimal high;
    private BigDecimal amount;
    private BigDecimal vol;
    private BigDecimal count;
    private String symbol;
    private long ts;
    private long version;



    public String toString() {
        return "Candle{" +
                "id=" + id +
                ", open=" + open +
                ", close=" + close +
                ", low=" + low +
                ", high=" + high +
                ", amount=" + amount +
                ", vol=" + vol +
                ", count=" + count +
                ", symbol='" + symbol + '\'' +
                ", ts=" + ts +
                ", version=" + version +
                '}';
    }
}
