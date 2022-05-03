package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Choice;
import java.awt.SystemColor;
import javax.swing.UIManager;

import implementation.MaintainUser;
import implementation.User;

public class SignUp {

	private JFrame frame;
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField emailText;
	private JTextField addressText;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 550);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Sign Up Page");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(45, 55, 80, 15);
		panel.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(45, 115, 80, 13);
		panel.add(lblLastName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(45, 175, 80, 13);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Address:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(45, 235, 80, 13);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Password:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(45, 295, 80, 13);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel location = new JLabel("Prefered Store Location:");
		location.setHorizontalAlignment(SwingConstants.LEFT);
		location.setFont(new Font("Tahoma", Font.PLAIN, 15));
		location.setBounds(45, 355, 200, 13);
		panel.add(location);
		
		firstNameText = new JTextField();
		firstNameText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		firstNameText.setBounds(45, 75, 330, 25);
		panel.add(firstNameText);
		firstNameText.setColumns(10);
		
		lastNameText = new JTextField();
		lastNameText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lastNameText.setColumns(10);
		lastNameText.setBounds(45, 135, 330, 25);
		panel.add(lastNameText);
		
		emailText = new JTextField();
		emailText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		emailText.setColumns(10);
		emailText.setBounds(45, 195, 330, 25);
		panel.add(emailText);
		
		addressText = new JTextField();
		addressText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addressText.setColumns(10);
		addressText.setBounds(45, 255, 330, 25);
		panel.add(addressText);
		
		Choice choice = new Choice();
		choice.setBackground(Color.WHITE);
		choice.setBounds(45, 385, 289, 25);
		panel.add(choice);
		choice.add("Toronto");
		choice.add("North York");
		choice.add("Vaughan");
		choice.add("New Market");
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String firstName = firstNameText.getText();
				String lastName = lastNameText.getText();
				String email = emailText.getText();
				String address = addressText.getText();
				String pass = passwordField.getText();
				String store = choice.getSelectedItem();
				
				if(!firstName.equals("") && !lastName.equals("") && email.contains("@")
						&& !address.equals("") && pass.length() > 3)
				{
					User user = new User(firstName, lastName, address, email, pass, store);
					MaintainUser mu = new MaintainUser();
					try {
						mu.users.add(user);
						mu.update("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\Book1.csv");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					frame.dispose();
					JOptionPane.showMessageDialog(null, "You have successfully Signed Up!", "Signing Up successful", JOptionPane.PLAIN_MESSAGE);
					SignIn signin = new SignIn();
					signin.setVisible(true);
				}
				if(firstName.equals("") || lastName.equals("") || email.equals("") || address.equals("") || pass.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Some required fields are empty!", "Signing Up Failed", JOptionPane.WARNING_MESSAGE);
				}
				else if(!email.contains("@"))
				{
					JOptionPane.showMessageDialog(null, "Please Enter a valid Email!", "Signing Up Failed", JOptionPane.WARNING_MESSAGE);
				}
				else if(pass.length()<=3)
				{
					JOptionPane.showMessageDialog(null, "Please Enter a password with 4 or more characters!", "Signing Up Failed", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(47, 430, 200, 30);
		panel.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(45, 318, 330, 25);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME TO SMARTSHOPPERS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(32, 10, 604, 35);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Already have an account?");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn si = new SignIn();
				si.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(297, 433, 237, 25);
		panel.add(btnNewButton_1);
		
	}
}
