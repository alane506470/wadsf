package Springmvc4.Mynews1.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import Springmvc4.Mynews1.entity.Category;
import Springmvc4.Mynews1.entity.User;
import Springmvc4.Mynews1.repository.CategoryRepository;
import Springmvc4.Mynews1.repository.UserRepository;



@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository cr;
	@Autowired
	private UserRepository ur;
	
	@SuppressWarnings("unchecked")
    public String CategoryForm(Model model) throws ParseException {
       
         
         return "category";
    }
	
	
}
