package com.mapbim.gps.gpssocket.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeCtr{

    @GetMapping("/")
    public String index(){
        return "views/index";
    }
}