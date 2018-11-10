package Springmvc4.Mynews1.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Springmvc4.Mynews1.entity.AFNews;
import Springmvc4.Mynews1.entity.Folder;
import Springmvc4.Mynews1.entity.Friend;
import Springmvc4.Mynews1.entity.News;
import Springmvc4.Mynews1.entity.User;
import Springmvc4.Mynews1.repository.FolderRepository;
import Springmvc4.Mynews1.repository.NewsRepository;
import Springmvc4.Mynews1.repository.UserRepository;
import Springmvc4.Mynews1.repository.friendRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository ur;
	@Autowired
	private friendRepository fr;
	@Autowired
	private FolderRepository folderr;
	@Autowired
	private NewsRepository nr;
	
	private List<News> news1;
	private List<News> news2;
	private List<News> news3;
	private List<News> news4;
	private List<News> news5;
	private List<News> news6;
	private List<AFNews> news7;
	private List<AFNews> news8;
	
	@ModelAttribute("user")
    public User formBackingObject() {
        return new User();
    }
	
	@GetMapping("/")
    public String newsForm(HttpSession session,Model model) throws ParseException {
		List<Date> birthdays=new ArrayList();
		for(int y=2017;y>2016;y--) {
			for(int month=1;month<=12;month++) {
					for(int day=1;day<=30;day++) {
						//System.out.println(y+"-"+month+"-"+day);
						String abc=y+"-"+month+"-"+day;
						//字串轉日期
						 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						birthdays.add(sdf.parse(abc));
						
				}
			}
		}
		session.setAttribute("birthdays", birthdays);
		return "user/login";
	}
	//顯示註冊介面
	@GetMapping("/intoregister")
	public String intoRegister(Model model) {
		return "register";
		
	}
	//登入
	@RequestMapping("/login")
    public String login(HttpSession session,@ModelAttribute("user")User user,Model model) {
		User login=(User) session.getAttribute("user");
		if(login==null) {
			User user1=ur.findByUserNameAndUserPassword(user.getUserName(), user.getUserPassword());
			if(user1==null) {
				//頁面印出用戶名或密碼部正確，請重新輸入
				return "login";
			}else {
				//登陸次數+1
				System.out.println("目前登陸次數"+user1.getNumber());
				ur.addUserNumber(user1.getNumber()+1, user1.getId());
				session.setAttribute("user", user1);
				//查詢相冊
				List<Folder> allFolderList=folderr.findByUserid(user1.getId());
				//System.out.println(allFolderList!=null);
				System.out.println("使用者相冊個數"+allFolderList.size());
				session.setMaxInactiveInterval(0);
				session.setAttribute("allFolderList", allFolderList);
				//查詢新聞
				news1=nr.selectTopIdList(1);
				session.setAttribute("news1", news1);
				news2=nr.selectTopIdList(2);
				session.setAttribute("news2", news2);
				news3=nr.selectTopIdList(3);
				session.setAttribute("news3", news3);
				news4=nr.selectTopIdList(4);
				session.setAttribute("news4", news4);
				news5=nr.selectTopIdList(5);
				session.setAttribute("news5", news5);
				news6=nr.selectTopIdList(6);
				session.setAttribute("news6", news6);
				return "news";
			}
		}else {
			List<Folder> allFolderList=folderr.findByUserid(login.getId());
			//System.out.println(allFolderList!=null);
			System.out.println("使用者相冊個數"+allFolderList.size());
			session.setMaxInactiveInterval(0);
			session.setAttribute("allFolderList", allFolderList);
			return "news";
		}
		
	}
	//註冊功能
	@RequestMapping("/register")
	public String register(@ModelAttribute("user")User user,Model model) {
		System.out.println("新增用戶資訊"+user.toString());
		User user1=ur.findByUserName(user.getUserName());
		
		if(user1!=null) {
			System.out.println("帳號已經有人使用");
			return "register";
		}else {
			Integer insertNum=ur.insertUser(user.getUserName(), user.getUserPassword(), user.getSex(), user.getBirthday(), user.getTelephone(), user.getEmail(), user.getAddress(), user.getRemark());
			if(insertNum==1) {
				System.out.println("歡迎加入");
				return "news";
			}
		}
		return "register";
		
	}
	//頁面導向，修改個人密碼和修改個人資料 (依據傳遞的參數signStr)
	@RequestMapping("/getLogin")
	public String getlogin(Model model,@RequestParam(value="signStr",required=false)Integer signStr) {
		if(signStr==null) {
			return "update_manager_pwd";
		}
		model.addAttribute("signStr", signStr);
		return "update_manager";
		
	}
	//數據庫修改，修改個人資料和修改個人 (密碼依據傳遞的參數signStr)
	@RequestMapping("/updateLogin")
	public String updateLogin(HttpSession session,@ModelAttribute(value="user")User updateuser,
			@RequestParam(value="password",required=false)String password,@RequestParam(value="signStr",required=false)Integer signStr) {
		if(signStr==null) {
			User user=(User) session.getAttribute("user");
			System.out.println(user);
			ur.updatePassword(password, user.getId());
			((User) session.getAttribute("user")).setUserPassword(password);
		
			return "show_login";
		}else {
			User user=(User) session.getAttribute("user");
			int number=ur.updateUser(updateuser.getUserName(), updateuser.getTelephone(), updateuser.getEmail(), updateuser.getAddress(), updateuser.getRemark(), user.getId());
			if(number==1) {
				User login=ur.findById(user.getId());
				session.setAttribute("user", login);
				return "show_login";
			}else {
				return "fail";
			}
			
		}
	}
	
	@RequestMapping("/findAllUsers")
	public String findAllUsers(HttpSession session,Model model) {
		List<User> allUserList=(List<User>) ur.findAll();
		session.setAttribute("allUserList", allUserList);
		return "allUserList";
		
	}
	
	
	@RequestMapping("/scanUser")
	public String scanUser(@RequestParam(value="id")Integer id,Model model) {
		User user=ur.findById(id);
		model.addAttribute("user", user);
		return "UserInfo";
	}
	
	
	@RequestMapping("/addFriend")
	public String addFriend(HttpSession session,@RequestParam(value="id")Integer fid,Model model) {
		User user=(User) session.getAttribute("user");
		System.out.println("現在使用者"+user.getUserName());
		Friend friend=fr.findByUseridAndFriendid(user.getId(),fid);
		if(friend!=null) {
			System.out.println("已經是共同好友，將返回登陸介面");
			return "login";
		}else {
			fr.addFriend(user.getId(), fid);
			System.out.println("恭喜加入好友");
			return "news";
		}
		
		
	}
	
	
	@RequestMapping("/findAllFriends")
	public String findAllFriends(@RequestParam(value="id")Integer userid,Model model) {
		List<Integer> friendsId=(List<Integer>) fr.findFriendId(userid);
		List<User> friendList=new ArrayList();
		int allFriends=friendsId.size();
		System.out.println("目前共有"+allFriends+"好友");
		for(int i=0;i<allFriends;i++) {
			User oneFriend=ur.findById(friendsId.get(i));
			friendList.add(oneFriend);
		}
		model.addAttribute("friendList", friendList);
		return "allFriendList";
		
	}
	
	@RequestMapping("/exit")
	public String exit(HttpSession session) {
		session.removeAttribute("user");
		//廢止
		session.invalidate();
		return "login";
		
	}
}
