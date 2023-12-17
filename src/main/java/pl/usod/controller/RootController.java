package pl.usod.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @RequestMapping("/adminIndex")
    public String adminIndex(){return  "adminIndex";}

    @RequestMapping("/adminIndex/newTerm")
    public String newTerm(){return "newTerm";}

    @RequestMapping("/adminIndex/newOperationFinances")
    public String newOperationFinances(){return "newOperationFinances";}

    @RequestMapping("/adminIndex/editOperationFinances")
    public String editOperationFinances(){return "editOperationFinances";}

    @RequestMapping("/adminIndex/newSubject")
    public String newSubject(){return "newSubject";}

    @RequestMapping("/adminIndex/editSubject")
    public String editSubject(){return "editSubject";}

    @RequestMapping("/adminIndex/editTerm")
    public String editTerm(){return "editTerm";}

    @RequestMapping("/adminIndex/newOverallResults")
    public String newOverallResults(){return "newOverallResults";}

    @RequestMapping("/adminIndex/editOverallResults")
    public String editOverallResults(){return "editOverallResults";}

    @RequestMapping("/adminIndex/newTermFinances")
    public String newTermFinances(){return "newTermFinances";}

    @RequestMapping("/adminIndex/editTermFinances")
    public String editTermFinances(){return "editTermFinances";}

    @RequestMapping("/adminIndex/newOverallFinances")
    public String newOverallFinances(){return "newOverallFinances";}

    @RequestMapping("/adminIndex/editOverallFinances")
    public String editOverallFinances(){return "editOverallFinances";}
    @RequestMapping("/auth/login")
    public String login(){return "login";}
    @RequestMapping("/auth/register")
    public String register(){return "register";}

}
