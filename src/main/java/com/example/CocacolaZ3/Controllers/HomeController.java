package com.example.CocacolaZ3.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
    @RequestMapping("inicio")
    public String inicio(){
        return "home/inicio";
    }
}
