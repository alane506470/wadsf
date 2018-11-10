package Springmvc4.Mynews1.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Springmvc4.Mynews1.entity.AFNews;
import Springmvc4.Mynews1.entity.Category;
import Springmvc4.Mynews1.entity.News;
import Springmvc4.Mynews1.entity.Photo;
import Springmvc4.Mynews1.repository.CategoryPaging;
import Springmvc4.Mynews1.repository.CategoryRepository;
import Springmvc4.Mynews1.repository.NewsRepository;

@Controller
public class NewsController {

	@Autowired
	private NewsRepository nr;
	@Autowired
	private CategoryRepository cr;
	@Autowired
	private CategoryPaging cp;
	
	
	 @ModelAttribute("category")
	    public Category formBackingObject() {
		
	        return new Category();
	    }
	@RequestMapping("/categoryAction")
	public String category(@RequestParam(value="topId")Integer topId,Model model) {
		//根據一級類別查詢二級類別
		List<Category> cList= cr.findByTopId(topId);
		model.addAttribute("topId",topId);
		model.addAttribute("cList", cList);
		return "/category/category_list";
		
	}
	
	@RequestMapping("/getNewsList")
	public String getNewsList(HttpSession session,@RequestParam(value="pageCount",required=false)Integer pageCount,
			@RequestParam(value="pageNo",defaultValue="1")Integer pageNo,
			@RequestParam(value="topId")Integer topId,Model model) {
		System.out.println(topId);
		int pageSize=5;
		pageCount=nr.getPageCount(topId);
		if(pageCount%pageSize==0) {
			pageCount=pageCount/pageSize;
		}else {
			pageCount=pageCount/pageSize+1;
		}
		
		if(pageNo<1) {
			pageNo=1;
		}else if(pageNo>pageCount) {
			if(pageCount==0) {
				pageNo=1;
			}else {
			pageNo=pageCount;
			}
		}
		
		model.addAttribute("pageNumber", pageNo);
		pageNo=(pageNo-1)*pageSize;
		List<News> allnews=nr.selectListByTopId(topId,pageNo, pageSize);
		
		List<String> categoryName=cr.selectName(topId);
		
		model.addAttribute("pageCount", pageCount);
		session.setAttribute("topId", topId);
		model.addAttribute("cList",allnews);
		session.setAttribute("topName",categoryName);
		model.addAttribute("itdragonDate", new Date());
		return "/news/index_allnews";
		
	}
	
	@RequestMapping("/news")
	public String news(HttpSession session,@RequestParam(value="pageCount",required=false)Integer pageCount,
			@RequestParam(value="pageNo",defaultValue="1")Integer pageNo,
			@RequestParam(value="topId")Integer topId,Model model) {
		//根據一級類別查詢二級類別
		int pageSize=10;
		
		pageCount=nr.getPageCount(topId);
		System.out.println("這個新聞有幾筆"+pageCount);
		if(pageCount%pageSize==0) {
			pageCount=pageCount/pageSize;
		}else {
			pageCount=pageCount/pageSize+1;
		}
		System.out.println("這個新聞有幾頁"+pageCount);
		if(pageNo<1) {
			pageNo=1;
		}else if(pageNo>pageCount) {
			if(pageCount==0) {
				pageNo=1;
			}else {
			pageNo=pageCount;
			}
		}
		model.addAttribute("pageNumber", pageNo);
		pageNo=(pageNo-1)*pageSize;
		List<News> newsList=nr.selectListByTopId(topId,pageNo, pageSize);
		List<String> categoryName=cr.selectName(topId);
		System.out.print(categoryName);
		model.addAttribute("pageCount", pageCount);
		
		session.setAttribute("topId", topId);
		model.addAttribute("cList",newsList);
		session.setAttribute("topName",categoryName);
		model.addAttribute("itdragonDate", new Date());
		return "/news/newsList";
		
	}
	
	//改成news
	@RequestMapping("/newsList")
	public String newsList(@RequestParam(value="pageCount",required=false)Integer pageCount,
			@RequestParam(value="pageNo",defaultValue="1")Integer pageNo,
			@RequestParam(value="topId")Integer topId,Model model) {
		//根據一級類別查詢二級類別
		List<Category> cList= cr.findByTopId(topId);
		pageCount=cList.size();
		System.out.println("這個新聞有幾筆"+pageCount);
		if(pageNo<1) {
			pageNo=1;
		}else if(pageNo>pageCount) {
			if(pageCount==0) {
				pageNo=1;
			}else {
			pageNo=pageCount;
			}
		}
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageNumber", pageNo);
		pageNo=1*(pageNo-1);
		List<Category> categoryList=cr.getCategoryList(topId, pageNo);
		
		model.addAttribute("topId", topId);
		model.addAttribute("cList", categoryList);
		model.addAttribute("itdragonDate", new Date());
		return "newsList";
		
	}
	
