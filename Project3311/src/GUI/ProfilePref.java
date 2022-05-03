package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePref extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilePref frame = new ProfilePref();
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
	public ProfilePref() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 456, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton changePass = new JButton("Change Password");
		changePass.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			PasswordChange pc = new PasswordChange();
			pc.setVisible(true);
			}
		});
		changePass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		changePass.setBounds(74, 59, 250, 30);
		panel.add(changePass);
		
		JButton btnChangeStoreLocation = new JButton("Change Prefered Store Location");
		btnChangeStoreLocation.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			LocationPref lf = new LocationPref();
			lf.setVisible(true);
			}
		});
		btnChangeStoreLocation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnChangeStoreLocation.setBounds(74, 139, 250, 30);
		panel.add(btnChangeStoreLocation);
		
		JButton btnDeleteYourAccount = new JButton("Delete Your Account");
		btnDeleteYourAccount.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Delete delete = new Delete();
			delete.setVisible(true);
			}
		});
		btnDeleteYourAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteYourAccount.setBounds(74, 179, 250, 30);
		panel.add(btnDeleteYourAccount);
		
		JButton btnChangeEmailid = new JButton("Change Email (ID)");
		btnChangeEmailid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeEmail em = new ChangeEmail();
				em.setVisible(true);
			}
		});
		btnChangeEmailid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnChangeEmailid.setBounds(74, 99, 250, 30);
		panel.add(btnChangeEmailid);
	}
}
