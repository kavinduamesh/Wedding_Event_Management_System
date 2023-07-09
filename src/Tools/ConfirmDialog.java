/*
 * This JDialog implement a front end validation when user wants to log out 
 */

package Tools;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.LoginPage;
import login.SelectionMenu;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class ConfirmDialog extends JDialog {
	

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfirmDialog dialog = new ConfirmDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfirmDialog() {
		setTitle("Warning");
		setBounds(100, 100, 287, 167);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel iconLabel = new JLabel("");
		Image icon = new ImageIcon(this.getClass().getResource("/warning.png")).getImage();
		iconLabel.setIcon(new ImageIcon(icon));
		iconLabel.setBounds(10, 28, 60, 48);
		contentPanel.add(iconLabel);
		
		JLabel lblNewLabel = new JLabel("Do You Want to Log Out ?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(47, 40, 216, 25);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(new Color(154, 205, 50));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						dispose();//dispose
						
						LoginPage panel2lgn = new LoginPage();//create loginpage object
						panel2lgn.show();//call object frame
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(250, 128, 114));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						dispose(); // dispose current frame
						SelectionMenu slc = new SelectionMenu();//Create Selction menu object
						slc.show();//call object frame
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
