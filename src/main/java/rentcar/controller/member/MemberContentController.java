package rentcar.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcar.dao.MemberDAO;
import rentcar.frontController.Controller;
import rentcar.vo.MemberVO;

public class MemberContentController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ctx = request.getContextPath();
		
		int no = -1;

		if(request.getAttribute("no") == null) {
			return "redirect:" + ctx + "/memberLogin.do";
		}
		else {
			no = Integer.parseInt(request.getParameter("no"));
		}
		MemberVO vo = MemberDAO.getInstance().memberContent(no);
		request.setAttribute("vo", vo);
		return "member/memberContent";
	}
}
