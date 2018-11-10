package Springmvc3.test.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class FileUploadController {
	
	 // 访问路径为：http://ip:port/upload
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(HttpServletRequest request) {
    	//每更新一次都會創一個新的資源在C:\Users\guanyu\AppData\Local\Temp\
    	//所以不可能存到這個暫時資料夾，因為一更新又是空的資料夾
    	 String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        System.out.println(filePath);
    	 return "/uploadForm";
    }

    // 访问路径为：http://ip:port/upload/batch
    @RequestMapping(value = "/upload/batch", method = RequestMethod.GET)
    public String batchUpload() {
        return "/mutifileupload";
    }
	
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("name")String name,@RequestParam("file") MultipartFile file) {
        System.out.println(name);
    	return createFile(file);
    }
    private String createFile(MultipartFile file) {
    	 if (!file.isEmpty()) {
             try {
                 // 这里只是简单例子，文件直接输出到项目路径下。
                 // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                 // 还有关于文件格式限制、文件大小限制，详见：中配置。
            	 String rootPath = "E:\\eclipse ee\\mynews";
                 File dir = new File(rootPath + File.separator + "imageFiles");
                 if (!dir.exists()) {
                     dir.mkdirs();
                 }
                
            	 String targetName=generateFileName(file.getOriginalFilename());
                 BufferedOutputStream out = new BufferedOutputStream(
                         new FileOutputStream(new File(dir.getAbsolutePath()+File.separator +targetName)));
                // BufferedOutputStream out = new BufferedOutputStream(
                //         new FileOutputStream(new File(targetName)));
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
             return "redirect:/photoList";
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
