package com.kelebujiabing.service.impl;

import com.kelebujiabing.huobiserver.es.CandleRepository;
import com.kelebujiabing.huobiserver.huobiApi.domain.Candle;
import com.kelebujiabing.huobiserver.huobiApi.domain.enums.Resolution;
import com.kelebujiabing.huobiserver.huobiApi.impl.HuobiApiWebSocketClientImpl;
import com.kelebujiabing.service.RobotStartServer;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.commons.math.stat.descriptive.moment.Variance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

@Service
public class RobotStartServerImpl implements RobotStartServer {


    @Autowired
    private CandleRepository candleRepository;
    private HuobiApiWebSocketClientImpl ws = new HuobiApiWebSocketClientImpl();
    //方差标准
    private double anIntd = 1;


    public void statr() {

        Closeable stream = ws.onKlineTick("btcusdt", Resolution.M5, data -> {
            if (StringUtils.isNotEmpty(data.getSubbed())) {
                System.out.println(data.getSubbed());
            } else {
                System.out.println(data);
                data.getTick().setId(System.currentTimeMillis());
                candleRepository.save(data.getTick());
            }
        });
    }


    /**
     * 开启自动机器人
     */
    public void robotStatr() {
        //前10个交易情况
        List<Candle> frontCandle = new ArrayList<>();
        //后10个交易情况
        List<Candle> rearCandle = new ArrayList<>();
        Variance variance = new Variance();//方差
        //获取5分钟的线
        double[] frontvalues = new double[10];
        double[] rearvalues = new double[10];
        Closeable stream = ws.onKlineTick("btcusdt", Resolution.M30, data -> {
            int front = 0;
            int rear = 0;
            if (StringUtils.isEmpty(data.getSubbed())) {
                //记录前后两个交易
                frontCandle.add(data.getTick());

                if (frontCandle.size() == 10) {
                    for (Candle candle : frontCandle) {
                        frontvalues[front++] = candle.getHigh().doubleValue() -   candle.getOpen().doubleValue();
                        System.out.println("frontvalues:"+frontvalues.toString());
                    }
                }else if(frontCandle.size() > 10 ) {
                    rearCandle.add(data.getTick());
                    for (Candle candle : rearCandle) {
                        rearvalues[rear++] = candle.getHigh().doubleValue() -   candle.getOpen().doubleValue();
                        System.out.println("rearevaluate:"+rearvalues.toString());
                    }
                }
                if(frontCandle.size() == 10 &&  rearCandle.size() == 10 ){
                    double fronevaluate = variance.evaluate(frontvalues);
                    System.out.println("fronevaluate:-----"+fronevaluate);
                    double rearevaluate = variance.evaluate(rearvalues);
                    System.out.println("rearevaluate:----"+rearevaluate);
                    double crent =   rearevaluate - fronevaluate ;
                    System.out.println("crent:--------"+crent);
                    frontCandle.clear();
                    rearCandle.clear();
                }
            }
        });
        //计算每一条记录的方差 当方差大于或等某个值的时候就下单
    }


}
