package com.kelebujiabing.orderserver.service.impl;

import com.kelebujiabing.orderserver.domian.Order;
import com.kelebujiabing.orderserver.service.IOrderService;
import com.kelebujiabing.productapi.domain.Product;
import com.kelebujiabing.productapi.feign.ProductFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {


    @Autowired
    private ProductFeignApi productFeignApi;


    public Order save(String id, String name) {

        Product product = productFeignApi.find(id);

        log.info("发起下单操作");
        Order order = new Order();

        order.setId("a"+id);
        order.setOrderName(name);
        order.setProductId(product.getId());
        order.setProductName(product.getName());
        return order;
    }

    public Order get(String id, String name) {

      Product product =  productFeignApi.get(id);

        Order order = new Order();
        order.setProductId(product.getId());
        return order ;
    }
}
