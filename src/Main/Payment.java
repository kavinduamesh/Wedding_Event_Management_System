package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Tools.DataBaseConnect1;
import login.SelectionMenu;
import net.proteanit.sql.DbUtils;

public class Payment extends JFrame implements DataBaseConnect1{

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtFull;
	private JTextField txtAdv;
	private JTextField txtnumber;
	private JTextField txtDate;
	private JTextField txtFeedback;
	private JTextField txtSearch;
	private JTable table;
	private JPasswordField txtCVV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	/**
	 * Create the frame.
	 */
	public Payment() {
		setTitle("Payment Window");
		
		ConnectDB();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1116, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payment & Feedback");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 49));
		lblNewLabel.setBounds(20, 27, 491, 61);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 111, 452, 208);
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" Customer Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 24, 121, 39);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Advanced");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 134, 121, 26);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Full Payment");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(20, 80, 111, 26);
		panel.add(lblNewLabel_3);
		
		txtName = new JTextField();
		txtName.setBounds(144, 29, 298, 31);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtFull = new JTextField();
		txtFull.setBounds(141, 80, 301, 31);
		panel.add(txtFull);
		txtFull.setColumns(10);
		
		txtAdv = new JTextField();
		txtAdv.setBounds(144, 134, 298, 31);
		panel.add(txtAdv);
		txtAdv.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Payment", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 329, 452, 208);
		panel_1.setOpaque(false);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Card Number");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 43, 114, 28);
		panel_1.add(lblNewLabel_6);
		
		txtnumber = new JTextField();
		txtnumber.setBounds(134, 46, 282, 28);
		panel_1.add(txtnumber);
		txtnumber.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Valid through(MM/YY)");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 97, 183, 28);
		panel_1.add(lblNewLabel_7);
		
		txtDate = new JTextField();
		txtDate.setBounds(190, 100, 226, 28);
		panel_1.add(txtDate);
		txtDate.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("CVV(3 digit)");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(10, 152, 105, 28);
		panel_1.add(lblNewLabel_8);
		
		txtCVV = new JPasswordField();
		txtCVV.setBounds(134, 155, 105, 28);
		panel_1.add(txtCVV);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Feedback", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(482, 329, 610, 159);
		panel_2.setOpaque(false);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtFeedback = new JTextField();
		txtFeedback.setBounds(10, 25, 590, 126);
		panel_2.add(txtFeedback);
		txtFeedback.setColumns(10);
		
		JButton btnAdd = new JButton("Add Payment");
		btnAdd.setBackground(new Color(144, 238, 144));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Cusname,FullPay,AdvPay,card,date,cvv,feed;
				double advPay , fullpay=0;
				
				Cusname = txtName.getText();
				FullPay = txtFull.getText();
				
				try {
					
					fullpay = Double.parseDouble(FullPay);
					
				}catch(Exception e) {JOptionPane.showMessageDialog(null, "Full Payment must be Numeric!");}
				
				advPay = fullpay * 0.25;
				
				AdvPay = String.valueOf(advPay);
						
				//AdvPay = txtFull.getText();
				
				txtAdv.setText(AdvPay);
				
				card = txtnumber.getText();
				date = txtDate.getText();
				cvv = txtCVV.getText();
				feed = txtFeedback.getText();
				
							
				 try {
					pst = con.prepareStatement("insert into payment(Customer_Name, Full_Pay, Advanced_Pay, Card_No, Date, cvv, Feedback)values(?,?,?,?,?,?,?)");
					pst.setString(1, Cusname);
					pst.setString(2, FullPay);
					pst.setString(3, AdvPay);
					pst.setString(4, card);
					pst.setString(5, date);
					pst.setString(6, cvv);
					pst.setString(7, feed);
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Record Added!");
					table_load();
						           
					txtName.setText("");
					txtFull.setText("");
					txtAdv.setText("");
					txtnumber.setText("");
					txtDate.setText("");
					txtCVV.setText("");
					txtFeedback.setText("");
					txtName.requestFocus();
				   }

				catch (SQLException e1) 
			        {
									
				e1.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(482, 522, 138, 75);
		contentPane.add(btnAdd);
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(553, 36, 507, 91);
		panel_3.setOpaque(false);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				 try {
			          
			            String id = txtSearch.getText();

			                pst = con.prepareStatement("select Customer_Name, Full_Pay, Advanced_Pay, Card_No, Date, cvv, Feedback from payment where Pay_id = ?");
			                pst.setString(1, id);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String name = rs.getString(1);
			                String fullPay = rs.getString(2);
			                String advPay = rs.getString(3);
			                String card = rs.getString(4);
			                String date = rs.getString(5);
			                String cvv = rs.getString(6);
			                String feedback = rs.getString(7);
			                
			                table_load();
			                
							txtName.setText(name);
							txtFull.setText(fullPay);
							txtAdv.setText(advPay);
							txtnumber.setText(card);
							txtDate.setText(date);
							txtCVV.setText(cvv);
							txtFeedback.setText(feedback);
			                
			            }   
			            else
			            {
							txtName.setText("");
							txtFull.setText("");
							txtAdv.setText("");
							txtnumber.setText("");
							txtDate.setText("");
							txtCVV.setText("");
							txtFeedback.setText("");
							txtSearch.requestFocus();
						   
			                 
			            }
			        } 
				
				 catch (SQLException ex) {
			           
			        }
			}
		});
		txtSearch.setBounds(10, 31, 487, 35);
		panel_3.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(144, 238, 144));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String Cusname,FullPay,AdvPay,card,date,cvv,feed,id;
				double advPay , fullpay=0;
				
				Cusname = txtName.getText();
				FullPay = txtFull.getText();
				id  = txtSearch.getText();
				
				try {
					
					fullpay = Double.parseDouble(FullPay);
					
				}catch(Exception e) {JOptionPane.showMessageDialog(null, "Full Payment must be Numeric!");}
				
				advPay = fullpay * 0.25;
				
				AdvPay = String.valueOf(advPay);
										
				txtAdv.setText(AdvPay);
				
				card = txtnumber.getText();
				date = txtDate.getText();
				cvv = txtCVV.getText();
				feed = txtFeedback.getText();
				
							
				 try {
					pst = con.prepareStatement("UPDATE payment SET Customer_Name = ?, Full_Pay = ? , Advanced_Pay = ? , Card_No = ? , Date = ? , cvv = ? , Feedback = ? WHERE Pay_id = ?");
					pst.setString(1, Cusname);
					pst.setString(2, FullPay);
					pst.setString(3, AdvPay);
					pst.setString(4, card);
					pst.setString(5, date);
					pst.setString(6, cvv);
					pst.setString(7, feed);
					pst.setString(8, id);
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Record Updated!");
					table_load();
						           
					txtName.setText("");
					txtFull.setText("");
					txtAdv.setText("");
					txtnumber.setText("");
					txtDate.setText("");
					txtCVV.setText("");
					txtFeedback.setText("");
					txtSearch.setText("");
					txtSearch.requestFocus();
				   }

				catch (SQLException e1) 
			        {
									
				e1.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 14));
		btnUpdate.setBounds(637, 522, 138, 75);
		contentPane.add(btnUpdate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtName.setText("");
				txtFull.setText("");
				txtAdv.setText("");
				txtnumber.setText("");
				txtDate.setText("");
				txtCVV.setText("");
				txtFeedback.setText("");
				txtSearch.setText("");
				txtSearch.requestFocus();
			}
		});
		btnClear.setBackground(new Color(144, 238, 144));
		btnClear.setFont(new Font("Arial", Font.PLAIN, 14));
		btnClear.setBounds(792, 522, 138, 75);
		contentPane.add(btnClear);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(233, 150, 122));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	             String bid;
	 			bid  = txtSearch.getText();
	 			
	 			 try {
	 					pst = con.prepareStatement("delete from payment where Pay_id = ?");
	 			
	 		            pst.setString(1, bid);
	 		            pst.executeUpdate();
	 		            JOptionPane.showMessageDialog(null, "Record Delete!");
	 		            table_load();
	 		           
	 		            txtName.setText("");
						txtFull.setText("");
						txtAdv.setText("");
						txtnumber.setText("");
						txtDate.setText("");
						txtCVV.setText("");
						txtFeedback.setText("");
						txtSearch.setText("");
						txtSearch.requestFocus();
	 				}

	 	            catch (SQLException e1) {
	 					
	 					e1.printStackTrace();
	 				}
			}
		});
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 14));
		btnDelete.setBounds(947, 522, 138, 75);
		contentPane.add(btnDelete);
		
		JButton btnNewButton_4 = new JButton("Exit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				SelectionMenu pay2slc = new SelectionMenu();
				pay2slc.show();
				
				
			}
		});
		btnNewButton_4.setBackground(new Color(255, 192, 203));
		btnNewButton_4.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton_4.setBounds(10, 552, 130, 25);
		contentPane.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(482, 165, 610, 154);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel bckgrnd = new JLabel("");
		Image backgrnd = new ImageIcon(this.getClass().getResource("/plain.jpg")).getImage();
		bckgrnd.setIcon(new ImageIcon(backgrnd));
		bckgrnd.setBounds(0, 0, 1102, 602);
		contentPane.add(bckgrnd);
		
		table_load();
	}
	
	 public void ConnectDB()
	    {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopproject", "root","");
	        }
	        catch (ClassNotFoundException ex) 
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex) 
	        {
	        	   ex.printStackTrace();
	        }

	    }
	 
	  public void table_load()
	    {
	    	try 
	    	{
		    pst = con.prepareStatement("select Pay_id, Customer_Name from payment");
		    rs = pst.executeQuery();
		    table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
	    	catch (SQLException e) 
	    	 {
	    		e.printStackTrace();
		  } 
	    }
}