	//瀏覽和修改新聞都會傳進來
	@GetMapping("/getNewsById")
	public String getNewsById(RedirectAttributes attributes,Model model,HttpSession session
		,@RequestParam(value="newsid") Integer newsid
		,@RequestParam(value="signStr",required=false)String signStr
		,@RequestParam(value="topId",required=false)Integer topId) {
		News news=nr.findById(newsid);
		model.addAttribute("news", news);
		//依據signStr屬性質
		if(signStr.equals("delete")||signStr=="delete"){
			nr.delete(newsid);
			attributes.addAttribute("topId",news.getCategory().getTopId());
			return "redirect:/news";
		}else if(signStr.equals("update")||signStr=="update") {
			List<Category> cList= cr.findByTopId(topId);
			model.addAttribute("cList", cList);
			//回傳編輯狀態
			return "update_news";
		}else if(signStr.equals("normal") || signStr=="normal"){
			//回傳查看詳情
			//獲取一級類別
			List<String> topName=cr.selectName(news.getCategory().getTopId());
			//獲取二級類別
			String categoryName=news.getCategory().getName();
			Integer cid=news.getCategory().getId();
			session.setAttribute("topName", topName);
			session.setAttribute("categoryName", categoryName);
			session.setAttribute("cid", cid);
			session.setAttribute("topId", topId);
			return "index_detail";
		}else {
			List<String> topName=cr.selectName(news.getCategory().getTopId());
			session.setAttribute("topName", topName);
			session.setAttribute("topId", topId);
			return "detail_news";
		}
		
	}
	
	
	
	//改成getnewsbyid
	@GetMapping("/category")
	public String updateNews(HttpSession session,
			@RequestParam(value="newsid") Integer newsid,
			@RequestParam(value="topId") Integer topId,
			@PageableDefault(value = 1, sort = { "id" }, direction = Sort.Direction.ASC)Pageable pageable,Model model) {
		Category news=cr.findById(newsid);
		String cname=cr.findById(newsid).getName();
		String topName=nr.findById(topId).getTitle();
		session.setAttribute("news", news);
		session.setAttribute("cname", cname);
		session.setAttribute("topName", topName);
		return "clist";
	}
	//導入新增新聞詳情
	@GetMapping("/addInputNews")
	public String addInputNews(Model model,@RequestParam(value="topId")Integer topId) {
		
		List<Category> cList=cr.findByTopId(topId);
		model.addAttribute("cList", cList);
		return "input_news";
		
	}
	
	//導入新增新聞類別
	@GetMapping("/inputCategory")
	public String inputCategory(@RequestParam(value="topId")Integer tid,Model model) {
		model.addAttribute("topId", tid);
		return "input_category";
	}
	
	//新增新聞詳情
	@RequestMapping("/addNews")
	public String addNews(RedirectAttributes attributes,
			@ModelAttribute("news")News news,@RequestParam("cid")Integer cid) {
		news.setCreateTime(new Date());	
		news.setCategory(cr.findById(cid));
		System.out.print(news);
		nr.save(news);
		attributes.addAttribute("topId",news.getCategory().getTopId());
		return "redirect:/news";
	
		
	}
	
	//新增新聞類別
	@RequestMapping("/addCategory")
	public String addCategory(RedirectAttributes attributes,
			@ModelAttribute("category")Category category,
	Model model) {
		System.out.println("進入新增類別方法，新增類別種類為"+category.getTopId());
		Date current_date = new Date();
		cr.save(category);
		//Integer addnum=cr.insertCategory(category.getName() ,category.getTopId(), current_date,category.getContent());
		/*
		if(addnum!=1) {
			System.out.println("添加失敗");
		}
		*/
		attributes.addAttribute("topId", category.getTopId());
		return "redirect:/categoryAction";
		
	}
	
	//改為@GetMapping("/getNewsById")
	@RequestMapping("/updateInput")
	public String updateInput(@RequestParam(value="categoryid")Integer id,
	Model model) {
		System.out.println("進入準備修改方法，類別為"+id);
		Category category=cr.findById(id);
		model.addAttribute("category", category);
		return "updatecategory";
		
	}
	
	//編輯新聞詳情
	@RequestMapping("/updateNews")
	public String updateNews(RedirectAttributes attributes
			,@ModelAttribute("news")News news
			,@RequestParam("cid")Integer cid,
			Model model) {
		news.setCreateTime(new Date());
		news.setCategory(cr.findById(cid));
		System.out.println(news);
		nr.updateNew(news.getTitle(), news.getContent(), news.getCreateTime(),news.getCategory(),news.getId());
		attributes.addAttribute("topId", news.getCategory().getTopId());
		return "redirect:/news";
		
	}
	
	
	//編輯新聞類別
	@RequestMapping("/updateCategory")
	public String updateCategory(RedirectAttributes attributes,@ModelAttribute("category")Category category,
	Model model) {
		System.out.println("進入修改類別方法，修改類別編號"+category.getId());
		Integer updatenum=cr.updateCategory(category.getName(), category.getTopId(),category.getContent(),category.getId() );
		if(updatenum!=1) {
			System.out.println("修改失敗");
		}
		attributes.addAttribute("topId", category.getTopId());
		return "redirect:/categoryAction";
		
	}
	
	//刪除新聞類別
	@RequestMapping("/delCategory")
	public String updateCategory(RedirectAttributes attributes,
			@RequestParam(value="topId")Integer topId,@RequestParam(value="categoryid")Integer id,
			Model model) {
				System.out.println("進入刪除類別方法，刪除類別為"+id);
				
				cr.delete(id);
				attributes.addAttribute("topId",topId);
				return "redirect:/categoryAction";
				
			}
	
	
	/*
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
	*/
}
