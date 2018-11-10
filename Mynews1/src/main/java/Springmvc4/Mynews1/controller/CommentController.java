package Springmvc4.Mynews1.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Springmvc4.Mynews1.entity.Comment;
import Springmvc4.Mynews1.entity.Folder;
import Springmvc4.Mynews1.entity.Photo;
import Springmvc4.Mynews1.entity.User;
import Springmvc4.Mynews1.repository.CommentRepository;
import Springmvc4.Mynews1.repository.FolderRepository;
import Springmvc4.Mynews1.repository.PhotoRepository;
import Springmvc4.Mynews1.repository.UserRepository;

@Controller
public class CommentController {
	
	@Autowired
	private CommentRepository cr;
	@Autowired
	private PhotoRepository pr;
	@Autowired
	private FolderRepository fr;
	@Autowired
	private UserRepository ur;
	
	
	@RequestMapping("/tocommentPhoto")
	public String prepareComment(HttpSession session,@RequestParam("id")Integer photoid
	,@RequestParam("folderid")Integer folderid,Model model) {
		Photo photo=pr.findById(photoid);
		User user=(User) session.getAttribute("user");
		System.out.println("使用者"+user.getUserName());
		model.addAttribute("photo", photo);
		return "commentphoto";
		
	}
	
	
	@RequestMapping("/addcomment")
	public String addComment(HttpSession session,@RequestParam("id")Integer photoid,
	@RequestParam("folderid")Integer folderid,@RequestParam("content")String content) {
		System.out.print("進入添加");
		Folder folder=fr.findById(folderid);
		User user=(User) session.getAttribute("user");
		Date current_date = new Date();
		int statu_s=1;
		int commentNumber=cr.addComment(photoid, folderid, folder.getUserid(), user.getId(), content, current_date, statu_s);
		if(commentNumber==1) {
			return "addcomment_success";
		}
		return "addcomment_fail";
		
		
	}
	
	
	@RequestMapping("/getNewComment")
	public String getNewComment(HttpSession session) {
		User user=(User) session.getAttribute("user");
		
		List<Comment> commentList=cr.findByUserid(user.getId());
		System.out.println("進入我的動態"+commentList);
		if(commentList.size()==0) {
			commentList=null;
		}
		
		if(session.getAttribute("commentList")!=null) {
			List<Comment> commentsession=(List<Comment>) session.getAttribute("commentList");
			if(commentsession.size()==0) {
				session.setAttribute("commentList", commentList);
			}else {
				session.removeAttribute("commentList");
				session.setAttribute("commentList", commentList);
			}
		}else {
			session.setAttribute("commentList", commentList);
		}
		
		return "getAllComment";
		
	}
	
	
	@RequestMapping("/scancomment")
	public String scanComment(Model model,@RequestParam("id")Integer commentId) {
		Comment comment=cr.findById(commentId);
		String friendName=ur.findById(comment.getFriendid()).getUserName();
		String folderName=fr.findById(comment.getFolderid()).getFolderName();
		String photoName=pr.findById(comment.getPhotoid()).getPhotoName();
		String content=comment.getPhoto_comment();
		Date contentTime=comment.getComment_time();
		
		model.addAttribute("friendName", friendName);
		model.addAttribute("folderName", folderName);
		model.addAttribute("photoName", photoName);
		model.addAttribute("content", content);
		model.addAttribute("contentTime", contentTime);
		
		return "commentInfo";
		
	}
	

	@RequestMapping("/delcomment")
	public String delComment(@RequestParam("id")Integer commentId) {
		cr.delete(commentId);
		
		return "getAllComment";
		
	}
}
