package com.mynews.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mynews.model.Category;
import com.mynews.service.CategoryService;

@Controller
public class CategoryController {

	//aop實現
    @Autowired
    private CategoryService categoryService;
    
    @RequestMapping("/")
    public String newsForm(Locale locale, Model model) {
    	/*
    	if((userService.list()!=null)){
    		System.out.println(userService.list().get(0).getName());
    		System.out.println(userService.list().get(1).getName());
    		model.addAttribute("Users", userService.list());
    	}
    	*/
    	  /*
    	  ModelAndView mv = new ModelAndView("editUsers");
          mv.addObject("Users",  userService.list());
          return mv;
          */
    	/*
          model.addAttribute("Users", categoryService.selectListByTopId(topId));
          */
    	
          return "news";
    }
     
    @ModelAttribute("category")
    public Category formBackingObject() {
        return new Category();
    }
 
    @PostMapping("/shownews")
    public String saveUser(@ModelAttribute("category")Category category,
    						Model model) {
    	 System.out.println("目錄數字"+category.getTopId());
    	 System.out.println(categoryService.test());
    	 System.out.println(categoryService.list().get(2).getName());
    	 
    	 /*
         model.addAttribute("Users", categoryService.selectListByTopId(category.getTopId()));
            
         System.out.println(categoryService.selectListByTopId(category.getTopId()).get(0).getName());
         */
        
        return "redirect:/category_list";
    }
	
}
