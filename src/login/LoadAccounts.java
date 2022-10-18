package login;
import java.util.HashMap;

import conn.ConnJDBC;

public class LoadAccounts {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	public LoadAccounts(){
		
	}
	
	public HashMap<String, String> getLoginInfo(){
		return ConnJDBC.findAllAccount();
	}
}