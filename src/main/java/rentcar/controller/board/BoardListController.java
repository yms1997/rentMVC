package rentcar.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.dao.BoardDAO;
import rentcar.frontController.Controller;
import rentcar.vo.BoardVO;

public class BoardListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<BoardVO> list = BoardDAO.getInstance().boardList();
		int cnt = BoardDAO.getInstance().countboardList();
		System.out.println(cnt);
		
		request.setAttribute("list", list);
		request.setAttribute("totalCount", cnt);
		
		return "board/boardList";
	}
	
}
