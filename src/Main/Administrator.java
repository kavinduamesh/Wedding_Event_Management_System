/*
 * This is Administrator class who responsible for managing User Accouts
 */

package Main;

//import Custom packages and libraries
import login.*;
import Tools.*;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import com.mysql.jdbc.MysqlDataTruncation;
import CustomExceptions.PasswordIncorrect;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.proteanit.sql.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


//Administrator class implement DataBaseConnect and extend jframe 
public class Administrator extends JFrame implements DataBaseConnect1{

	private JPanel Jpane;
	private JTextField txtname;
	private JTextField searchName;
	public String AdminStatus = "User";
	private String JobPosition;
	
	
	//Main method
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator frame = new Administrator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//end
	
	
	//Precompliled SQL statement objects
	PreparedStatement prpstmt;
	ResultSet rslt;
	Connection cnnct;
	Statement statmnt;
	//end
	
	//Jframe properties
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtcnfmPassword;
	private JTextField txtTelNo;
	private JTable table;
	private JTextField showJobDes;
	//end
	
	
	//Class default constructor
	public Administrator() {
		
		//Title label
		setTitle("Administrator Account");
		setBackground(new Color(255, 239, 213));
		
		ConnectDB();//Call database connection
		
		
		//jframe properties
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 553);
		Jpane = new JPanel();
		Jpane.setBackground(new Color(255, 255, 255));
		Jpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//end

		setContentPane(Jpane);
		Jpane.setLayout(null);
		
