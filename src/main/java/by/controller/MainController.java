package by.controller;

import by.DAO.DAORole;
import by.model.Role;
import by.model.User;
import by.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Роман on 23.07.2017.
 */
@Controller
public class MainController {
    @Autowired
    @Qualifier("serviceUser")
    private UserService userService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String main(){
        return "index";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm",new User());
        return "registration";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm")User user){
        userService.saveUser(user);
        return "redirect:/login";
    }
}
