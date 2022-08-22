package model;

import DAO.RegisterDAO;
import scopedata.UserData;

public class RegisterLogic {
	public boolean execute(UserData account) {
		RegisterDAO dao = new RegisterDAO();
		int r = dao.execute(account);
		if(r==0) return false;
		return true;
	}
}
