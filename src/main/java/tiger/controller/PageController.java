package tiger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2017/4/11.
 */
@Controller
public class PageController {

    @RequestMapping(value = "/")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/success")
    public String success(){
        return "success";
    }

    @RequestMapping(value = "/error")
    public String error(){
        return "error";
    }

    @RequestMapping(value = "/unauthorized" )
    public String unauthorized(){
        return "unauthorized";
    }

}
