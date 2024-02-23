package rentcar.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcar.dao.MemberDAO;
import rentcar.frontController.Controller;

public class MemberLoginController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (request.getParameter("id") == null) {
			return "member/memberLogin";
		}
		String pw = request.getParameter("pw");
		String ctx = request.getContextPath();
		String check = MemberDAO.getInstance().checkLogin(id, pw);
		
		if(check == null) {
			System.out.println("로그인 실패");
			return "redirect:" + ctx + "/memberLogin.do";
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("log", MemberDAO.getInstance().getMemberNo(id));
			session.setAttribute("loginId", id);
			System.out.println("로그인 성공");
			return "redirect:" + ctx + "/main.do";
		}
	}
}
