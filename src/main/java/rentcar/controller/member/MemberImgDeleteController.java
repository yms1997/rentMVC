package rentcar.controller.member;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.dao.MemberDAO;
import rentcar.frontController.Controller;
import rentcar.vo.MemberVO;

public class MemberImgDeleteController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String saveDirectory = request.getServletContext().getRealPath("/Uploads");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		MemberVO vo = MemberDAO.getInstance().memberContent(no);
		Path filePath = Paths.get(saveDirectory, vo.getsFileName());
		
		try {
			Files.deleteIfExists(filePath);
			System.out.println("파일 삭제 완료");
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		int cnt = MemberDAO.getInstance().memberUploadPhoto(no, null, null);
		if(cnt > 0) {
			response.getWriter().print("success");
		}
		else {
			response.getWriter().print("fail");
		}
		return null;
	}
}
