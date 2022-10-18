package app;

import java.awt.EventQueue;

import login.LoadAccounts;
import login.LoginPage;
import mainView.MainView;

public class Main {


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadAccounts idandPasswords = new LoadAccounts();
					
					LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

