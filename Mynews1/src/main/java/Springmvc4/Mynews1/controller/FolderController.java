package Springmvc4.Mynews1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Springmvc4.Mynews1.entity.Folder;
import Springmvc4.Mynews1.entity.User;
import Springmvc4.Mynews1.repository.FolderRepository;

@Controller
public class FolderController {

	@Autowired
	private FolderRepository fr;
	
	@ModelAttribute("folder")
    public Folder formBackingObject() {
        return new Folder();
    }
	
	@RequestMapping("/createFolder")
	public String createFolder(Model model) {
		return "createFolder";
		
	}
	
	
	@RequestMapping("/addFolder")
	public String addFolders(HttpSession session,@ModelAttribute("folder")Folder folder) {
		//取得使用者id
		User user=(User) session.getAttribute("user");
		//計算目前比數，來當作id
		/*
		Integer count=fr.countNumber();
		if(count==null) {
			count=1;
		}else {
			count=count+1;
		}
		System.out.println(count);
		*/
		
		System.out.println(folder.toString()+user.toString());
		Integer addNum=fr.addFolder(folder.getFolderName(), folder.getFolderInfo(), folder.getLimitid(), user.getId());
		
		if(addNum==1) {
			System.out.println("添加成功");
			return "news";
		}
		
		return "createFolder";
		
	}
	
	private static final Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();
	
	@RequestMapping("scanFriendFolder")
	public String scanFriendFolder(HttpSession session,@RequestParam("id")Integer fid) {
		
		System.out.println("好友編號"+fid);
		List<Folder> friendFolderList=fr.findByUserid(fid);
		if(friendFolderList.size()==0) {
			friendFolderList=null;
		}
		
		session.setAttribute("friendFolderList", friendFolderList);
		
		return "scanfriendfolder";
		
	}
}
