package com.kelebujiabing.productapi.feign.hystrix;

import com.kelebujiabing.productapi.domain.Product;
import com.kelebujiabing.productapi.feign.ProductFeignApi;
import org.springframework.stereotype.Component;

/**
 * 兜底数据,用于程序法生错误的时候显示的数据
 */
@Component
public class ProductFeginHystrix implements ProductFeignApi {

    public Product find(String id) {

        System.out.println("商品的兜底数据");
        return null;
    }

    public Product get(String id) {
        return null;
    }
}
