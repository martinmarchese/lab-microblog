package microblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Spring MVC Controller instance
@Controller
public class HomeController {
    //Handles HTTP GET requests to /
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}