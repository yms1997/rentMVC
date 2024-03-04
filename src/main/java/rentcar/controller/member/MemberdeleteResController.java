package rentcar.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.dao.RentcarDAO;
import rentcar.dao.ReservationDAO;
import rentcar.frontController.Controller;
import rentcar.vo.CarReserveVO;

public class MemberdeleteResController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int regNo = Integer.parseInt(request.getParameter("regNo"));
		
		CarReserveVO book = ReservationDAO.getInstance().getOneReservation(regNo);
		RentcarDAO.getInstance().addTotalQty(book);
		int cnt = ReservationDAO.getInstance().deleteReservation(regNo);
		
		if(cnt == 0) {
			response.getWriter().print("fail");
		}
		else {
			response.getWriter().print(cnt);
		}
		return null;
	}
	
}
