package com.howtodoinjava.demo.controller;

import java.util.Locale;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.howtodoinjava.demo.dao.UserService;
import com.howtodoinjava.demo.model.User;
 
@Controller
public class UserController {
	
	//aop¹ê²{
    @Autowired
    private UserService userService;
 
    @RequestMapping("/")
    public String userForm(Locale locale, Model model) {
    	
    	if((userService.list()!=null)){
    		System.out.println(userService.list().get(0).getName());
    		System.out.println(userService.list().get(1).getName());
    		model.addAttribute("Users", userService.list());
    	}
    	  /*
    	  ModelAndView mv = new ModelAndView("editUsers");
          mv.addObject("Users",  userService.list());
          return mv;
          */
          model.addAttribute("Users", userService.list());
          return "editUsers";
    }
     
    @ModelAttribute("user")
    public User formBackingObject() {
        return new User();
    }
 
    @PostMapping("/addUser")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                            BindingResult result, Model model) {
 
        if (result.hasErrors()) {
            model.addAttribute("Users", userService.list());
            return "editUsers";
        }
        
        userService.save(user);
        model.addAttribute("Users", userService.list());
        return "redirect:/";
    }
}