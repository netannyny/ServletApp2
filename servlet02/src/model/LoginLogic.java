package model;

import DAO.AccountDAO;
import scopedata.UserData2;

public class LoginLogic {
	public boolean execute(UserData2 login) {
		AccountDAO dao = new AccountDAO();
		UserData2 account = dao.findUserCheck(login);
		if(account == null) return false;
		else                return true;
	}
}
