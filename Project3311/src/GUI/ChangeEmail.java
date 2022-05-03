package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import implementation.MaintainUser;
import implementation.User;

import javax.swing.JTextField;

public class ChangeEmail extends JFrame {

	private JPanel contentPane;
	private JTextField oldEmailT;
	private JTextField newEmailT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeEmail frame = new ChangeEmail();
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
	public ChangeEmail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel oldE = new JLabel("Old Email:");
		oldE.setFont(new Font("Tahoma", Font.PLAIN, 12));
		oldE.setBounds(65, 60, 100, 20);
		panel.add(oldE);
		
		JLabel newE = new JLabel("New Email:");
		newE.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newE.setBounds(65, 130, 100, 20);
		panel.add(newE);
		
		oldEmailT = new JTextField();
		oldEmailT.setBounds(65, 90, 200, 19);
		panel.add(oldEmailT);
		oldEmailT.setColumns(10);
		
		newEmailT = new JTextField();
		newEmailT.setColumns(10);
		newEmailT.setBounds(65, 160, 200, 19);
		panel.add(newEmailT);
		
		
		JButton changeButt = new JButton("Change");
		changeButt.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			//VALIDATE

			MaintainUser mu = new MaintainUser();
			MaintainUser mu2 = new MaintainUser();
			try 
			{
				mu.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
				int last = mu.users.size() - 1;
				
				if(!mu.users.get(last).getEmail().equals(oldEmailT.getText()))
				{
					JOptionPane.showMessageDialog(null, "Wrong Email!", "Failed", JOptionPane.ERROR_MESSAGE);
				}
				else if(newEmailT.getText().equals("") || !newEmailT.getText().contains("@"))
				{
					JOptionPane.showMessageDialog(null, "Please put a valid new Email ID!", "Failed", JOptionPane.WARNING_MESSAGE);
				}
				
				else
				{
					mu.users.get(last).setEmail(newEmailT.getText());
					mu.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
					
					mu2.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\Book1.csv");
					for(User user : mu2.users)
					{
						if(mu.users.get(last).getFirstName().equals(user.getFirstName()) && mu.users.get(last).getLastName().equals(user.getLastName()))
						{
							user.setEmail(mu.users.get(last).getEmail());
						}
					}
					mu2.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\Book1.csv");
					
					dispose();
					JOptionPane.showMessageDialog(null, "Email ID changed!", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
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
