package chapter12.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DownloadController {
	@GetMapping("/download.do")
	public void download(HttpServletRequest request, 
						HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		String file_repo = request.getRealPath(request.getParameter("path"));
		String fileName = request.getParameter("filename_real");
		String fileName_org = request.getParameter("filename_org");
		// 인코딩된 원본파일명을 다시 UTF-8로 ISO-8859-1로 인코딩
		fileName_org = new String(fileName_org.getBytes("UTF-8"),"ISO-8859-1");
		System.out.println("fileName="+fileName);
		OutputStream out = response.getOutputStream();
		String downFile = file_repo+"\\"+fileName;
		File f = new File(downFile);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Content-disposition", "attachment; fileName="+fileName_org);;
		FileInputStream in = new FileInputStream(f);
		byte[] buffer = new byte[1024*8];
		while(true) {
			int count = in.read(buffer);
			if (count == -1) {
				break;
			}
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}
}
