package rentcar.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.dao.BoardDAO;
import rentcar.frontController.Controller;
import rentcar.vo.BoardVO;

public class BoardViewController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath();
		
		int no = -1;
		if(request.getParameter("no") == null) {
			return "redirect:" + ctx + "/boardList.do";
		}
		else {
			no = Integer.parseInt(request.getParameter("no"));
		}
		BoardVO vo = BoardDAO.getInstance().boardContent(no);
		request.setAttribute("vo", vo);
		
		int cnt = BoardDAO.getInstance().boardUpdateReadCnt(no);
		if(cnt > 0) {
			return "board/OneboardView";
		}
		else {
			throw new ServletException("not View");
		}
		
	}
	
}
