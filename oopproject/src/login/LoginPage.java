/*
 * This Class created for login page. This class validated the given credentials and give access for rest of the program.
 */

package login;

import Main.*;
import Tools.*;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class LoginPage extends JFrame implements DataBaseConnect{
	
	private JTextField UsernameInput;
	private JPasswordField PasswordInput;
	private String Username;
	private String Password;
	public String UserStatus = "AllUser";

	//Main method
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    //end
	
	PreparedStatement prpstmt;
	ResultSet rslt;
	Connection cnnct;
	Statement statmnt;
	
	public LoginPage() {
		
		ConnectDB();
		
		
		setBackground(new Color(255, 255, 255));
	
		getContentPane().setBackground(UIManager.getColor("InternalFrame.borderColor"));
		getContentPane().setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		setTitle("Wiwaha Wedding Event Planner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 410);
		getContentPane().setLayout(null);
		
		//Username label
		JLabel UsernameText = new JLabel(" Username : ");
		UsernameText.setFont(new Font("Tahoma", Font.BOLD, 13));
		UsernameText.setForeground(SystemColor.activeCaptionText);
		UsernameText.setBackground(new Color(0, 0, 0));
		UsernameText.setBounds(10, 115, 108, 29);
		getContentPane().add(UsernameText);
		//end
		
		
		//Username Text field
		UsernameInput = new JTextField();
		UsernameInput.setBackground(UIManager.getColor("CheckBox.light"));
		UsernameInput.setBounds(10, 143, 293, 35);
		getContentPane().add(UsernameInput);
		UsernameInput.setColumns(10);
		//end
		
		//Password Label
		JLabel PasswordText = new JLabel("Password : ");
		PasswordText.setForeground(Color.BLACK);
		PasswordText.setBackground(new Color(0, 0, 0));
		PasswordText.setFont(new Font("Tahoma", Font.BOLD, 13));
		PasswordText.setBounds(10, 188, 92, 13);
		getContentPane().add(PasswordText);
		//end
		
		
		//Password Text Field
		PasswordInput = new JPasswordField();
		PasswordInput.setBackground(UIManager.getColor("CheckBox.background"));
		PasswordInput.setBounds(10, 211, 293, 35);
		getContentPane().add(PasswordInput);
		//end
		
		
		//Heading "Login" lable
		JLabel LoginLabel = new JLabel("Login");
		LoginLabel.setFont(new Font("Arial", Font.BOLD, 28));
		LoginLabel.setForeground(new Color(0, 0, 0));
		LoginLabel.setBounds(120, 65, 183, 43);
		getContentPane().add(LoginLabel);
		//end
		
		
		//Login Button
		JButton LoginButton = new JButton("Login");
		LoginButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LoginButton.setForeground(new Color(255, 255, 255));
		LoginButton.setBackground(new Color(0, 0, 0));
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				checkPassword(); //Call the method "CheckPassword"
			}
		});
		LoginButton.setBounds(79, 256, 144, 34);
		getContentPane().add(LoginButton);
		//end
		
		
		//Exit Button
		JButton ExitButton = new JButton("Exit");
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ExitMethod();
			}
		});
		ExitButton.setBackground(new Color(240, 128, 128));
		ExitButton.setBounds(218, 334, 85, 29);
		getContentPane().add(ExitButton);
		
		JLabel lblNewLabel = new JLabel("Wedding Event Planner");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 22, 293, 49);
		getContentPane().add(lblNewLabel);
		Image backgrnd = new ImageIcon(this.getClass().getResource("/slcbck.jpg")).getImage();
		
		JLabel lblNewLabel_1 = new JLabel("Contact No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 334, 92, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("033-2250494/076-6367138");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(48, 350, 160, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel bckgrnd = new JLabel("");
		bckgrnd.setIcon(new ImageIcon(backgrnd));
		bckgrnd.setBounds(0, -1, 316, 374);
		getContentPane().add(bckgrnd);
		//end
		
		
		
	}
	
	// This method for validate Username and Password act act according to return values
	public void checkPassword() {
		
		try {
			
			//SelectionMenu usr = new SelectionMenu();
			//this.UserStatus = usr.UserStatus;
			
			Username = UsernameInput.getText();
			Password = PasswordInput.getText();
			
			
				prpstmt = cnnct.prepareStatement("Select Username , Password from administrator where Username = ? and Password = ?"); 
				prpstmt.setString(1, Username);
			    prpstmt.setString(2, Password);
				rslt = prpstmt.executeQuery();
								 
				UsernameInput.setText("");
			    PasswordInput.setText("");
					             
					 	if(rslt.next()) { // Checking return value is true
									
					     		dispose(); // Close login panel
								SelectionMenu lgn2slct = new SelectionMenu(); //Create Selection menu object
								lgn2slct.show(); // Enable Selection menu Panel	
							    }
							
					 	else {
								
					 		JOptionPane.showMessageDialog(null,"Invalid Username or Password!"); //If SQl Query failed to execute , this error massage popup
							   
					 	}
					             
					
								 
			
			//this.AccountName = Username;
			
			
			UsernameInput.setText(""); //Set Username Text box to empty
			PasswordInput.setText(""); //Set Password Text box to empty
			UsernameInput.requestFocus(); //Set cursor on Username panel
			
		}catch(Exception e) {System.out.print(e);} //Exception handling
	}
	//end
	
	
	//This method stop executing program(terminate the whole program immediately)
	public void ExitMethod() {
		
		System.exit(0); //terminate the program
	}
	
	public void ConnectDB() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			cnnct=DriverManager.getConnection("jdbc:mysql://localhost:3306/oopproject","root","");//Connect SQl DB to java program
			statmnt = cnnct.createStatement();
			
		}catch (Exception e){System.out.print(e);}
	}
}

