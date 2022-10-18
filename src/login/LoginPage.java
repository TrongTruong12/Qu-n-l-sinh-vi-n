package login;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mainView.MainView;

public class LoginPage implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Refresh");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("Tài khoản:");
	JLabel userPasswordLabel = new JLabel("Mật khẩu:");
	JLabel messageLabel = new JLabel();
	JLabel messageLabel1 = new JLabel();
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	public LoginPage(HashMap<String,String> loginInfoOriginal){
		
		logininfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(90,237,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		messageLabel1.setBounds(249,237,250,35);
		messageLabel1.setFont(new Font(null,Font.ITALIC,25));
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225,200,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.getContentPane().add(userIDLabel);
		frame.getContentPane().add(userPasswordLabel);
		frame.getContentPane().add(messageLabel);
		frame.getContentPane().add(messageLabel1);
		frame.getContentPane().add(userIDField);
		frame.getContentPane().add(userPasswordField);
		frame.getContentPane().add(loginButton);
		frame.getContentPane().add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		if(e.getSource()==loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Đăng nhập thành công");
					frame.dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MainView frame = new MainView();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Sai mật khẩu. ");
					
				}

			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Sai tài khoản");
			}
		}
		
	}	
}