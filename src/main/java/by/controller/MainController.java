package by.controller;

import by.DAO.DAORole;
import by.model.*;
import by.service.EmployeeService;
import by.service.MessageService;
import by.service.ServiceEmployeeDate;
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
    private ServiceEmployeeDate serviceEmployeeDate;
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
        modelAndView.addObject("employeeDate",new EmployeeDate());
        return modelAndView;
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView=new ModelAndView("registrationEmployee");
        modelAndView.addObject("employee",new Employee());
        modelAndView.addObject("listDepartment",employeeService.getListDepartment());
        return modelAndView;
    }
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String registration(@ModelAttribute("employee")Employee employee,Model model){
        employeeService.saveEmployee(employee);
        model.addAttribute("employee",employee);
        return "redirect:/registrationUser";
    }
    @RequestMapping(value = "/registrationUser",method = RequestMethod.GET)
    public String registrationUser(@ModelAttribute("employee")Employee employee, Model model){
        model.addAttribute("userForm",new User());
        model.addAttribute("employee",employee);
        return "registration";
    }
    @RequestMapping(value = "/registrationUser",method = RequestMethod.POST)
    public String registrationUser(@ModelAttribute("userForm")User user,@ModelAttribute("employee")Employee employee){
        user.setEmployee(employee);
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
  @RequestMapping(value = "/saveEmployeeDate",method = RequestMethod.GET)
  public ModelAndView saveEmployeeDate(){
        ModelAndView modelAndView=new ModelAndView("saveDate");
        modelAndView.addObject("employeeDate",new EmployeeDate());
        return modelAndView;
  }
    @RequestMapping(value = "/saveEmployeeDate",method = RequestMethod.POST)
    public String saveEmployeeDate(@ModelAttribute("employeeDate")EmployeeDate employeeDate){
        this.serviceEmployeeDate.saveEmployeeDate(employeeDate);
        return "redirect:/";
    }
}
