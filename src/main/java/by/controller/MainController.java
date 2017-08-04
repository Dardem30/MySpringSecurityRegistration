package by.controller;

import by.DAO.DAORole;
import by.model.Employee;
import by.model.Message;
import by.model.Role;
import by.model.User;
import by.service.EmployeeService;
import by.service.MessageService;
import by.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Роман on 23.07.2017.
 */
@Controller
public class MainController {
    @Autowired
    private MessageService messageService;
    @Autowired
    @Qualifier("serviceUser")
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView modelAndView=new ModelAndView("index");
//        org.springframework.security.core.userdetails.User user= (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = this.userService.findByUsername(
                ((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername());
        modelAndView.addObject("user",user);
        modelAndView.addObject("employee",user.getEmployee());
        modelAndView.addObject("department",user.getEmployee().getDepartment());
        modelAndView.addObject("listEmployee",employeeService.listEmployee());
        modelAndView.addObject("message",new Message());
        modelAndView.addObject("listAdmin",employeeService.getEmployeeListAdmin());
        return modelAndView;
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
    @RequestMapping(value = "/userUpdate",method = RequestMethod.GET)
    public ModelAndView update(@RequestParam("id")int id){
        ModelAndView modelAndView=new ModelAndView("userUpdate");
        modelAndView.addObject("employee",employeeService.getById(id));
        return modelAndView;
    }
    @RequestMapping(value = "/userUpdate",method = RequestMethod.POST)
    public String update(@ModelAttribute("employee")Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/";
    }
    @RequestMapping(value = "/sendMessageToAdminEmployee",method = RequestMethod.POST)
    public String sendMessageToEmployee(@ModelAttribute("message")Message message){
        messageService.sendMessageById(message);
        return "redirect:/";
    }
}
