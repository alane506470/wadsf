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
import Springmvc3.test.entity.News;
import Springmvc3.test.repository.CategoryRepository;
import Springmvc3.test.repository.NewsRepository;

@Controller
public class NewsController {

	@Autowired
	private NewsRepository nr;
	private CategoryRepository cr;
	
	
	@GetMapping("/news")
    public String newsForm(Model model) {
		/*
		Category cs1= cr.findByTopId(12);
		nr.updateCategory(cs1.getId(), 2);
		*/
		nr.delete(3);
		List<News> nc=(List<News>) nr.findAll();
		if(nc==null) {
			System.out.println("news沒有連接");
		}
		for(News o:nc) {
		System.out.println("news"+o);
		}
		 model.addAttribute("AllNews", nc);
		 model.addAttribute("abc", "test");
		return "news";
		
		
	}
	

	@GetMapping("/updatenews")
	public String updateNews(Model model) throws ParseException {
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate1 = dateFormat1.parse("2018-08-09");
		Integer num=nr.updateNew("動漫","熱血", myDate1, 1);
		System.out.println("更新狀態:"+"  "+num);
		List<News> nc=(List<News>) nr.findAll();
		model.addAttribute("AllNews", nc);
		return "updatenews";
	}
	
	@GetMapping("/addnews")
	public String addNews(Model model) throws ParseException {
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate1 = dateFormat1.parse("2018-08-10");
        Date myDate2 = dateFormat1.parse("2018-08-11");
        Date myDate3 = dateFormat1.parse("2018-08-12");
        Date myDate4 = dateFormat1.parse("2018-08-13");
        News news=new News();
        news.setId(3);
        news.setTitle("觀光旅遊");
        news.setContent("日本");
        news.setCreateTime(myDate1);
        nr.save(news);
        News news1=new News();
        news1.setId(4);
        news1.setTitle("醫療保健");
        news1.setContent("物理");
        news1.setCreateTime(myDate2);
        nr.save(news1);
        News news2=new News();
        news2.setId(5);
        news2.setTitle("生物科技");
        news2.setContent("金魚");
        news2.setCreateTime(myDate3);
        nr.save(news2);
        News news3=new News();
        news3.setTitle("旅遊");
        news3.setContent("海底");
        news3.setCreateTime(myDate4);
        nr.save(news3);
     
		List<News> nc1=(List<News>) nr.findAll();
		model.addAttribute("AllNews", nc1);
		return "addnews";
	}
}
