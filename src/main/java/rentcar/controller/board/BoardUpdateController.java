package rentcar.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.dao.BoardDAO;
import rentcar.frontController.Controller;
import rentcar.vo.BoardVO;

public class BoardUpdateController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("no") == null) {
			return "board/boardList";
		}
		
		int no = Integer.parseInt(request.getParameter("no"));
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		
		BoardVO vo = new BoardVO();
		vo.setNo(no);
		vo.setSubject(subject);
		vo.setContents(contents);
		
		String ctx = request.getContextPath();
		int cnt = BoardDAO.getInstance().boardUpdate(vo);
		if(cnt > 0) {
			return "redirect:" + ctx + "/boardList.do";
		}
		else {
			throw new ServletException("not update");
		}
	}
	
}
