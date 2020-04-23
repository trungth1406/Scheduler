package com.demo.springmvc.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;


@Controller
public class HomeController {
   private final Logger logger = LoggerFactory.getLogger(HomeController.class);


   @RequestMapping(value = "/",method = RequestMethod.GET)
   public ModelAndView welcome(){
       logger.info("Welcome");
       ModelAndView mav = new ModelAndView();
       mav.addObject("msg","Any mess");
       mav.addObject("name","Trung");
       mav.addObject("names", Arrays.asList("Hello","this","is" , "a", "list"));
       mav.addObject("ints", Arrays.asList(123,4235,123,-247,-2213));
       mav.setViewName("index");
       return mav;
   }


}
