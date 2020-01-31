package com.kelebujiabing.huobiserver.huobiApi.domain.event;

import com.kelebujiabing.huobiserver.huobiApi.domain.Candle;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

/**
 * created by jacky. 2018/7/24 8:26 PM
 */
@Getter
@Setter
@Document(indexName = "kline", type = "kline", shards = 1, replicas = 0, refreshInterval = "-1")
public class KlineEventResp {



    private String id;
    private String status;
    private long ts;
    private String ch;
    private Candle tick;
    private String subbed;


    //-----req---
    private String rep;
    private List<Candle> data;


    public String toString() {
        return "KlineEventResp{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", ts=" + ts +
                ", ch='" + ch + '\'' +
                ", tick=" + tick +
                ", subbed='" + subbed + '\'' +
                ", rep='" + rep + '\'' +
                ", data=" + data +
                '}';
    }
}
