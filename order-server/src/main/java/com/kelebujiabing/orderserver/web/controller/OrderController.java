package com.kelebujiabing.orderserver.web.controller;

import com.kelebujiabing.orderserver.domian.Order;
import com.kelebujiabing.orderserver.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/order")
public class OrderController {


    @Autowired
    private IOrderService orderService;


    @RequestMapping("/save")
//    @HystrixCommand(fallbackMethod = "saveHystrix")
    public Order save (String id , String name, HttpServletRequest request){

        String token = request.getHeader("token");
        String cookie = request.getHeader("Cookie");
        System.out.println(token);
        System.out.println(cookie);
        Order save = orderService.save(id, name);
        return save ;
    }


    @RequestMapping("/get")
//    @HystrixCommand(fallbackMethod = "saveHystrix")
    public Order get (String id , String name, HttpServletRequest request){

        Order save = orderService.get(id, name);
        return save ;
    }



//    public Order saveHystrix (String id , String name , HttpServletRequest request){
//        System.out.println("错误");
//        return null ;
//    }



}
