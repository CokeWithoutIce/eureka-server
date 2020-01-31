package com.kelebujiabing.productapi.feign;

import com.kelebujiabing.productapi.domain.Product;
import com.kelebujiabing.productapi.feign.hystrix.ProductFeginHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(name = "product-server" ,fallback = ProductFeginHystrix.class)
public interface ProductFeignApi {
    @RequestMapping("/api/products/find")
    Product find (@RequestParam("id") String id);
    @RequestMapping("/api/products/get")
    Product get(String id);
}
