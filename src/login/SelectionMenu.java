package login;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import java.awt.image.*;
import javax.swing.border.TitledBorder;

import Main.Administrator;
import Main.Customer;
import Main.Event;
import Main.Payment;
import Tools.ConfirmDialog;

import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class SelectionMenu extends JFrame {
	
	public int UserStatus;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectionMenu frame = new SelectionMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SelectionMenu() {
		setTitle("Selection Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 535);
		getContentPane().setLayout(null);
		Image bckicn = new ImageIcon(this.getClass().getResource("/gold.jpeg")).getImage();
		
		JButton logout = new JButton("Log Out");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				ConfirmDialog slc2usr = new ConfirmDialog();
				slc2usr.show();
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("MENU");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel_2.setBounds(369, 115, 106, 25);
		getContentPane().add(lblNewLabel_2);
		logout.setBackground(new Color(240, 128, 128));
		logout.setBounds(10, 456, 85, 21);
		getContentPane().add(logout);
		
		JLabel lblNewLabel_1 = new JLabel("Wedding Event Planner");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(147, 112, 219));
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 40));
		lblNewLabel_1.setBounds(10, 31, 870, 87);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Follow Us");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(718, 417, 162, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel instalbl = new JLabel("");
		Image instlbl = new ImageIcon(this.getClass().getResource("/Instagram.png")).getImage();
		instalbl.setIcon(new ImageIcon(instlbl));
		instalbl.setBounds(772, 444, 48, 48);
		getContentPane().add(instalbl);
		
		JLabel utublbl = new JLabel("");
		Image utub = new ImageIcon(this.getClass().getResource("/YouTube.png")).getImage();
		utublbl.setIcon(new ImageIcon(utub));
		utublbl.setBounds(822, 444, 48, 48);
		getContentPane().add(utublbl);
		
		JLabel fblbl = new JLabel("");
		Image fb = new ImageIcon(this.getClass().getResource("/fb.png")).getImage();
		fblbl.setIcon(new ImageIcon(fb));
		fblbl.setBounds(718, 444, 48, 48);
		getContentPane().add(fblbl);
		
		JButton cstmbtn = new JButton("Customer");
		cstmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Customer slc2cst = new Customer();
				slc2cst.show();
			}
		});
		cstmbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		cstmbtn.setOpaque(false);
		cstmbtn.setBackground(new Color(154, 205, 50));
		cstmbtn.setBounds(207, 183, 189, 87);
		getContentPane().add(cstmbtn);
		
		JButton usrbtn = new JButton("Administrator");
		usrbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				dispose();
				
				Administrator slc2admin = new Administrator();
				slc2admin.show();
					
			}
		});
		usrbtn.setForeground(new Color(0, 0, 0));
		usrbtn.setOpaque(false);
		usrbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		usrbtn.setBackground(new Color(154, 205, 50));
		usrbtn.setBounds(462, 300, 189, 87);
		getContentPane().add(usrbtn);
		
		JButton evntbtn = new JButton("Event");
		evntbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Event slc2evnt = new Event();
				slc2evnt.show();
				
			}
		});
		evntbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		evntbtn.setOpaque(false);
		evntbtn.setBackground(new Color(154, 205, 50));
		evntbtn.setBounds(462, 183, 189, 87);
		getContentPane().add(evntbtn);
		
		JButton pymntbtn = new JButton("Payment");
		pymntbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Payment slc2pymt = new Payment();
				slc2pymt.show();
				}
		});
		pymntbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		pymntbtn.setOpaque(false);
		pymntbtn.setBackground(new Color(154, 205, 50));
		pymntbtn.setBounds(207, 300, 189, 87);
		getContentPane().add(pymntbtn);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setOpaque(false);
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(151, 148, 552, 267);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("jsjdy");
		lblNewLabel_3.setFont(new Font("4u-Malith", Font.BOLD | Font.ITALIC, 53));
		lblNewLabel_3.setBounds(355, 0, 144, 57);
		getContentPane().add(lblNewLabel_3);
		
		JLabel bckgrnd = new JLabel("");
		bckgrnd.setFont(new Font("Tahoma", Font.PLAIN, 34));
		bckgrnd.setForeground(UIManager.getColor("CheckBox.foreground"));
		
			bckgrnd.setIcon(new ImageIcon(bckicn));
			bckgrnd.setBounds(0, 0, 894, 508);
			getContentPane().add(bckgrnd);
	}
}
