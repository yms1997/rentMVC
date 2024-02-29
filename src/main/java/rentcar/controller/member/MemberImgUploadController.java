package rentcar.controller.member;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import rentcar.dao.MemberDAO;
import rentcar.frontController.Controller;

public class MemberImgUploadController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String saveDirectory = request.getServletContext().getRealPath("/Uploads");
		
		Path saveDirPath = Paths.get(saveDirectory);
		if(!Files.isDirectory(saveDirPath)) {
			Files.createDirectories(saveDirPath);
		}
		
		if(request.getParameter("sName") != null) {
			Path filePath = Paths.get(saveDirectory, request.getParameter("sName"));
			try {
				Files.deleteIfExists(filePath);
				System.out.println("파일 삭제 완료");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		MultipartRequest multi = new MultipartRequest(request, saveDirPath.toString(), 5 * 1024 *1024, "UTF-8", 
				new DefaultFileRenamePolicy());
		String sFileName = null;
		String oFileName = null;
		
		if(multi.getFilesystemName("uploadFile") != null) {
			sFileName = multi.getFilesystemName("uploadFile");
			oFileName = multi.getOriginalFileName("uploadFile");
		}
		
		int no = Integer.parseInt(multi.getParameter("no"));
		response.setCharacterEncoding("utf-8");
		int cnt = MemberDAO.getInstance().memberUploadPhoto(no, oFileName, sFileName);
		if(cnt > 0) {
			response.getWriter().print(sFileName);
		}
		else {
			response.getWriter().print("fail");
		}
		return null;
	}
}
