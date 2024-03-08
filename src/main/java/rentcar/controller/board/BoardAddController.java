package rentcar.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.dao.BoardDAO;
import rentcar.frontController.Controller;
import rentcar.vo.BoardVO;

public class BoardAddController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		String writer = request.getParameter("writer");
		
		BoardVO vo = null;
		vo = new BoardVO(writer, subject, contents);
		
		String ctx = request.getContextPath();
		int cnt = BoardDAO.getInstance().boardInsert(vo);
		if(cnt > 0) {
			return "redirect:" + ctx + "/boardList.do";
		}
		else {
			throw new ServletException("not Insert");
		}
	}

}
