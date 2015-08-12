package com.iscool.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {


    @RequestMapping(method = RequestMethod.GET, value = "/home.cool")
    public ModelAndView home() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("PageTitle", "Home");


        return new ModelAndView("/home/index", map);

    }


}
