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
		int totalCount = BoardDAO.getInstance().countboardList();
//		System.out.println(cnt);
		
		
		
		request.setAttribute("list", list);
		request.setAttribute("totalCount", totalCount);
		
		int boardCnt = 3; // 한페이지에 보여줄게시글수
		int curPageNum = 1; // 현재페이지번호
		if(request.getParameter("start") != null) {
			curPageNum = Integer.parseInt(request.getParameter("start"));
		}
//		System.out.println("curPageNum(현재페이지번호) = " + curPageNum);
		int PoststartNum = (curPageNum - 1) * boardCnt; // 현재페이지의게시글시작번호
//		System.out.println("PoststartNum(현재페이지의게시글시작번호) = " + PoststartNum);
		int PostEndNum = PoststartNum + boardCnt; // 현재페이지의게시글마지막번호
//		System.out.println("PostEndNum(현재페이지의게시글마지막번호) = " + PostEndNum);
		if(PostEndNum > totalCount) {
			PostEndNum = totalCount;
		}
		
		request.setAttribute("PoststartNum", PoststartNum);
		request.setAttribute("PostEndNum", PostEndNum);
		
		int totalPage = totalCount / boardCnt; // 총페이지수
		int startPageNum = 1; // 한페이지에보여줄페이지시작번호
		int pageNumCnt = 3; // 한페이지에보여줄페이지번호개수
		if(totalCount % boardCnt > 0) {
			totalPage += 1;
		}
//		System.out.println("totalPage(총페이지수) = " + totalPage);
		if(request.getParameter("curNum") != null) {
			startPageNum = Integer.parseInt(request.getParameter("curNum"));
		}
		int EndPageNum = startPageNum + pageNumCnt - 1;
		if(EndPageNum > totalPage) {
			EndPageNum = totalPage;
		}
//		System.out.println("startPageNum(한페이지에보여줄페이지시작번호) = " + startPageNum);
//		System.out.println("pageNumCnt(한페이지에보여줄페이지번호개수) = " + pageNumCnt);
		
		
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("EndPageNum", EndPageNum);
		request.setAttribute("pageNumCnt", pageNumCnt);
		request.setAttribute("totalPage", totalPage);
		
		
		return "board/boardList";
	}
	
}
