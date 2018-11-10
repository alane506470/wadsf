package Springmvc4.Mynews1.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import Springmvc4.Mynews1.entity.Category;
import Springmvc4.Mynews1.entity.Folder;
import Springmvc4.Mynews1.entity.Photo;
import Springmvc4.Mynews1.entity.User;
import Springmvc4.Mynews1.repository.PhotoPaging;
import Springmvc4.Mynews1.repository.PhotoRepository;

@Controller
public class PhotoController {
	
	@Autowired
	private PhotoRepository pr;
	@Autowired
	private PhotoPaging pg;

	@ModelAttribute("photo")
    public Photo formBackingObject() {
        return new Photo();
    }
	
	
	@RequestMapping("/preparePhoto")
	public String preparephoto(@RequestParam(value="id")Integer photoid,Model model) {
		Photo photo=pr.findById(photoid);
		model.addAttribute("photo", photo);
		return "editphoto";
	}
	
	@RequestMapping("/updatePhoto")
	public String editphoto(@RequestParam(value="id")Integer photoid,Model model) {
		
		
		return "editphoto";
	}
	@RequestMapping("/prepareUpload")
	public String prepareUpload(@RequestParam(value="id")Integer folderid,Model model) {
		model.addAttribute("folderid", folderid);
		return "uploadPhoto";
		
	}
	
	@RequestMapping("/upload")
	public String uploadPhoto(@RequestParam(value="file",required=false) MultipartFile file,
			@ModelAttribute("photo")Photo photo) {
		String photoName=generateFileName(file.getOriginalFilename());
		photo.setPhotoPath(photoName);
		photo.setCreateTime(new Date());
		System.out.println(photo.toString());
		System.out.println(createFile(file,photoName));
		
		
		//System.out.println(photo.getPhotoName()+photo.getPhotoPath()+photo.getPhotoInfo()+photo.getCreateTime()+photo.getFolderid());
		int addnum=pr.addPhoto(photo.getPhotoName(), photo.getPhotoPath(), photo.getPhotoInfo(), photo.getCreateTime(), photo.getFolderid());
		System.out.println("成功"+addnum);
		 
		 return "news";
		
	}
	
	@GetMapping("/scanFolder")
	public String scanFolder(HttpSession session,
	@RequestParam(value="id") Integer folderId,Model model) {
		System.out.println("進入使用者相冊編號"+folderId);
		List<Photo> cList=pr.findByFolderid(folderId);
		/*
		 * session時間一到這裡又會產生null
		User user=(User) session.getAttribute("user");
		System.out.println("登陸使用者"+user.getUserName());
		*/
		model.addAttribute("itdragonDate", new Date());
		model.addAttribute("cList", cList);
		model.addAttribute("folderId",folderId);
		return "photoList";
	}
	
