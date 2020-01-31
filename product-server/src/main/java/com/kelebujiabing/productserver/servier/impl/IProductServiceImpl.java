package com.kelebujiabing.productserver.servier.impl;

import com.kelebujiabing.productapi.domain.Product;
import com.kelebujiabing.productserver.servier.IProductService;
import org.springframework.stereotype.Service;

@Service

public class IProductServiceImpl implements IProductService {

    @Override
    public Product get(String Id) {

        Product product = new Product();
        System.out.println(Id);
        product.setId(Id);
        product.setName(Id+"name");
        return product;
    }
}
