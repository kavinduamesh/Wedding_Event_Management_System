import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;

public class Event extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JTextField txtCustomer_name1;
	private JTextField txtCustomer_name;
	private JTextField txtDate;
	private JTextField txtTime;
	private JTextField txtBudget;
	private JTextField txtServices;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Event frame = new Event();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	
	
	public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/oopproject", "root","");
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

	
	public Event() {
		
		Connect();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Let Us Plan Your Big Day..");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(354, 0, 320, 40);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Services", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(36, 206, 289, 268);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("(Best hotels, Indoor/Outdoor Locations)");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(10, 41, 218, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("(Weding cards, Cake boxes, Thank you cards etc.)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(10, 115, 222, 17);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("(Bridal/Grooms' Wear, Accessories, Shoes, Jewellery etc.)");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(10, 153, 344, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("(Fresh flowers, Candles etc.)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(10, 72, 171, 21);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("1. Venues");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 25, 109, 21);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("2. Decorations");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(10, 56, 109, 21);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("3. Stationaries");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_2.setBounds(10, 95, 109, 21);
		panel.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("4. Wear & Beauticians");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_3.setBounds(10, 133, 155, 21);
		panel.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("5. Wedding Cakes");
		lblNewLabel_5_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_4.setBounds(10, 170, 109, 21);
		panel.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_5 = new JLabel("6. Wedding Photography");
		lblNewLabel_5_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_5.setBounds(10, 190, 155, 21);
		panel.add(lblNewLabel_5_5);
		
		JLabel lblNewLabel_5_6 = new JLabel("7. Wedding Transport");
		lblNewLabel_5_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_6.setBounds(10, 213, 133, 21);
		panel.add(lblNewLabel_5_6);
		
		JLabel lblNewLabel_5_7 = new JLabel("8. Entertaintment");
		lblNewLabel_5_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_7.setBounds(10, 236, 109, 21);
		panel.add(lblNewLabel_5_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(36, 472, 388, 54);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel customerName1 = new JLabel("Customer Name");
		customerName1.setBounds(10, 21, 123, 13);
		customerName1.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(customerName1);
		
		txtCustomer_name1 = new JTextField();
		txtCustomer_name1.setColumns(10);
		txtCustomer_name1.setBounds(183, 19, 143, 19);
		panel_1.add(txtCustomer_name1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(36, 44, 359, 162);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel customerName = new JLabel("Customer Name");
		customerName.setBounds(10, 27, 118, 16);
		panel_2.add(customerName);
		customerName.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel date = new JLabel("Date(Planned)");
		date.setBounds(10, 53, 152, 13);
		panel_2.add(date);
		date.setBackground(new Color(240, 240, 240));
		date.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel time = new JLabel("Time");
		time.setBounds(10, 76, 106, 13);
		panel_2.add(time);
		time.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtCustomer_name = new JTextField();
		txtCustomer_name.setColumns(10);
		txtCustomer_name.setBounds(180, 27, 143, 19);
		panel_2.add(txtCustomer_name);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(180, 51, 143, 19);
		panel_2.add(txtDate);
		
		txtTime = new JTextField();
		txtTime.setColumns(10);
		txtTime.setBounds(180, 74, 143, 19);
		panel_2.add(txtTime);
		
		JLabel budget = new JLabel("Budget");
		budget.setFont(new Font("Tahoma", Font.BOLD, 13));
		budget.setBounds(10, 100, 106, 13);
		panel_2.add(budget);
		
		txtBudget = new JTextField();
		txtBudget.setColumns(10);
		txtBudget.setBounds(180, 98, 143, 19);
		panel_2.add(txtBudget);
		
		JLabel services = new JLabel("Services");
		services.setFont(new Font("Tahoma", Font.BOLD, 13));
		services.setBounds(10, 124, 106, 13);
		panel_2.add(services);
		
		txtServices = new JTextField();
		txtServices.setColumns(10);
		txtServices.setBounds(180, 122, 143, 19);
		panel_2.add(txtServices);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Cname,date,time,budget,services;
				Cname = txtCustomer_name.getText();
				date = txtDate.getText();
				time = txtTime.getText();
				budget  = txtBudget.getText();
				services  = txtServices.getText();
				try {
				pst = con.prepareStatement("update event set customer_name= ?, date=?, time=?, budget=?, services=? where customer_name =?");
				            pst.setString(1, Cname);
				            pst.setString(2, date);
				            pst.setString(3, time);
				            pst.setString(4, budget);
				            pst.setString(4, services);
				            pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Record Update!");
				            table_load();
				          
				            txtCustomer_name.setText("");
				            txtDate.setText("");
				            txtTime.setText("");
				            txtBudget.setText("");
				            txtServices.setText("");
				            txtCustomer_name.requestFocus();
				}
				 
				            catch (SQLException e1) {
				e1.printStackTrace();
				}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(625, 486, 103, 40);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Cname;
				Cname  = txtCustomer_name1.getText();
				try {
				pst = con.prepareStatement("delete from book where id =?");
				            pst.setString(1, Cname);
				            pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
				            table_load();
				          
				            txtCustomer_name.setText("");
				            txtDate.setText("");
				            txtTime.setText("");
				            txtBudget.setText("");
				            txtServices.setText("");
				            txtCustomer_name.requestFocus();
				}
				 
				            catch (SQLException e1) {
				e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(738, 486, 103, 40);
		contentPane.add(btnDelete);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Cname,date,time,budget,services;
				Cname = txtCustomer_name.getText();
				date = txtDate.getText();
				time = txtTime.getText();
				budget = txtBudget.getText();
				services = txtServices.getText();
							
				 try {
					pst = con.prepareStatement("insert into event(event_id, customer_name, date, time, budget, services)values(?,?,?,?,?,?)");
					pst.setString(1, Cname);
					pst.setString(2, date);
					pst.setString(3, time);
					pst.setString(4, budget);
					pst.setString(5, services);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!");
					table_load();
						           
					txtCustomer_name.setText("");
					txtDate.setText("");
					txtTime.setText("");
					txtBudget.setText("");
					txtServices.setText("");
					txtCustomer_name.requestFocus();
				   }

				catch (SQLException e1) 
			        {
									
				e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(342, 229, 103, 40);
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				          
				            txtCustomer_name.setText("");
				            txtDate.setText("");
				            txtTime.setText("");
				            txtBudget.setText("");
				            txtServices.setText("");
				            txtCustomer_name.requestFocus();
				
			}
		});
		btnClear.setBounds(342, 305, 103, 40);
		contentPane.add(btnClear);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnExit.setBounds(342, 375, 103, 40);
		contentPane.add(btnExit);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(498, 50, 347, 379);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table_load();
	}
	
	  public void table_load() {
		  
	     try
	     {
	    	 
	    	 pst = con.prepareStatement("select customer_name, event_id from event");
	    	 rs = pst.executeQuery();
	    	 table.setModel(DbUtils.resultSetToTableModel(rs));
	     }
	     
	     catch (SQLException e)
	     {
	     e.printStackTrace();
	     }
	     
	    }
}
