package com.pluralsight.demos;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig(
		fileSizeThreshold=1024*1024*2,	//2Mb
		maxFileSize=1024*1024*10,//10MB
		maxRequestSize=1024*1024*50//50MB
		
		
		)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String SAVE_DIR = "UploadFiles";//目錄路徑
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String appPath=request.getServletContext().getRealPath("");
		System.out.println(appPath);
		String savePath=appPath+File.separator+SAVE_DIR;
		System.out.println(savePath);
		File fileSaveDir=new File(savePath);
		if(!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}
		
		for(Part part:request.getParts()) {
			String fileName=extractFileName(part);
			part.write(savePath+File.separator+fileName);
		}
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>File Upload Result</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h3>File Upload Successfully</h3>");
		
		out.println("<body>");
		out.println("</html>");
	}
	
	private String extractFileName(Part part) {
		String contentDisp=part.getHeader("content-disposition");//提取位置標頭信息中的內容看起來像form-data:name=
		System.out.println(contentDisp);						//dataFile:fileName=
		String[] items=contentDisp.split(";");
		System.out.println(items.toString());
		for(String s:items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=")+2, s.length()-1);
			}
		}
		return "";
	}

}
