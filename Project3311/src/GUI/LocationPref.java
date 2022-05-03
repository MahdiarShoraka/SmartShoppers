package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import implementation.MaintainUser;
import implementation.User;

import java.awt.Choice;
import javax.swing.JButton;

public class LocationPref extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocationPref frame = new LocationPref();
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
	public LocationPref() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Choice choice = new Choice();
		choice.setBounds(46, 45, 222, 18);
		panel.add(choice);
		choice.add("Toronto");
		choice.add("North York");
		choice.add("Vaughan");
		choice.add("New Market");
		
		JButton btnNewButton = new JButton("Change");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(109, 162, 85, 21);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			//VALIDATE

			MaintainUser mu = new MaintainUser();
			MaintainUser mu2 = new MaintainUser();
			try 
			{
				mu.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
				int last = mu.users.size() - 1;
				
				mu.users.get(last).setStore(choice.getSelectedItem());
				mu.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
					
				mu2.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\Book1.csv");
				for(User user : mu2.users)
				{
					if(mu.users.get(last).getEmail().equals(user.getEmail()))
					{
						user.setStore(mu.users.get(last).getStore());
					}
				}
				mu2.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\Book1.csv");
				dispose();
				JOptionPane.showMessageDialog(null, "Prefered Store Changed!", "SUCCESS", JOptionPane.PLAIN_MESSAGE);	
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	});

}
}
