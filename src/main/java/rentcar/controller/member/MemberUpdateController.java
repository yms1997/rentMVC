package rentcar.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.dao.MemberDAO;
import rentcar.frontController.Controller;
import rentcar.vo.MemberVO;

public class MemberUpdateController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("no") == null) {
			return "member/memberContent";
		}
		int no = Integer.parseInt(request.getParameter("no"));
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String hobby = request.getParameter("hobby");
		String job = request.getParameter("job");
		String age = request.getParameter("age");
		String info = request.getParameter("info");
		
		MemberVO vo = new MemberVO();
		vo.setNo(no);
		vo.setEmail(email);
		vo.setTel(tel);
		vo.setHobby(hobby);
		vo.setJob(job);
		vo.setAge(age);
		vo.setInfo(info);
		
		String ctx = request.getContextPath();
		int cnt = MemberDAO.getInstance().memberUpdate(vo);
		if(cnt > 0) {
			return "redirect:" + ctx + "/memberList.do";
		}
		else {
			throw new ServletException("not update");
		}
	}
}
