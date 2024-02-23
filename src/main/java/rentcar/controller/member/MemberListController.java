package rentcar.controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcar.dao.MemberDAO;
import rentcar.frontController.Controller;
import rentcar.vo.MemberVO;

public class MemberListController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<MemberVO> list = MemberDAO.getInstance().memberList();
		
		request.setAttribute("list", list);
		
		HttpSession session = request.getSession();
		if(session.getAttribute("log") != null) {
			int no = (int)session.getAttribute("log");
			request.setAttribute("no", no);
		}
		else {
			request.setAttribute("no", null);
		}
		return "member/memberList";
	}
}