	@RequestMapping("/scanPhoto")
	public String scanPhoto(@RequestParam(value="id",required=false)Integer folderid,
			@RequestParam(value="pageNumber",defaultValue = "1") Integer pageNumber,
			@PageableDefault(value = 1, sort = { "id" }, direction = Sort.Direction.ASC)Pageable pageable,
			Model model) {
		int totalPage=pr.countByFolderid(folderid);
		System.out.println("相冊"+folderid+" 有幾頁"+totalPage);
		if(totalPage>0) {
			totalPage=(totalPage%2==0?(totalPage/2):(totalPage/2+1));
		}
		if(totalPage==0) {
			pageNumber=1;
		}else {
			if(pageNumber<1) {
				pageNumber=1;
			}
			if(pageNumber>totalPage) {
				pageNumber=totalPage;
			}
		}
		model.addAttribute("pageNumber", pageNumber);
		pageNumber=2*(pageNumber-1);
		List<Photo> photoList=pr.getPhotoList(folderid, pageNumber);
		if(photoList.size()==0) {
			photoList=null;
		}
		model.addAttribute("photoList", photoList);
		
		
		
		/*
		List<Photo> pList=pr.getPhoto(fid, pageNumber);
		System.out.print(pList);
		model.addAttribute("page", pageNumber);
		model.addAttribute("pList", pList);
		*/
		return "photo";
		
	}
	
	
	@RequestMapping("/delPhoto")
	public String delPhoto(@RequestParam(value="id")Integer photoid,Model model) {
		int delnum=pr.delPhoto(photoid);
		if(delnum==1) {
			String information="刪除成功";
			model.addAttribute("information", information);
			return "news";
		}else {
			String information="刪除失敗";
			model.addAttribute("information", information);
			return "news";
		}
		
	
		
	}
	
	
	@RequestMapping("/scanFriendPhotos")
	public String scanFriendPhotos(@RequestParam(value="id",required=false)Integer folderid,
			@RequestParam(value="pageNumber",defaultValue = "1") Integer pageNumber,
			@PageableDefault(value = 1, sort = { "id" }, direction = Sort.Direction.ASC)Pageable pageable,
			Model model) {
		/*
		System.out.println("頁數:"+pageNumber);
		//自己設定 [number: 0, size 1, sort: id: ASC]
		//System.out.println(pageable.getPageNumber());
		//System.out.println(pageable);
		Page<Photo> photoList= pg.findAll(pageable);
		System.out.println(photoList);
		//不知道為何總頁數有2但是size()卻只有1
		System.out.println("總頁數:"+photoList.getTotalPages());
		System.out.println(photoList.getSize());
		
		//System.out.println("相片id:"+photoList.getContent().get(1).getId());
		
		if(photoList.getTotalPages()==0) {
			pageNumber=1;
		}else {
			if(pageNumber<1) {
				pageNumber=1;
			}
			if(pageNumber>photoList.getTotalPages()) {
				pageNumber=photoList.getTotalPages();
			}
			System.out.println("目前頁數"+pageNumber);
			model.addAttribute(	"pageNumber", pageNumber);
		}
		pageNumber=(pageNumber-1)*1;
		List pList=pr.getPhoto(pageNumber);
		System.out.println("目前pList"+pList);
		if(pList.size()==0) {
			pList=null;
			
		}
		model.addAttribute("pList", pList);
		*/
		
		
		
		/*
		List<Photo> pList=pr.getPhoto(fid, pageNumber);
		System.out.print(pList);
		model.addAttribute("page", pageNumber);
		model.addAttribute("pList", pList);
		*/
		int totalPage=pr.countByFolderid(folderid);
		System.out.println("相冊"+folderid+" 有幾頁"+totalPage);
		if(totalPage>0) {
			totalPage=(totalPage%2==0?(totalPage/2):(totalPage/2+1));
		}
		if(totalPage==0) {
			pageNumber=1;
		}else {
			if(pageNumber<1) {
				pageNumber=1;
			}
			if(pageNumber>totalPage) {
				pageNumber=totalPage;
			}
		}
		model.addAttribute("pageNumber", pageNumber);
		pageNumber=2*(pageNumber-1);
		List<Photo> friendphotoList=pr.getPhotoList(folderid, pageNumber);
		if(friendphotoList.size()==0) {
			friendphotoList=null;
		}
		model.addAttribute("friendphotoList", friendphotoList);
		return "scanfriendPhoto";
		
	}
	
	
	
	 private String createFile(MultipartFile file,String photoName) {
		 String rootPath = "E:\\eclipse ee\\eclipse-workspace\\Mynews1\\src\\main\\resources";
         File dir = new File(rootPath + File.separator + "static");
         if (!dir.exists()) {
             dir.mkdirs();
         }
    	 if (!file.isEmpty()) {
             try {
                 // 这里只是简单例子，文件直接输出到项目路径下。
                 // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                 // 还有关于文件格式限制、文件大小限制，详见：中配置。
            	 String targetName=photoName;
                 BufferedOutputStream out = new BufferedOutputStream(
                         new FileOutputStream(new File(dir.getAbsolutePath()+File.separator +targetName)));
                 out.write(file.getBytes());
                 out.flush();
                 out.close();
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
                 return "上传失败," + e.getMessage();
             } catch (IOException e) {
                 e.printStackTrace();
                 return "上传失败," + e.getMessage();
             }
             return "上传成功";
         } else {
             return "上传失败，因为文件是空的.";
         }
     }
    private String generateFileName(String fileName){
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String formatdate=format.format(new Date());
		int random=new Random().nextInt(10000);
		int position=fileName.lastIndexOf(".");
		String extension=fileName.substring(position);
		String newfilename=formatdate+"_"+random+extension;
		System.out.print(newfilename);
		return newfilename;
	}
}
