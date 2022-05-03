package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import implementation.MaintainUser;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 750, 550);
		setTitle("HomePage");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to your HomePage!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(50, 30, 300, 50);
		panel.add(lblNewLabel);
		
		JButton storeButt = new JButton("Store");
		storeButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Storepage st = new Storepage();
				st.setVisible(true);
			}
		});
		storeButt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		storeButt.setBounds(90, 227, 140, 40);
		panel.add(storeButt);
		
		JButton profileButton = new JButton("Your Profile");
		profileButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		profileButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			ProfilePref pro = new ProfilePref();
			pro.setVisible(true);
			}
		});
		profileButton.setBounds(90, 140, 140, 40);
		panel.add(profileButton);
		
		
		JButton logOutButton = new JButton("Log Out");
		logOutButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				dispose();
				MaintainUser lo = new MaintainUser();
				try {
					lo.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lo.users.remove(lo.users.size()-1);
				SignIn si = new SignIn();
				si.setVisible(true);
				try {
					lo.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		logOutButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		logOutButton.setBounds(545, 422, 140, 40);
		panel.add(logOutButton);
		
		JButton btnNewButton_1_1 = new JButton("Your Cart");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		Cart cart = new Cart();
        		cart.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1.setBounds(280, 140, 140, 40);
		panel.add(btnNewButton_1_1);
	}
}
