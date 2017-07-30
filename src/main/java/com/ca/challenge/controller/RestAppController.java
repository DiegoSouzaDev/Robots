package com.ca.challenge.controller;
import java.util.Date;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ca.challenge.util.RobotMoveService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/rest/mars")
public class RestAppController {
	
	RobotMoveService robotMoveService;

    @RequestMapping("/Hi")
    String home() {
        return "Hello World!";
    }
    @RequestMapping("/date")
    String date() {
        return new Date().toString();
    }
    
    @RequestMapping(value="/move/{params}", method=RequestMethod.POST)
    String move(@PathVariable String params){
    	   return robotMoveService.move(params);	
    }
}