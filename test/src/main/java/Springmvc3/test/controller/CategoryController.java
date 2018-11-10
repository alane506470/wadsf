package Springmvc3.test.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Springmvc3.test.entity.Category;
import Springmvc3.test.repository.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository cr;
	
	@SuppressWarnings("unchecked")
	//@GetMapping("/")
    public String CategoryForm(Model model) throws ParseException {
         List<Category> cs = (List<Category>) cr.findAll();
         model.addAttribute("categories", cs);
         
         Category cs1= cr.findByTopId(12);
         model.addAttribute("categoriesbytopid", cs1);
         
         List<Category> cs2=(List<Category>) cr.findByIdBetween(10,15);
         model.addAttribute("categoriesbetween", cs2);
         
         List<Category> cs3=(List<Category>)cr.findByTopIdLessThanEqual(3);
         model.addAttribute("categoriesLessThanEqual", cs3);
         
         List<Category> cs4=(List<Category>)cr.findByTopIdGreaterThanEqual(13);
         model.addAttribute("categoriesGreaterThanEqual", cs4);
         
        
       //生成日期对象  
         Date current_date = new Date();  
         System.out.println(current_date);
         DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
         Date myDate1 = dateFormat1.parse("2018-08-06");
         List<Category> cs5=cr.findByStartdateAfter(myDate1);
         model.addAttribute("categoriesStartdateAfter", cs5);
         
         List<Category> cs6=cr.findByNameLike("p%");
         model.addAttribute("categoriesNameLike", cs6);
         
         List<Category> cs7=cr.findByNameContaining("o");
         model.addAttribute("categoriesNameContaining", cs7);

         
         return "category";
    }
}
