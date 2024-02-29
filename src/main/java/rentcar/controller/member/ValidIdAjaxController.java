package rentcar.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.dao.MemberDAO;
import rentcar.frontController.Controller;

public class ValidIdAjaxController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String passData = MemberDAO.getInstance().isValidId(id) ? "notValid" : "valid";
		
		response.getWriter().print(passData);
		return null;
	}
}
