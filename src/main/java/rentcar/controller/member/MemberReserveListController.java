package rentcar.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcar.dao.ReservationDAO;
import rentcar.frontController.Controller;
import rentcar.vo.ReservationViewVO;

public class MemberReserveListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath();
		HttpSession session = request.getSession();
		response.setCharacterEncoding("utf-8");
		
		String userid = (String)session.getAttribute("loginId");
		ArrayList<ReservationViewVO> list = ReservationDAO.getInstance().getJoinCarView(userid);
		
		for(ReservationViewVO vo : list) {
			if(vo == null) break;
			
			int totalCar = vo.getPrice() * vo.getQty() * vo.getDday();
			
			int option = 0;
			option = vo.getUsein() == 1 ? option + 10000 : option;
			option = vo.getUseseat() == 1 ? option + 10000 : option;
			option = vo.getUsewifi() == 1 ? option + 10000 : option;
			
			int totalOption = vo.getQty() * vo.getDday() * option;
			
			vo.setTotalPrice(totalOption + totalCar);
			
			LocalDate rentDate = LocalDate.parse(vo.getRday());
			LocalDate endDate = rentDate.plusDays(vo.getDday());
			vo.setEndDate(endDate.toString());
		}
		
		request.setAttribute("list", list);
		return "member/memberReserveList";
	}
	
}
