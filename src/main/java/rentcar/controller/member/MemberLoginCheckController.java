package rentcar.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcar.dao.MemberDAO;
import rentcar.frontController.Controller;

public class MemberLoginCheckController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String userId = MemberDAO.getInstance().checkLogin(id, pw);
		System.out.println("userId = " + userId);
		
		HttpSession session = request.getSession();
		
		if(userId != null) {
			session.setAttribute("loginId", id);
			session.setAttribute("log", MemberDAO.getInstance().getMemberNo(id));
			response.getWriter().print(userId);
		}
		else {
			response.getWriter().print("null");
		}
		
		return null;
	}
}
