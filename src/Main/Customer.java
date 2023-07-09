package Main;

import java.awt.BorderLayout;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import login.SelectionMenu;
import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Customer extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtnic;
	private JTextField txtaddress;
	private JTable table;
	private JTextField txtcid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	Connection cont;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txttelno;
	private JTextField txtemail;


	/**
	 * Create the frame.
	 */
	public Customer() {
		setTitle("Customer Window");
		Connect();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1045, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Account");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 48));
		lblNewLabel.setBounds(10, 21, 453, 69);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Add Customer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 100, 491, 322);
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 41, 78, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NIC");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 87, 78, 36);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Address");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 148, 78, 36);
		panel.add(lblNewLabel_1_1_1);
		
		txtname = new JTextField();
		txtname.setBounds(124, 41, 333, 36);
		panel.add(txtname);
		txtname.setColumns(10);
		
		txtnic = new JTextField();
		txtnic.setColumns(10);
		txtnic.setBounds(124, 90, 333, 36);
		panel.add(txtnic);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(124, 148, 333, 36);
		panel.add(txtaddress);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("TelNo");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(10, 209, 78, 36);
		panel.add(lblNewLabel_1_1_2);
		
		txttelno = new JTextField();
		txttelno.setColumns(10);
		txttelno.setBounds(124, 209, 333, 36);
		panel.add(txttelno);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Email");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1.setBounds(10, 269, 78, 36);
		panel.add(lblNewLabel_1_1_2_1);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(124, 272, 333, 36);
		panel.add(txtemail);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBackground(new Color(144, 238, 144));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Name, NIC, Address, Email,TelNo;
				int Telno;
			
				Name = txtname.getText();
				NIC= txtnic.getText();
				Address = txtaddress.getText();
				TelNo = txttelno.getText();
				
				Telno = Integer.parseInt(TelNo);
				
				Email = txtemail.getText();
				
				try {
				pst = cont.prepareStatement("insert into  customer(Name,NIC,Address,Tel_NO,Email)values(?,?,?,?,?)");
				pst.setString(1, Name);
				pst.setString(2, NIC);
				pst.setString(3, Address);
				pst.setInt(4, Telno);
				pst.setString(5, Email);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Record Added");
				table_load();
				          
				txtname.setText("");
				txtnic.setText("");
				txtaddress.setText("");
				txttelno.setText("");
				txtemail.setText("");
				txtcid.setText("");
				
				txtname.requestFocus();
				   }
				 
				catch (SQLException e1)
				        {
				e1.printStackTrace();
				}
				
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(511, 417, 125, 69);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(255, 192, 203));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				SelectionMenu slc = new SelectionMenu();
				slc.show();
				
			}
			
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(10, 461, 99, 25);
		contentPane.add(btnExit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtname.setText("");
            	txtnic.setText("");
                txtaddress.setText("");
                txttelno.setText("");
                txtemail.setText("");
                txtcid.setText("");
				
			}
		});
		btnClear.setBackground(new Color(144, 238, 144));
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear.setBounds(781, 417, 125, 69);
		contentPane.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(511, 154, 514, 223);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table_load();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(525, 39, 500, 90);
		panel_1.setOpaque(false);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Customer ID");
		lblNewLabel_1_2.setBounds(10, 26, 100, 31);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_2);
		
		txtcid = new JTextField();
		txtcid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
					
					 try {
				          
				            String id = txtcid.getText();

				                pst = cont.prepareStatement("select Name,NIC,Address,Tel_NO,Email from customer where CUS_ID = ?");
				                pst.setString(1, id);
				                ResultSet rs = pst.executeQuery();

				            if(rs.next()==true)
				            {
				              
				                String name = rs.getString(1);
				                String nic = rs.getString(2);
				                String address = rs.getString(3);
				                int telno = rs.getInt(4);
				                String email = rs.getString(5);
				                
				                String TNO = String.valueOf(telno);
				                
				                txtname.setText(name);
				                txtnic.setText(nic);
				                txtaddress.setText(address);
				                txttelno.setText(TNO);
				                txtemail.setText(email);
				                
				                
				            }   
				            else
				            {
				            	txtname.setText("");
				            	txtnic.setText("");
				                txtaddress.setText("");
				                txttelno.setText("");
				                txtemail.setText("");
				                 
				            }
				            


				        } 
					
					 catch (SQLException ex) {
				           
				        }
										
					
				}
			}
		);
		txtcid.setBounds(120, 22, 370, 43);
		txtcid.setColumns(10);
		panel_1.add(txtcid);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(144, 238, 144));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					
					String name,nic,address,telno,email,cuid;
					
					
					name = txtname.getText();
					nic = txtnic.getText();
					address = txtaddress.getText();
					telno  = txttelno.getText();
					email  = txtemail.getText();
					cuid  = txtcid.getText();
					
					 try {
							pst = cont.prepareStatement("update customer set Name= ?,NIC=?,Address=?,Tel_NO=?,Email=? where Cus_ID =?");
							pst.setString(1, name);
				            pst.setString(2, nic);
				            pst.setString(3, address);
				            pst.setString(4, telno);
				            pst.setString(5, email);
				            pst.setString(6, cuid);
				            
				            pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Record Update");
				            table_load();
				           
				            txtname.setText("");
				            txtnic.setText("");
				            txtaddress.setText("");
				            txttelno.setText("");
				            txtemail.setText("");
				            txtcid.requestFocus();
						}

			            catch (SQLException e1) {
							
							e1.printStackTrace();
						}
		
				}
			}
		);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBounds(646, 417, 125, 69);
		contentPane.add(btnUpdate);
		
		JButton btnClear_1_1 = new JButton("Delete");
		btnClear_1_1.setBackground(new Color(255, 192, 203));
		btnClear_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String Cid;
                Cid  = txtcid.getText();
	
	 try {
			pst = cont.prepareStatement("delete from customer where Cus_ID =?");
	
            pst.setString(1, Cid);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
            table_load();
           
            txtname.setText("");
            txtnic.setText("");
            txtaddress.setText("");
            txttelno.setText("");
            txtemail.setText("");
            txtcid.setText("");
            txtname.requestFocus();
		}

        catch (SQLException e1) {
			
			e1.printStackTrace();
		}
			}
		});
		btnClear_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClear_1_1.setBounds(916, 417, 109, 69);
		contentPane.add(btnClear_1_1);
		
		JLabel bckgrnd = new JLabel("");
		Image backgrnd = new ImageIcon(this.getClass().getResource("/plain.jpg")).getImage();
		bckgrnd.setIcon(new ImageIcon(backgrnd));
		bckgrnd.setBounds(0, 0, 1031, 512);
		contentPane.add(bckgrnd);
		
		
	}

	 public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            cont = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopproject", "root","");
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
		    pst = cont.prepareStatement("select Cus_ID,Name from customer ");
		    rs = pst.executeQuery();
		    table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
	    	catch (SQLException e) 
	    	 {
	    		e.printStackTrace();
		  } 
	    }
	  
	  
}