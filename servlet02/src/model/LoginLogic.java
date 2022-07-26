package model;

import DAO.AccountDAO;
import scopedata.UserData;

public class LoginLogic {
	public boolean execute(UserData login) {
		AccountDAO dao = new AccountDAO();
		UserData account = dao.findUserCheck(login);
		if(account == null) return false;
		else                return true;
	}
}
