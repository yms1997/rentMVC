package rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import rentcar.dao.RentcarDAO;
import rentcar.dao.ReservationDAO;
import rentcar.frontController.Controller;
import rentcar.vo.CarReserveVO;

public class RentCarReservationController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String jsonData = request.getReader().readLine();
		System.out.println("jsonData = " + jsonData);
		Gson gson = new Gson();
		CarReserveVO book = gson.fromJson(jsonData, rentcar.vo.CarReserveVO.class);
		int cnt = ReservationDAO.getInstance().addReservation(book);
		System.out.println("cnt = " + cnt);
		RentcarDAO.getInstance().reduceTotalQty(book);
		
		if(cnt == 1) {
			response.getWriter().print(cnt);
		}
		else {
			response.getWriter().print("fail");
		}
		
		return null;
	}
	
}
