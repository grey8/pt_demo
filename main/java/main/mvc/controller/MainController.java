package main.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by magenta9 on 2017/2/11.
 */
@Controller
@RequestMapping("/mvc")
public class MainController {
    @RequestMapping(value = "/listActionLog", method = RequestMethod.GET)
    public String hello() {
        return "list_action_log";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
