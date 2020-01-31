package com.kelebujiabing.orderserver.service;

import com.kelebujiabing.orderserver.domian.Order;

public interface IOrderService {

    Order save (String id , String name);


    Order get(String id, String name);
}
