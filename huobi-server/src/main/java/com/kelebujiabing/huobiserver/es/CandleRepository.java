package com.kelebujiabing.huobiserver.es;

import com.kelebujiabing.huobiserver.huobiApi.domain.Candle;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CandleRepository extends ElasticsearchRepository<Candle,Long> {



}
