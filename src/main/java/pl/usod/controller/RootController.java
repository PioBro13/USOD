package pl.usod.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @RequestMapping("/")
    public String root(){
        return "index";
    }

    @RequestMapping ("/formView")
    public String formView(){
        return "formView";
        }

    @RequestMapping("/financialSummary")
    public String financialSumamry(){return "financialSummary";}
}
