package rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcar.dao.RentcarDAO;
import rentcar.frontController.Controller;
import rentcar.vo.RentcarVO;

public class RentCarInfoController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		RentcarVO vo = RentcarDAO.getInstance().getOneCar(no);
		
		request.setAttribute("vo", vo);
		return "rentcar/RentCarInfo";
	}
}
