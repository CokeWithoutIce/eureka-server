package com.kelebujiabing.productserver.web;

import com.kelebujiabing.productapi.domain.Product;
import com.kelebujiabing.productapi.feign.ProductFeignApi;
import com.kelebujiabing.productserver.servier.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductFeigenClient implements ProductFeignApi {

    @Autowired
    private IProductService productServer;

    @Override
    public Product find(String id) {
        log.info("调用商品服务find方法 ProductFeigenClient  ");
        Product product = productServer.get(id);
        return product;
    }

    public Product get(String id) {
        return  productServer.get(id);
    }
}
