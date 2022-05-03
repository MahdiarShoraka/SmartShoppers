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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Are you sure that you want to delete your account?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 24, 366, 58);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("No");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(100, 120, 100, 25);
		panel.add(btnNewButton);
		
		JButton btnYes = new JButton("Yes");
		btnYes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					MaintainUser mu = new MaintainUser();
					MaintainUser mu2 = new MaintainUser();
					mu.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
					int last = mu.users.size() - 1;
					
					mu2.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\Book1.csv");
					
					for(User user : mu2.users)
					{
						if(user.getEmail().equals(mu.users.get(last).getEmail()))
						{
							mu2.users.remove(user);
							break;
						}
					}
					
					mu.users.remove(last);
					mu.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
						
					mu2.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\Book1.csv");
					dispose();
					JOptionPane.showMessageDialog(null, "You have successfully deleted your account!"
							+ " Your Data Will be Emailed to you shortly after deletion", "SUCCESS", JOptionPane.PLAIN_MESSAGE);	
				} 
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnYes.setBounds(220, 120, 100, 25);
		panel.add(btnYes);
	}
}
