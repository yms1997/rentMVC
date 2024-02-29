package rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.dao.RentcarDAO;
import rentcar.frontController.Controller;
import rentcar.vo.RentcarVO;

public class RentCarSelectOptionController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		
		System.out.println("qty = " + qty);
		
		RentcarVO car = RentcarDAO.getInstance().getOneCar(no);
		request.setAttribute("car", car);
		request.setAttribute("qty", qty);
		return "rentcar/RentCarOption";
	}
}
