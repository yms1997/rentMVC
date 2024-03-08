package rentcar.frontController;

import java.util.HashMap;

import rentcar.controller.board.BoardAddController;
import rentcar.controller.board.BoardContentController;
import rentcar.controller.board.BoardDeleteController;
import rentcar.controller.board.BoardInsertController;
import rentcar.controller.board.BoardListController;
import rentcar.controller.board.BoardUpdateController;
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
import rentcar.controller.member.MemberdeleteResController;
import rentcar.controller.member.ValidIdAjaxController;
import rentcar.controller.rentcar.RentCarInfoController;
import rentcar.controller.rentcar.RentCarInsertController;
import rentcar.controller.rentcar.RentCarListController;
import rentcar.controller.rentcar.RentCarRegisterController;
import rentcar.controller.rentcar.RentCarReservationController;
import rentcar.controller.rentcar.RentCarSelectOptionController;
import rentcar.controller.rentcar.RentCarUploadImgController;

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
		mappings.put("/deleteRes.do", new MemberdeleteResController());
//		rentcarController
		mappings.put("/rentcarList.do", new RentCarListController());
		mappings.put("/rentcarInfo.do", new RentCarInfoController());
		mappings.put("/selectCarOption.do", new RentCarSelectOptionController());
		mappings.put("/reservateCar.do", new RentCarReservationController());
		mappings.put("/registerCar.do", new RentCarRegisterController());
		mappings.put("/uploadCarImg.do", new RentCarUploadImgController());
		mappings.put("/insertCar.do", new RentCarInsertController());
//		boardController
		mappings.put("/boardList.do", new BoardListController());
		mappings.put("/boardContent.do", new BoardContentController());
		mappings.put("/boardUpdate.do", new BoardUpdateController());
		mappings.put("/boardDelete.do", new BoardDeleteController());
		mappings.put("/boardInsert.do", new BoardInsertController());
		mappings.put("/Addboard.do", new BoardAddController());
	}
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
