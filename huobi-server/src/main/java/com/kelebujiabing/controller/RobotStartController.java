package com.kelebujiabing.controller;

import com.kelebujiabing.service.RobotStartServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/robot")
public class RobotStartController {

    @Autowired
    private RobotStartServer robotStartServer;


    @RequestMapping("/kLineStatr")
    public void get (){
        robotStartServer.statr();
    }






    @RequestMapping("/robotStatr")
    public void robotStatr (){
        robotStartServer.robotStatr();
    }



}
