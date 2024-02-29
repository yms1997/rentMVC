package rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.dao.RentcarDAO;
import rentcar.frontController.Controller;
import rentcar.vo.RentcarVO;

public class RentCarListController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String kind = request.getParameter("kind");
		if(request.getParameter("kind") == null) {
			return "rentcar/RentCarList";
		}
		String title = "";
		ArrayList<RentcarVO> list = null;
		if(kind.equals("recent")) {
			list = RentcarDAO.getInstance().getRecentCarlist();
			title = "최근 업데이트 렌트카";
		}
		else if(kind.equals("all")) {
			list = RentcarDAO.getInstance().getAllCarlist();
			title = "전체 렌트카";
		}
		else if(kind.equals("small")) {
			list = RentcarDAO.getInstance().getKindCarlist(1);
			title = "소형 렌트카";
		}
		else if(kind.equals("medium")) {
			list = RentcarDAO.getInstance().getKindCarlist(2);
			title = "중형 렌트카";
		}
		else if(kind.equals("large")) {
			list = RentcarDAO.getInstance().getKindCarlist(3);
			title = "대형 렌트카";
		}
		
		request.setAttribute("list", list);
		request.setAttribute("title", title);
		return "rentcar/RentCarList";
	}
}
