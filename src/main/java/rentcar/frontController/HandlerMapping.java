package rentcar.frontController;

import java.util.HashMap;

import rentcar.controller.member.MainController;
import rentcar.controller.member.MemberAddController;
import rentcar.controller.member.MemberContentController;
import rentcar.controller.member.MemberDeleteController;
import rentcar.controller.member.MemberImgDeleteController;
import rentcar.controller.member.MemberImgUploadController;
import rentcar.controller.member.MemberInsertController;
import rentcar.controller.member.MemberListController;
import rentcar.controller.member.MemberLoginCheckController;
import rentcar.controller.member.MemberLoginController;
import rentcar.controller.member.MemberLogoutController;
import rentcar.controller.member.MemberReserveListController;
import rentcar.controller.member.MemberUpdateController;
import rentcar.controller.member.ValidIdAjaxController;
import rentcar.controller.rentcar.RentCarInfoController;
import rentcar.controller.rentcar.RentCarListController;
import rentcar.controller.rentcar.RentCarReservationController;
import rentcar.controller.rentcar.RentCarSelectOptionController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/main.do", new MainController());
//		memberController
		mappings.put("/memberLogin.do", new MemberLoginController());
		mappings.put("/memberLoginCheck.do", new MemberLoginCheckController());
		mappings.put("/memberLogout.do", new MemberLogoutController());
		mappings.put("/memberList.do", new MemberListController());
		mappings.put("/memberDelete.do", new MemberDeleteController());
		mappings.put("/memberInsert.do", new MemberInsertController());
		mappings.put("/memberAdd.do", new MemberAddController());
		mappings.put("/memberContent.do", new MemberContentController());
		mappings.put("/memberUpdate.do", new MemberUpdateController());
		mappings.put("/validIdAjax.do", new ValidIdAjaxController());
		mappings.put("/memberUploadImg.do", new MemberImgUploadController());
		mappings.put("/memberDeleteImg.do", new MemberImgDeleteController());
		mappings.put("/userReserveList.do", new MemberReserveListController());
//		rentcarController
		mappings.put("/rentcarList.do", new RentCarListController());
		mappings.put("/rentcarInfo.do", new RentCarInfoController());
		mappings.put("/selectCarOption.do", new RentCarSelectOptionController());
		mappings.put("/reservateCar.do", new RentCarReservationController());
	}
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
