package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import implementation.MaintainUser;
import implementation.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class PasswordChange extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordChange frame = new PasswordChange();
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
	public PasswordChange() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel oldPass = new JLabel("Old Password:");
		oldPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		oldPass.setBounds(65, 60, 100, 20);
		panel.add(oldPass);
		
		JLabel newPass = new JLabel("New Password:");
		newPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newPass.setBounds(65, 130, 100, 20);
		panel.add(newPass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(65, 85, 250, 25);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(65, 155, 250, 25);
		panel.add(passwordField_1);
		
		JButton changeButt = new JButton("Change");
		changeButt.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			

			MaintainUser mu = new MaintainUser();
			MaintainUser mu2 = new MaintainUser();
			try 
			{
				mu.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
				int last = mu.users.size() - 1;
				
				if(!mu.users.get(last).getPassword().equals(passwordField.getText()))
				{
					JOptionPane.showMessageDialog(null, "Wrong password!", "Failed", JOptionPane.ERROR_MESSAGE);
				}
				else if(passwordField.getText().length() <= 3)
				{
					JOptionPane.showMessageDialog(null, "The new password must be at least 3 characters!", "Failed", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					mu.users.get(last).setPassword(passwordField_1.getText());
					mu.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
					
					mu2.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\Book1.csv");
					for(User user : mu2.users)
					{
						if(mu.users.get(last).getEmail().equals(user.getEmail()))
						{
							user.setPassword(mu.users.get(last).getPassword());
						}
					}
					mu2.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\Book1.csv");
					
					dispose();
					JOptionPane.showMessageDialog(null, "Password changed!", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
				}
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	});
		changeButt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		changeButt.setBounds(65, 220, 150, 30);
		panel.add(changeButt);
		
	}
}
