package mainView;

import model.Detai;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conn.ConnJDBC;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class UpdateView extends javax.swing.JFrame {
	Detai student;
	DateFormat format = new SimpleDateFormat("dd/MM/yyyy",Locale.US);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  int id;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public UpdateView(Detai student) {
		
		this.student = student;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1179, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(582, 10, 1, 1);
		contentPane.add(desktopPane);
		JLabel lblNewLabel_1 = new JLabel("Thêm mới đề tài");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(484, 10, 550, 56);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel = new JLabel("     Mã đề tài");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(108, 164, 124, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblAge = new JLabel(" Tên đề tài");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(582, 164, 78, 56);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("  Trạng thái ");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(582, 384, 124, 56);
		contentPane.add(lblGender);
		
		JLabel lblMajor = new JLabel("  Yêu cầu");
		lblMajor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMajor.setBounds(133, 273, 96, 56);
		contentPane.add(lblMajor);
		
		JLabel lblScore = new JLabel("Deadline");
		
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblScore.setBounds(593, 262, 78, 56);
		contentPane.add(lblScore);
		
		textField = new JTextField();
		textField.setBounds(211, 167, 316, 56);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setBounds(681, 167, 339, 56);
		contentPane.add(textField1);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(211, 276, 316, 56);
		contentPane.add(textField2);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(681, 276, 338, 56);
		contentPane.add(textField3);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Chưa nộp", "Đã nộp"}));
		comboBox.setBounds(681, 384, 106, 56);
		contentPane.add(comboBox);
		
		JButton btnRefresh = new JButton("Trở về");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
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
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(611, 519, 162, 47);
		contentPane.add(btnRefresh);
		
		JButton btnUpdate = new JButton("Thêm mới");
		if(MainView.isUpdate == true) {
			btnUpdate.setText("Cập nhật");
			textField.setEditable(false);
			lblNewLabel_1.setText("Cập nhật đề tài");
		}
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MainView.isUpdate == true) {
					JFrame t = new JFrame();
					int a = JOptionPane.showConfirmDialog(t, "Xác nhận tiến hành cập nhật trường dữ liệu này?", "Xác nhận cập nhật", JOptionPane.YES_NO_OPTION);
					System.out.print(a);
					if(a == 0) {
						String maSV,ten,email,phone;
						Date ngaysinh;
						int gioitinh;
		                float luong, thuong, phat , tong;
		                try{
		                	student.setMadetai(textField.getText());
		                	student.setTendetai(textField1.getText());
		                	student.setYeucau(textField2.getText());
		                	student.setDeadline(format.parse(textField3.getText()));
		                	student.setNhomdangki(textField4.getText());
		           
		            		student.setTrangthainop(comboBox.getSelectedItem().toString().equals("Đã nộp")?1:0);
		            		ConnJDBC.update(student);
		                    dispose();
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
		             
		                } catch (ParseException e1) {
							// TODO Auto-generated catch block
		                	JFrame f = new JFrame();
		                	JOptionPane.showMessageDialog(f,"Cập nhật thất bại, sai định dạng ở trường deadline."); 
						}
		               
					}
					}else {
						System.out.println("ds");
							String maSV,ten,email,phone;
							Date ngaysinh;
							int gioitinh;
			                float luong, thuong, phat , tong;
			                try{
			                	student.setMadetai(textField.getText());
			                	student.setTendetai(textField1.getText());
			                	student.setYeucau(textField2.getText());
			                	student.setDeadline(format.parse(textField3.getText()));
			                	student.setNhomdangki(textField4.getText());
			          
			            		student.setTrangthainop(comboBox.getSelectedItem().toString().equals("Đã nộp")?1:0);
			            		System.out.println("be ok");
			            		ConnJDBC.insert(student);
			            
			                    dispose();
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
			             
			                } catch (ParseException e1) {
								// TODO Auto-generated catch block
			                	JFrame f = new JFrame();
			                	JOptionPane.showMessageDialog(f,"Thêm mới thất bại, sai định dạng ở trường deadline."); 
							}
			            
						
					}
				
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(399, 519, 162, 47);
		contentPane.add(btnUpdate);
		
		JLabel lblPht = new JLabel("Tên nhóm");
		lblPht.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPht.setBounds(120, 384, 130, 56);
		contentPane.add(lblPht);
		
		textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(212, 384, 316, 56);
		contentPane.add(textField4);
	
		textField.setText(student.getMadetai());
		textField1.setText(student.getTendetai());
		textField2.setText(student.getYeucau());
		textField3.setText(format.format(student.getDeadline()));
		textField4.setText(student.getNhomdangki());
		
		JLabel lblDdmmyyyy = new JLabel("dd/MM/yyyy");
		lblDdmmyyyy.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDdmmyyyy.setBounds(586, 276, 100, 56);
		contentPane.add(lblDdmmyyyy);
		String trangthai = (student.getTrangthainop()==0)?"Chưa nộp":"Đã nộp";
        for(int i=0;i<comboBox.getItemCount();i++){
	        if(trangthai.equals(comboBox.getItemAt(i).toString())){
	        	comboBox.setSelectedIndex(i);
	        }
        }
	}
}
