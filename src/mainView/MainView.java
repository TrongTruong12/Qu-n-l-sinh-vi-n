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

public class MainView extends javax.swing.JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean isUpdate = false;
	private  Detai student = new Detai();
	private DateFormat format = new SimpleDateFormat("dd/MM/yyyy",Locale.US);
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MainView() {
		student.setDeadline(new Date());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1179, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(582, 10, 1, 1);
		contentPane.add(desktopPane);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            // TODO add your handling code here:
					isUpdate = false;
                    student = new Detai();
                    dispose();
			    	EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Date date = new Date();
								student.setDeadline(date);
								UpdateView frame = new UpdateView(student);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
//                            String ten;
//                            int tuoi ,gioitinh;
//                            float luong, thuong, phat , tong;
//                            try{
//                                ten = textField.getText();
//                                tuoi = Integer.parseInt(textField_1.getText());
//                                gioitinh = comboBox.getSelectedItem().toString().equals("Nữ")?1:0;
//                                luong = Float.parseFloat(textField_3.getText());
//                                thuong = Float.parseFloat(textField_4.getText());
//                                phat = Float.parseFloat(textField_2.getText());
//                                tong = Float.parseFloat(textField_5.getText());
//                                Student p = new Student(ten, tuoi, gioitinh, luong, thuong, phat, tong);
//                                ConnJDBC.insert(p);
//                            } catch(NumberFormatException e1){
//                            	JFrame f = new JFrame();
//                            	JOptionPane.showMessageDialog(f,"Phải nhập số");  
//                                return;
//                            }
			}
		});
	
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(372, 535, 162, 47);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame t = new JFrame();
				int a = JOptionPane.showConfirmDialog(t, "Xác nhận xóa trường dữ liệu này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
				if(a == 0) {
					
	                ConnJDBC.delete(student);
	                showData(ConnJDBC.findAll());
				}
                
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(372, 618, 162, 47);
		contentPane.add(btnDelete);
		
		JButton btnRefresh = new JButton("Làm Mới");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showData(ConnJDBC.findAll());
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(601, 618, 162, 47);
		contentPane.add(btnRefresh);
		
		JButton btnUpdate = new JButton("Cập Nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = table.getSelectedRow();
				if( r >= 0 && r <table.getRowCount()) {
					isUpdate = true;
					dispose();
			    	EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								UpdateView frame = new UpdateView(student);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}else{
					JOptionPane frame = new JOptionPane();
					frame.showMessageDialog(frame, "Chọn 1 dòng để sửa");
				}


				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(601, 535, 162, 47);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(181, 134, 793, 373);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				" Mã đề tài", "       Đề tài", "Yêu cầu", "  Deadline", "         Tên nhóm đăng kí", "    Trạng thái nộp"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setMinWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setMinWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(50);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 table.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	try {
						tableMouseClicked(evt);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });

		scrollPane.setViewportView(table);
		showData(ConnJDBC.findAll());
		
		JLabel lblNewLabel_1 = new JLabel("Quản lý bài tập lớn sinh viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(372, 10, 550, 56);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(451, 73, 309, 34);
		contentPane.add(textField);
		
		JButton btnFind = new JButton("Tìm tên đề tài");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showData(ConnJDBC.findByName(textField.getText().toString()));
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBounds(770, 64, 204, 47);
		contentPane.add(btnFind);
		
	}
	private void tableMouseClicked(java.awt.event.MouseEvent evt) throws ParseException {
		 // Do something.
		 	int row = table.getSelectedRow();
		 	student.setMadetai(table.getValueAt(row, 0).toString());
		 	student.setTendetai(table.getValueAt(row, 1).toString());
		 	student.setYeucau(table.getValueAt(row, 2).toString());
		 	student.setDeadline(format.parse(table.getValueAt(row, 3).toString()));
		 	student.setNhomdangki(table.getValueAt(row, 4).toString());
		 	int trangthai = table.getValueAt(row, 5).toString().equals("Chưa nộp")?0:1;
		 	student.setTrangthainop(trangthai);
		 	
		
		 	
	 
//	        for(int i=0;i<comboBox.getItemCount();i++){
//	            if(table.getValueAt(row, 3).toString().equals(comboBox.getItemAt(i).toString())){
//	            	comboBox.setSelectedIndex(i);
//	            }
//	        }
	
	       
	        
	    
		}
	public void showData(List<Detai>stds) {
		List<Detai>students= new ArrayList<>();
		students = stds;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel=(DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		students.forEach((st)->{
			String trangthai;
			if(st.getTrangthainop()==0) trangthai="Chưa nộp";
			else {trangthai="Đã nộp";}
			tableModel.addRow(new Object[] {
					st.getMadetai(),st.getTendetai(),st.getYeucau(),format.format(st.getDeadline()),
					st.getNhomdangki(), trangthai
			});
		});
	}
}
