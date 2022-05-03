package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import implementation.Item;
import implementation.MaintainItem;
import implementation.MaintainShoppingList;
import implementation.MaintainUser;
import implementation.User;

public class Cart extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart frame = new Cart();
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
	public Cart() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 652, 767);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
	
		JButton bSearch2 = new JButton("Back to Search");
		bSearch2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bSearch2.setBounds(468, 34, 130, 30);
		panel.add(bSearch2);
		bSearch2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	
		JLabel lblNewLabel = new JLabel("Your SmartShoppers Cart");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 27, 220, 40);
		panel.add(lblNewLabel);
		
		
		MaintainUser mu = new MaintainUser();
		try {
			mu.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		User u = mu.users.get(mu.users.size()-1);
		String uEmail = u.getEmail();
		MaintainShoppingList ms = new MaintainShoppingList();
		try {
			ms.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\OrderList.csv");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int index =0;
		int y = 120;
		for (User user : ms.users)
		{
			if(user.getEmail().equals(uEmail))
			{
				Item item = ms.items.get(index);
				String itemName = item.getName();
				Double itemPrice = item.getPrice();
				
				JLabel name = new JLabel(itemName);
				name.setBounds(30, y, 200, 30);
				name.setFont(new Font("Tahoma", Font.PLAIN, 14));
				panel.add(name);
				
				JLabel price = new JLabel(Double.toString(itemPrice));
				price.setBounds(200, y, 200, 30);
				price.setFont(new Font("Tahoma", Font.PLAIN, 14));
				panel.add(price);
				
				JButton removeBtn = new JButton("Remove Item");
				removeBtn.setBounds(300, y, 150, 30);
				panel.add(removeBtn);
				removeBtn.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		int index = ms.items.indexOf(item);
		        		int index2 = ms.users.indexOf(user);
		        		ms.items.remove(index);
		        		ms.users.remove(index2);
		        		try {
							ms.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\OrderList.csv");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        		name.setVisible(false);
		        		price.setVisible(false);
		        		removeBtn.setVisible(false);
		        	}
		        });
				
				y += 40;
			}
			index++;
		}
		
		JLabel rcm = new JLabel("Recommended Items");
		rcm.setBounds(30, 400, 200, 30);
		rcm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(rcm);
		
		int y2 = 450;
		MaintainItem mi = new MaintainItem();
		String uStore = u.getStore();
		String path = "";
		if(uStore.equals("Toronto")) path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv";
		else if(uStore.equals("Vaughan")) path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList2.csv";
		else if(uStore.equals("New Market")) path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList3.csv";
		else if(uStore.equals("North York")) path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList4.csv";
		try {
			mi.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int j=0;
		for(Item item :mi.items)
		{
			if(!ms.items.contains(item))
			{
				JLabel name = new JLabel(item.getName());
				name.setBounds(30, y2, 200, 30);
				name.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel.add(name);
				j++;
				y2 += 50;
			}
			if(j>2)
			{
				break;
			}
		}
		
	}
}