		JButton btnExit = new JButton("Back");
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();//dispose administrator frame and n
				SelectionMenu Usr2Slct = new SelectionMenu();
				Usr2Slct.show();//navigate to selection menu
			}
		});
		btnExit.setBounds(20, 485, 109, 21);
		Jpane.add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Add Account", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 114, 353, 357);
		Jpane.add(panel);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(26, 25, 63, 37);
		panel.add(lblNewLabel);
		
		txtname = new JTextField();
		txtname.setBounds(99, 25, 240, 28);
		panel.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(26, 176, 85, 28);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(26, 223, 85, 13);
		panel.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(99, 177, 240, 28);
		panel.add(txtUsername);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(99, 101, 240, 28);
		panel.add(txtEmail);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(99, 216, 240, 28);
		panel.add(txtPassword);
		
		JLabel cnfmLbl = new JLabel("Confirm");
		cnfmLbl.setBounds(26, 267, 45, 13);
		panel.add(cnfmLbl);
		
		JLabel cnfmPasswordLbl = new JLabel("Password");
		cnfmPasswordLbl.setBounds(26, 279, 63, 13);
		panel.add(cnfmPasswordLbl);
		
		txtcnfmPassword = new JPasswordField();
		txtcnfmPassword.setBounds(99, 260, 240, 28);
		panel.add(txtcnfmPassword);
		
		final JCheckBox chckAdmintick = new JCheckBox("Give Admin privilleges");
		chckAdmintick.setOpaque(false);
		chckAdmintick.setBackground(new Color(255, 255, 255));
		chckAdmintick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(chckAdmintick.isSelected()) {
					
					AdminStatus = "Admin";//assign user status
				}
				
				
			}
		});
		chckAdmintick.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		chckAdmintick.setBounds(151, 304, 196, 37);
		panel.add(chckAdmintick);
		
		txtTelNo = new JTextField();
		txtTelNo.setColumns(10);
		txtTelNo.setBounds(99, 139, 240, 28);
		panel.add(txtTelNo);
		
		final JComboBox jobDes = new JComboBox();
		jobDes.setEditable(true);
		jobDes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//jcomboBox properties
				int titleindex = jobDes.getSelectedIndex();
								
				switch(titleindex) {
				
				case 1 : JobPosition = "Administrator";break;
				case 2 : JobPosition = "Photographer";break;
				case 3 : JobPosition = "Staff";break;
				case 4 : JobPosition = "Editor";break;
				}
				//end
				
				
			}
		});
		jobDes.setBackground(new Color(255, 255, 255));
		jobDes.setBounds(99, 63, 121, 28);
		panel.add(jobDes);
		jobDes.setModel(new DefaultComboBoxModel(new String[] {"", "Administrator", "Photographer", "Staff", "Editor"}));
		
		JLabel JobDes = new JLabel("Job Des");
		JobDes.setBounds(26, 72, 63, 13);
		panel.add(JobDes);
		
		JLabel Email = new JLabel("Email");
		Email.setBounds(26, 108, 45, 13);
		panel.add(Email);
		
		JLabel lblTelNo = new JLabel("Tel No");
		lblTelNo.setBounds(26, 146, 45, 13);
		panel.add(lblTelNo);
		
		showJobDes = new JTextField();
		showJobDes.setBounds(225, 63, 114, 28);
		panel.add(showJobDes);
		showJobDes.setColumns(10);
				
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(428, 16, 411, 91);
		panel_1.setOpaque(false);
		Jpane.add(panel_1);
		panel_1.setLayout(null);
		
		searchName = new JTextField();
		searchName.setToolTipText("test");
		searchName.setFont(new Font("Tahoma", Font.PLAIN, 10));
		searchName.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				
				table_load();
				SearchRecords();//Call search record method
			}
		});
		
		searchName.setBounds(20, 20, 353, 32);
		searchName.setColumns(10);
		panel_1.add(searchName);
		
		JLabel searchLbl = new JLabel("*Enter Your Account ID or Registerd name or Username here");
		searchLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		searchLbl.setBounds(20, 62, 353, 13);
		panel_1.add(searchLbl);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UpdateRecords();//Call Update record method
				AlterDataBase();//call Alter table methos
				jobDes.setSelectedIndex(0); // set jcomboBox to NULL
			}
		});
		btnUpdate.setBackground(new Color(144, 238, 144));
		btnUpdate.setBounds(611, 450, 109, 56);
		Jpane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(240, 128, 128));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DeleteRecord(); // Call Delete method
				AlterDataBase();//Call alter table method
				jobDes.setSelectedIndex(0);// set jcomboBox to NULL
			}
		});
		btnDelete.setBounds(730, 450, 109, 56);
		Jpane.add(btnDelete);
				
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(144, 238, 144));
		btnSave.setBounds(373, 450, 109, 56);
		Jpane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				table_load();
				CreateRecord();	
				jobDes.setSelectedIndex(0);
			}
		});
			
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ClearRecord();
				jobDes.setSelectedIndex(0);
			}
		});
		btnClear.setBackground(new Color(144, 238, 144));
		btnClear.setBounds(492, 450, 109, 56);
		Jpane.add(btnClear);
		
		JLabel AdminAcclbl = new JLabel("Administrator Account ");
		AdminAcclbl.setFont(new Font("Tahoma", Font.PLAIN, 32));
		AdminAcclbl.setBounds(85, 16, 333, 67);
		Jpane.add(AdminAcclbl);
		
		JLabel AdminIcon = new JLabel("");
		Image admnicn = new ImageIcon(this.getClass().getResource("/Profile.png")).getImage();
		AdminIcon.setIcon(new ImageIcon(admnicn));
		AdminIcon.setBounds(10, 16, 65, 78);
		Jpane.add(AdminIcon);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBounds(373, 125, 459, 117);
		Jpane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		Image fb = new ImageIcon(this.getClass().getResource("/plain.jpg")).getImage();
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(null, "Navigation Panel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(373, 276, 459, 124);
		Jpane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Customer");
		btnNewButton.setBackground(new Color(144, 238, 144));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 20, 125, 87);
		panel_2.add(btnNewButton);
		
		JButton btnPayment = new JButton("Payment");
		btnPayment.setBackground(new Color(255, 255, 255));
		btnPayment.setBounds(167, 20, 125, 87);
		panel_2.add(btnPayment);
		
		JButton btnEvent = new JButton("Event");
		btnEvent.setBackground(new Color(255, 182, 193));
		btnEvent.setBounds(324, 20, 125, 87);
		panel_2.add(btnEvent);
		
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(fb));
		background.setBounds(0, 0, 839, 516);
		Jpane.add(background);
				
		table_load();
		AlterDataBase();
		
	}
	
	/*
	 * This method retrieve data from the database and load into a table in jframe
	 */
	
	public void table_load(){
     try
     {
    	 
			prpstmt = cnnct.prepareStatement("select ID,Name,Username from administrator");
			rslt = prpstmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rslt));
     }
     catch (Exception e){System.out.print(e);}
    }
	//end
	
	
	/*
	 * This method implement search fuction
	 */
	public void SearchRecords() {
		
		try {
	          
            String Username1 = searchName.getText();
            String Name1 = searchName.getText();
            String id = searchName.getText();
            
 
                prpstmt = cnnct.prepareStatement("select Name,Job_Description,Email,Tel_No,Username,Password,Confirm_Password,Admin_Status from administrator where Username = ? or Name = ? or ID = ?");
                prpstmt.setString(1, Username1);
                prpstmt.setString(2, Name1);
                prpstmt.setString(3, id);
                ResultSet rslt = prpstmt.executeQuery();
 
            if(rslt.next())
            {
              
                String name = rslt.getString(1);
                String jobDes = rslt.getString(2);
                String email = rslt.getString(3);
                String telno = rslt.getString(4);
                String username = rslt.getString(5);
                String Password = rslt.getString(6);
                String cnfmPassword = rslt.getString(7);
                
                
                //set text fields
                txtname.setText(name);
                showJobDes.setText(jobDes);
                txtUsername.setText(username);
                txtPassword.setText(Password); 
        		txtEmail.setText(email);
        		txtTelNo.setText(telno);
        		txtcnfmPassword.setText(cnfmPassword);
            }  
            else
            {
            	//set text fields to empty	
            	txtname.setText("");
            	showJobDes.setText("");
                txtUsername.setText("");
                txtPassword.setText(""); 
        		txtEmail.setText("");
        		txtTelNo.setText("");
        		txtcnfmPassword.setText(""); 
        		//searchName.setText("");
        		
            }
        }catch (Exception e) {System.out.print(e);}

	}
	
	
	/*
	 * This method implement create record method
	 */
	public void CreateRecord() {
		
		String name,JobDes,email,telno,Username,Password,CnfmPassword;
		
		name = txtname.getText();
		email = txtEmail.getText();
		telno = txtTelNo.getText();
		Username = txtUsername.getText();
		Password = txtPassword.getText();
		CnfmPassword = txtcnfmPassword.getText();
		
		
		try {
			
			int tel = Integer.parseInt(telno);
			
			if(CnfmPassword.equals(Password)) {
				
				prpstmt = cnnct.prepareStatement("insert into administrator(Name,Job_Description,Email,Tel_No,Username,Password,Confirm_Password,Admin_Status)values(?,?,?,?,?,?,?,?)");
				prpstmt.setString(1, name);
				prpstmt.setString(2, this.JobPosition);
				prpstmt.setString(3, email);
				prpstmt.setString(4, telno);
				prpstmt.setString(5, Username);
				prpstmt.setString(6, Password);
				prpstmt.setString(7, CnfmPassword);
				prpstmt.setString(8, this.AdminStatus );
				prpstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Record Successfully Added!");
				AlterDataBase();
				table_load();
			}
			
			else {
				
				//check password
				
				try {
					
					if(Username.length() <= 4) {
						
						throw new PasswordIncorrect("Incorrect password!");//throw custom exception
						
					}
					
					
				}catch(PasswordIncorrect e) {JOptionPane.showMessageDialog(null, e.getMessage());}
				
			}
			          
			txtname.setText("");
			txtTelNo.setText("");
			txtEmail.setText("");
			txtUsername.setText("");
			txtPassword.setText("");
			txtcnfmPassword.setText("");
			txtname.requestFocus();
			
			   }
			 
			catch (MysqlDataTruncation e){System.out.print(e);JOptionPane.showMessageDialog(null, "Invalid Telephone Number!");}
		
			catch(NumberFormatException e) {JOptionPane.showMessageDialog(null, "Invalid Telephone Number!");
		
			txtTelNo.setText("");}
			
			catch(Exception e) {System.out.println(e);}
	}
	
	public void DeleteRecord() {

		
		String name,username;
		
		name = txtname.getText();
		username = txtUsername.getText();
		
		try {
		
			prpstmt = cnnct.prepareStatement("delete from administrator where Name = ? or Username = ?");
			prpstmt.setString(1 , name);
			prpstmt.setString(2, username);
			prpstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Record Successfully Deleted!");
			AlterDataBase();
			table_load();
			
			txtname.setText("");
			showJobDes.setText("");
			txtTelNo.setText("");
			txtEmail.setText("");
			txtUsername.setText("");
			txtPassword.setText("");
			txtcnfmPassword.setText("");
			searchName.setText("");
			txtname.requestFocus();
			
		}catch(Exception e) {System.out.println(e);}
	}
	
	public void ConnectDB() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			cnnct=DriverManager.getConnection("jdbc:mysql://localhost:3306/oopproject","root","");//Connect SQl DB to java program
			statmnt = cnnct.createStatement();
			
		}catch (Exception e){JOptionPane.showMessageDialog(null, "Connection Error . Try Again");
		
		dispose();
		SelectionMenu admin2slc = new SelectionMenu();
		admin2slc.show();
		
		}
	}
	
	public void UpdateRecords() {
		
		String name,email,telno,username,password,cnfmPassword,id;
		
		name = txtname.getText();
		email = txtEmail.getText();
		telno = txtTelNo.getText();
		username = txtUsername.getText();
		password = txtPassword.getText();
		cnfmPassword = txtcnfmPassword.getText();
		id = searchName.getText();
		
		try {
			
			int tel = Integer.parseInt(telno);
			
			if(cnfmPassword.equals(password)) {
			
			prpstmt = cnnct.prepareStatement("update administrator set Name = ?,Job_Description = ?,Email = ?,Tel_No = ?,Username = ?,Password = ?,Confirm_Password = ?,Admin_Status = ? where ID = ?");
			prpstmt.setString(1, name);
			prpstmt.setString(2, this.JobPosition);
			prpstmt.setString(3, email);
			prpstmt.setString(4, telno);
			prpstmt.setString(5, username);
			prpstmt.setString(6, password);
			prpstmt.setString(7, cnfmPassword);
			prpstmt.setString(8, this.AdminStatus );
			prpstmt.setString(9, id);
			prpstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Record Successfully Updated!");
			AlterDataBase();
			table_load();
			
			txtname.setText("");
			showJobDes.setText("");
			txtTelNo.setText("");
			txtEmail.setText("");
			txtUsername.setText("");
			txtPassword.setText("");
			txtcnfmPassword.setText("");
			searchName.setText("");
			txtname.requestFocus();
			
			}
			
			else {
				
				try {
					
					if(username.length() <= 4) {
						
						throw new PasswordIncorrect("Incorrect password!");
						
					}
					
					
				}catch(PasswordIncorrect e) {JOptionPane.showMessageDialog(null, e.getMessage());}
				
				txtPassword.setText("");
				txtcnfmPassword.setText("");
			}
			
			
		}catch (MysqlDataTruncation e){System.out.print(e);JOptionPane.showMessageDialog(null, "Invalid Telephone Number");}
		
		 catch(NumberFormatException e) {JOptionPane.showMessageDialog(null, "Tel no cannot contain letters/symbols!");
		
		 txtTelNo.setText("");}
		
		 catch(Exception e) {System.out.println(e);}
	}

	public void ClearRecord() {
		
		txtname.setText("");
		showJobDes.setText("");
		txtTelNo.setText("");
		txtEmail.setText("");
		txtUsername.setText("");
		txtPassword.setText("");
		txtcnfmPassword.setText("");
		searchName.setText("");
		txtname.requestFocus();
	}
	
	public void AlterDataBase() {
		
		try {
			
			prpstmt = cnnct.prepareStatement("ALTER TABLE administrator AUTO_INCREMENT = 1");
			prpstmt.executeUpdate();
			table_load();
			
		}catch(Exception e) {System.out.println(e);}
	}
}

