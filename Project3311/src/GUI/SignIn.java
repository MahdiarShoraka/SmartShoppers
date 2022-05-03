package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import implementation.Admin;
import implementation.MaintainAdmin;
import implementation.MaintainManager;
import implementation.MaintainUser;
import implementation.Manager;
import implementation.User;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class SignIn extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
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
	public SignIn() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 550);
		setTitle("Log In Page");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(50, 115, 100, 25);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(50, 200, 100, 25);
		panel.add(lblPassword);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		email.setBounds(50, 150, 300, 25);
		panel.add(email);
		email.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setBounds(50, 235, 300, 25);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME TO SMARTSHOPPERS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(21, 25, 522, 35);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			//VALIDATE
			MaintainUser mu = new MaintainUser();
			MaintainUser si = new MaintainUser();
			try {
				mu.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\Book1.csv");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i=0;
			for(User user: mu.users)
			{
				if(user.getEmail().equals(email.getText()) && user.getPassword().equals(passwordField.getText()))
				{
					User s = new User(user.getFirstName(), user.getLastName(), user.getAddress(), user.getEmail(), user.getPassword(), user.getStore());
					si.users.add(s);
					try {
						si.update("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "You have successfully Loged In!", "LogIn Successful", JOptionPane.PLAIN_MESSAGE);
					dispose();
					HomePage hp = new HomePage();
					hp.setVisible(true);
					i++;
					break;
				}
				
				else if(passwordField.getText().equals("") && !email.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter your Password!", "LogIn Failed", JOptionPane.WARNING_MESSAGE);
					break;
				}
				
				else if(email.getText().equals("") && !passwordField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter your Email!", "LogIn Failed", JOptionPane.WARNING_MESSAGE);
					break;
				}
				else if(email.getText().equals("") && passwordField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter your Email and password!", "LogIn Failed", JOptionPane.WARNING_MESSAGE);
					break;
				}
			}
			if(i==0 && !email.getText().equals("") && !passwordField.getText().equals("")) JOptionPane.showMessageDialog(null, "Wrong Email or password!", "LogIn Failed", JOptionPane.ERROR_MESSAGE);
		}
	});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(50, 292, 100, 30);
		panel.add(btnNewButton);	
		
		JButton btnNewButton_1 = new JButton("Manager Log In");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainManager m1 = new MaintainManager();
				MaintainManager m2 = new MaintainManager();
				
				try {
					m1.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ManagersList.csv");	
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int i=0;
				for(Manager m: m1.managers)	//TODO
				{
					if(m.getEmail().equals(email.getText()) && m.getPassword().equals(passwordField.getText()))
					{
						Manager manager = new Manager(m.getFirstName(), m.getLastName(), m.getEmail(), m.getPassword(), m.getStore());
						m2.managers.add(manager);
						try {
							m2.update("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo2.csv");	
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "You have successfully Loged In!", "LogIn Successful", JOptionPane.PLAIN_MESSAGE);
						dispose();
						ManagerHP mhp = new ManagerHP();
						mhp.setVisible(true);
						i++;
						break;
					}
					
					else if(passwordField.getText().equals("") && !email.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please Enter your Password!", "LogIn Failed", JOptionPane.WARNING_MESSAGE);
						break;
					}
					
					else if(email.getText().equals("") && !passwordField.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please Enter your Email!", "LogIn Failed", JOptionPane.WARNING_MESSAGE);
						break;
					}
					else if(email.getText().equals("") && passwordField.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please Enter your Email and password!", "LogIn Failed", JOptionPane.WARNING_MESSAGE);
						break;
					}
				}
				if(i==0 && !email.getText().equals("") && !passwordField.getText().equals("")) JOptionPane.showMessageDialog(null, "Wrong Email or password!", "LogIn Failed", JOptionPane.ERROR_MESSAGE);	
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(50, 342, 164, 35);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Admin Log In");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaintainAdmin m1 = new MaintainAdmin();
				MaintainAdmin m2 = new MaintainAdmin();
				
				try {
					m1.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\AdminList.csv");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int i=0;
				for(Admin a: m1.admins)
				{
					if(a.getEmail().equals(email.getText()) && a.getPassword().equals(passwordField.getText()))
					{
						Admin admin = new Admin(a.getFirstName(), a.getLastName(), a.getEmail(), a.getPassword());
						m2.admins.add(admin);
						try {
							m2.update("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo3.csv");	
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "You have successfully Loged In!", "LogIn Successful", JOptionPane.PLAIN_MESSAGE);
						dispose();
						AdminHP ahp = new AdminHP();
						ahp.setVisible(true);
						i++;
						break;
					}
					
					else if(passwordField.getText().equals("") && !email.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please Enter your Password!", "LogIn Failed", JOptionPane.WARNING_MESSAGE);
						break;
					}
					
					else if(email.getText().equals("") && !passwordField.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please Enter your Email!", "LogIn Failed", JOptionPane.WARNING_MESSAGE);
						break;
					}
					
					else if(email.getText().equals("") && passwordField.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please Enter your Email and password!", "LogIn Failed", JOptionPane.WARNING_MESSAGE);
						break;
					}
				}
				if(i==0 && !email.getText().equals("") && !passwordField.getText().equals("")) JOptionPane.showMessageDialog(null, "Wrong Email or password!", "LogIn Failed", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(50, 399, 164, 35);
		panel.add(btnNewButton_1_1);
	}
}
		
	
