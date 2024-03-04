package rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import rentcar.dao.RentcarDAO;
import rentcar.frontController.Controller;
import rentcar.vo.RentcarVO;

public class RentCarInsertController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String jsonData = request.getReader().readLine();
		System.out.println("jsonData = " + jsonData);
		Gson gson = new Gson();
		RentcarVO car = gson.fromJson(jsonData, rentcar.vo.RentcarVO.class);
		System.out.println("car = " + car);
		
		int check = RentcarDAO.getInstance().insertRentcar(car);
		if(check == 1) {
			response.getWriter().print(check);
		}
		else {
			response.getWriter().print("fali");
		}
		
		return null;
	}

}
