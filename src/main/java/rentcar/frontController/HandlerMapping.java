package rentcar.frontController;

import java.util.HashMap;

import rentcar.controller.member.MainController;
import rentcar.controller.member.MemberAddController;
import rentcar.controller.member.MemberContentController;
import rentcar.controller.member.MemberDeleteController;
import rentcar.controller.member.MemberInsertController;
import rentcar.controller.member.MemberListController;
import rentcar.controller.member.MemberLoginController;
import rentcar.controller.member.MemberLogoutController;
import rentcar.controller.member.MemberUpdateController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/main.do", new MainController());
		mappings.put("/memberLogin.do", new MemberLoginController());
		mappings.put("/memberLogout.do", new MemberLogoutController());
		mappings.put("/memberList.do", new MemberListController());
		mappings.put("/memberDelete.do", new MemberDeleteController());
		mappings.put("/memberInsert.do", new MemberInsertController());
		mappings.put("/memberAdd.do", new MemberAddController());
		mappings.put("/memberContent.do", new MemberContentController());
		mappings.put("/memberUpdate.do", new MemberUpdateController());
	}
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
