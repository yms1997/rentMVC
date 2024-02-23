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
import rentcar.vo.MemberVO;

public class MemberAddController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String saveDirectory = request.getServletContext().getRealPath("/Uploads");
		
		Path saveDirPath = Paths.get(saveDirectory);
		if(!Files.isDirectory(saveDirPath)) {
			Files.createDirectories(saveDirPath);
		}
		
		MultipartRequest multi = new MultipartRequest(request, saveDirPath.toString(), 5 * 1024 * 1024, "UTF-8",
				new DefaultFileRenamePolicy());
		
		String sFileName = null;
		String oFileName = null;
		if(multi.getFilesystemName("uploadFile") != null) {
			sFileName = multi.getFilesystemName("uploadFile");
			oFileName = multi.getOriginalFileName("uploadFile");
			String fileType = multi.getContentType("uploadFile");
			System.out.println("fileType= " + fileType);
		}
		
		String id = multi.getParameter("id");
		String pw = multi.getParameter("pw");
		String email = multi.getParameter("email");
		String tel = multi.getParameter("tel");
		String hobby = multi.getParameter("hobby");
		String job = multi.getParameter("job");
		String age = multi.getParameter("age");
		String info = multi.getParameter("info");
		MemberVO vo = null;
		vo = new MemberVO(id, pw, email, tel, hobby, job, age, info, oFileName, sFileName);
		
		String ctx = request.getContextPath();
		int cnt = MemberDAO.getInstance().memberInsert(vo);
		if(cnt > 0) {
			return "redirect:" + ctx + "/memberList.do";
		}
		else {
			throw new ServletException("not insert");
		}
	}
}
