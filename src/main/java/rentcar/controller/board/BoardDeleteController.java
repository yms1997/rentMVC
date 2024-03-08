package rentcar.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.dao.BoardDAO;
import rentcar.frontController.Controller;

public class BoardDeleteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ctx = request.getContextPath();
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		int cnt = BoardDAO.getInstance().boardDelete(no);
		if(cnt > 0) {
			return "redirect:" + ctx + "/boardList.do";
		}
		else {
			throw new ServletException("not Delete");
		}
	}
	
}
