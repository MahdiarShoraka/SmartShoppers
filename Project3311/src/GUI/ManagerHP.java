package GUI;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import implementation.Item;
import implementation.MaintainItem;
import implementation.MaintainManager;
import implementation.MaintainStore;
import implementation.Manager;
import implementation.Store;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class ManagerHP extends JFrame {

	private JPanel contentPane;
	private JTextField eName;
	private JTextField ePrice;
	private JTextField eAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerHP frame = new ManagerHP();
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
	public ManagerHP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 894);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel editpage = new JPanel();
		editpage.setBackground(Color.WHITE);
		editpage.setBounds(0, 0, 843, 837);
		editpage.setVisible(false);
		panel.add(editpage, BorderLayout.CENTER);
		editpage.setLayout(null);

		
		JPanel mainPage = new JPanel();
		mainPage.setBackground(SystemColor.inactiveCaption);
		mainPage.setBounds(0, 0, 843, 837);
		mainPage.setLayout(null);
		panel.add(mainPage);
		
		JPanel addItemP = new JPanel();
		addItemP.setBackground(Color.WHITE);
		addItemP.setBounds(10, 10, 833, 827);
		addItemP.setVisible(false);
		panel.add(addItemP);
		addItemP.setLayout(null);
		
		JPanel storeHours = new JPanel();
		storeHours.setBackground(Color.WHITE);
		storeHours.setBounds(10, 10, 833, 827);
		storeHours.setVisible(false);
		panel.add(storeHours);
		storeHours.setLayout(null);
		
		JPanel storeMap = new JPanel();
		storeMap.setBackground(Color.WHITE);
		storeMap.setBounds(10, 10, 833, 827);
		storeMap.setVisible(false);
		panel.add(storeMap);
		storeMap.setLayout(null);


		JLabel lblNewLabel = new JLabel("Your Store Items");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(39, 24, 164, 40);
		mainPage.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Change Store Hours");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPage.setVisible(false);
				storeHours.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(864, 86, 155, 35);
		panel.add(btnNewButton);
		
		JButton btnChangeStoreMap = new JButton("Change Store Map");
		btnChangeStoreMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPage.setVisible(false);
				storeMap.setVisible(true);
			}
		});
		btnChangeStoreMap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnChangeStoreMap.setBounds(864, 147, 155, 35);
		panel.add(btnChangeStoreMap);
		
		JButton addBtn = new JButton("Add a new Item");
		addBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addBtn.setBounds(864, 207, 155, 35);
		panel.add(addBtn);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPage.setVisible(false);
				addItemP.setVisible(true);
			}
		});

		JButton logOutButton = new JButton("Log Out");
		logOutButton.setBounds(900, 780, 140, 35);
		panel.add(logOutButton);
		logOutButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				dispose();
				MaintainManager m = new MaintainManager();
				
				try {
					m.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo2.csv");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				m.managers.remove(m.managers.size()-1);
				SignIn si = new SignIn();
				si.setVisible(true);
				try {
					m.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo2.csv");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		logOutButton.setFont(new Font("Tahoma", Font.PLAIN, 12));

        MaintainManager m = new MaintainManager();
        try {
			m.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo2.csv");
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
 
        Manager ma = m.managers.get(m.managers.size()-1);
        String loc = ma.getStore().getLocation();
        
        MaintainItem mi = new MaintainItem();
        String path = "";
        if(loc.equals("Toronto"))
        {
				path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv";
        }
        else if(loc.equals("Vaughan"))
        {
        		path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList2.csv";
        }
        else if(loc.equals("New Market"))
        {
        		path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList3.csv";
        }
        else if(loc.equals("North York"))
        {
        		path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList4.csv";
        }
        try {
			mi.load(path);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        int y = 100;
        
        //changing store hours
		JLabel opening = new JLabel("Opening Hour:");
		opening.setFont(new Font("Tahoma", Font.PLAIN, 14));
		opening.setBounds(65, 100, 250, 30);
		storeHours.add(opening);
		
		JLabel closing = new JLabel("Closing Hour:");
		closing.setFont(new Font("Tahoma", Font.PLAIN, 14));
		closing.setBounds(65, 150, 250, 30);
		storeHours.add(closing);
		
		JTextField openingf = new JTextField();
		openingf.setColumns(10);
		openingf.setBounds(170, 100, 100, 30);
		storeHours.add(openingf);
		
		JTextField closingf = new JTextField();
		closingf.setColumns(10);
		closingf.setBounds(170, 150, 100, 30);
		storeHours.add(closingf);
		
		JButton changeHours = new JButton("Change Store Hours");
		changeHours.setFont(new Font("Tahoma", Font.PLAIN, 12));
		changeHours.setBounds(80, 250, 150, 30);
		storeHours.add(changeHours);
		changeHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO MaintainStore + change Store Hours
				MaintainStore ms = new MaintainStore();
				
				try {
					ms.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\StoreList.csv");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for(Store s : ms.stores)
				{
					if(s.getLocation().equals(loc))
					{
						s.setOpeningHour(Double.valueOf(openingf.getText()));
						s.setClosingHour(Double.valueOf(closingf.getText()));
					}
				}
				
				try {
					ms.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\StoreList.csv");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				storeHours.setVisible(false);
        		mainPage.revalidate();
        		mainPage.repaint();
				mainPage.setVisible(true);
			}
		});
		
		JButton bSearch2 = new JButton("Back to Search");
		bSearch2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bSearch2.setBounds(500, 20, 130, 30);
		storeHours.add(bSearch2);
		bSearch2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeHours.setVisible(false);
        		mainPage.revalidate();
        		mainPage.repaint();
				mainPage.setVisible(true);
			}
		});
		
        //changing store map
		JLabel upper = new JLabel("Upper Categorical Section");
		upper.setFont(new Font("Tahoma", Font.PLAIN, 14));
		upper.setBounds(65, 100, 250, 30);
		storeMap.add(upper);
		
		JLabel lower = new JLabel("Lower Categorical Section");
		lower.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lower.setBounds(65, 150, 250, 30);
		storeMap.add(lower);
		
		JLabel right = new JLabel("Right Side Categorical Section");
		right.setFont(new Font("Tahoma", Font.PLAIN, 14));
		right.setBounds(65, 200, 250, 30);
		storeMap.add(right);
		
		JLabel left = new JLabel("Left Side Categorical Section");
		left.setFont(new Font("Tahoma", Font.PLAIN, 14));
		left.setBounds(65, 250, 250, 30);
		storeMap.add(left);
		
		JTextField upperT = new JTextField();
		upperT.setColumns(10);
		upperT.setBounds(250, 100, 100, 30);
		storeMap.add(upperT);
		
		JTextField lowerT = new JTextField();
		lowerT.setColumns(10);
		lowerT.setBounds(250, 150, 100, 30);
		storeMap.add(lowerT);
		
		JTextField rightT = new JTextField();
		rightT.setColumns(10);
		rightT.setBounds(250, 200, 100, 30);
		storeMap.add(rightT);
		
		JTextField leftT = new JTextField();
		leftT.setColumns(10);
		leftT.setBounds(250, 250, 100, 30);
		storeMap.add(leftT);
		
		JButton changeMap = new JButton("Change Store Map");
		changeMap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		changeMap.setBounds(100, 400, 150, 30);
		storeMap.add(changeMap);
		changeMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO MaintainStore + change Store Hours
				MaintainStore ms = new MaintainStore();
				
				try {
					ms.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\StoreList.csv");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for(Store s : ms.stores)
				{
					if(s.getLocation().equals(loc))
					{
						if(!upperT.getText().equals("")) s.setUpper(upperT.getText());
						
						if(!lowerT.getText().equals("")) s.setLower(lowerT.getText());
						
						if(!rightT.getText().equals("")) s.setRight(rightT.getText());
						
						if(!leftT.getText().equals("")) s.setLeft(leftT.getText());
					}
				}
				
				try {
					ms.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\StoreList.csv");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				storeMap.setVisible(false);
        		mainPage.revalidate();
        		mainPage.repaint();
				mainPage.setVisible(true);
			}
		});

		JButton bSearch4 = new JButton("Back to Search");
		bSearch4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bSearch4.setBounds(500, 20, 130, 30);
		storeMap.add(bSearch4);
		bSearch4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeMap.setVisible(false);
        		mainPage.revalidate();
        		mainPage.repaint();
				mainPage.setVisible(true);
			}
		});
		
		
        //Adding a new Item
		JLabel addName = new JLabel("Name of the Item:");
		addName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addName.setBounds(65, 100, 250, 30);
		addItemP.add(addName);
		
		JLabel addPrice = new JLabel("Price of the Item:");
		addPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addPrice.setBounds(65, 180, 250, 30);
		addItemP.add(addPrice);
		
		JLabel addDsc = new JLabel("Description of the Item:");
		addDsc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addDsc.setBounds(65, 520, 250, 30);
		addItemP.add(addDsc);
		
		JLabel addAmount = new JLabel("Numbers In Stock:");
		addAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addAmount.setBounds(65, 340, 250, 30);
		addItemP.add(addAmount);
		
		JLabel addCategory = new JLabel("Category of the Item:");
		addCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addCategory.setBounds(65, 260, 250, 30);
		addItemP.add(addCategory);
		
		JTextField eName2 = new JTextField();
		eName2.setBounds(65, 130, 250, 30);
		addItemP.add(eName2);
		eName2.setColumns(10);
		
		JTextField ePrice2 = new JTextField();
		ePrice2.setColumns(10);
		ePrice2.setBounds(65, 210, 250, 30);
		addItemP.add(ePrice2);
		
		JTextField eCategory2 = new JTextField();
		eCategory2.setColumns(10);
		eCategory2.setBounds(65, 290, 250, 30);
		addItemP.add(eCategory2);
		
		JTextField eAmount2 = new JTextField();
		eAmount2.setColumns(10);
		eAmount2.setBounds(65, 370, 250, 30);
		addItemP.add(eAmount2);
		
		JLabel saleLabel2 = new JLabel("Is this Item on Sale?");
		saleLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saleLabel2.setBounds(65, 420, 250, 30);
		addItemP.add(saleLabel2);
		
		Choice sale2 = new Choice();
		sale2.add("No");
		sale2.add("Yes");
		sale2.setBounds(65,460,100,20);
		addItemP.add(sale2);
		
		JTextArea addDes = new JTextArea();
		addDes.setBackground(Color.LIGHT_GRAY);
		addDes.setForeground(Color.BLACK);
		addDes.setLineWrap(true);
		addDes.setBounds(65, 550, 548, 141);
		addDes.setEditable(true);
		addItemP.add(addDes);
		
		JButton bSearch3 = new JButton("Back to Search");
		bSearch3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bSearch3.setBounds(500, 20, 130, 30);
		addItemP.add(bSearch3);
		bSearch3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItemP.setVisible(false);
        		mainPage.revalidate();
        		mainPage.repaint();
				mainPage.setVisible(true);
			}
		});
		
		
		JButton addBtn2 = new JButton("Add a new Item");
		addBtn2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addBtn2.setBounds(65, 700, 155, 35);
		addItemP.add(addBtn2);
		addBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Item newItem = new Item(eName2.getText(), eCategory2.getText(), Double.valueOf(ePrice2.getText()), Integer.valueOf(eAmount2.getText()),false, addDes.getText());
				
				if(sale2.getSelectedItem().equals("Yes"))
				{
					newItem.setSale(true);
				}
	
				mi.items.add(newItem);
				
		        String path = "";
		        if(loc.equals("Toronto"))
		        {
						path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv";
		        }
		        else if(loc.equals("Vaughan"))
		        {
		        		path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList2.csv";
		        }
		        else if(loc.equals("New Market"))
		        {
		        		path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList3.csv";
		        }
		        else if(loc.equals("North York"))
		        {
		        		path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList4.csv";
		        }
		        try {
					mi.update2(path);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
				
				mainPage.setVisible(true);
				addItemP.setVisible(false);
			}
		});
        
		//Showing and Editing Items
        for(Item i : mi.items)
        {
        		//Showing the names of items
        		JLabel pName = new JLabel(i.getName());
        		pName.setBounds(50, y, 175, 30);
        		pName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        		
        		JLabel pPrice = new JLabel(String.valueOf(i.getPrice()));
        		pPrice.setBounds(300, y, 175, 30);
        		pPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
        		
        		if(i.isOnSale == true)
        		{
        			JLabel pSale = new JLabel("ON SALE");
        			pSale.setBounds(650, y, 175, 30);
        			pSale.setFont(new Font("Tahoma", Font.ITALIC, 14));
        			mainPage.add(pSale);
        			
        		}
        	
        		JButton editBtn = new JButton("Edit");
        		editBtn.setBounds(400, y, 100, 25);
        		editBtn.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent arg0) {
        					mainPage.setVisible(false);
        					editpage.removeAll();
        					editpage.setVisible(true);
        					
                    		JButton bSearch = new JButton("Back to Search");
                    		bSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
                    		bSearch.setBounds(500, 20, 130, 30);
                    		editpage.add(bSearch);
                    		bSearch.addActionListener(new ActionListener() {
                    			public void actionPerformed(ActionEvent e) {
                    				editpage.setVisible(false);
                    				editpage.removeAll();
                            		mainPage.revalidate();
                            		mainPage.repaint();
                    				mainPage.setVisible(true);
                    			}
                    		});
                    		JLabel lblNewLabel_1 = new JLabel("Edit Name:");
                    		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    		lblNewLabel_1.setBounds(65, 100, 100, 30);
                    		editpage.add(lblNewLabel_1);
                    		
                    		JLabel lblNewLabel_1_1 = new JLabel("Edit Price:");
                    		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    		lblNewLabel_1_1.setBounds(65, 180, 100, 30);
                    		editpage.add(lblNewLabel_1_1);
                    		
                    		JLabel lblNewLabel_1_1_1 = new JLabel("Numbers In Stock:");
                    		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    		lblNewLabel_1_1_1.setBounds(65, 260, 200, 30);
                    		editpage.add(lblNewLabel_1_1_1);
                    		
                    		eName = new JTextField();
                    		eName.setBounds(65, 130, 200, 30);
                    		editpage.add(eName);
                    		eName.setColumns(10);
                    		
                    		ePrice = new JTextField();
                    		ePrice.setColumns(10);
                    		ePrice.setBounds(65, 210, 200, 30);
                    		editpage.add(ePrice);
                    		
                    		eAmount = new JTextField();
                    		eAmount.setColumns(10);
                    		eAmount.setBounds(65, 290, 200, 30);
                    		editpage.add(eAmount);
                    		
                    		JLabel addDsc = new JLabel("Description of the Item:");
                    		addDsc.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    		addDsc.setBounds(65, 520, 250, 30);
                    		editpage.add(addDsc);
                    		
                    		JTextArea editDes = new JTextArea();
                    		editDes.setBackground(Color.LIGHT_GRAY);
                    		editDes.setForeground(Color.BLACK);
                    		editDes.setLineWrap(true);
                    		editDes.setBounds(65, 550, 548, 141);
                    		editDes.setEditable(true);
                    		editpage.add(editDes);
                    		
                    		JLabel saleLabel = new JLabel("Is this item on Sale?");
                    		saleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    		saleLabel.setBounds(65, 420, 200, 30);
                    		editpage.add(saleLabel);
                    		
                    		Choice sale = new Choice();
                    		sale.add("No");
                    		sale.add("Yes");
                    		sale.setBounds(65,460,100,20);
                    		editpage.add(sale);
                    		
                    		JButton editBtn2 = new JButton("Edit");
                    		editBtn2.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    		editBtn2.setBounds(65, 700, 114, 40);
                    		editpage.add(editBtn2);
                    		editBtn2.addActionListener(new ActionListener() {
                    			public void actionPerformed(ActionEvent e) {

                    				if(sale.getSelectedItem().equals("Yes"))
                    				{
                    					i.setSale(true);
                    				}
                    				else if(sale.getSelectedItem().equals("No"))
                    				{
                    					i.setSale(false);
                    				}
                    							
                    				if(!eName.getText().equals(""))
                    				{
                    					i.setName(eName.getText());
                    					pName.setText(eName.getText());
                    				}
                    				
                    				if(!editDes.getText().equals(""))
                    				{
                    					i.setDesc(editDes.getText());
                    				}
                    				
                    				if(!ePrice.getText().equals(""))
                    				{
                    					i.setPrice(Double.valueOf(ePrice.getText()));
                    					pPrice.setText(ePrice.getText());
                    				}
                    				
                    				if(!eAmount.getText().equals(""))
                    				{
                    					i.setAmount(Integer.valueOf(eAmount.getText()));
                    				}

                    		        String path = "";
                    		        if(loc.equals("Toronto"))
                    		        {
                    						path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv";
                    		        }
                    		        else if(loc.equals("Vaughan"))
                    		        {
                    		        		path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList2.csv";
                    		        }
                    		        else if(loc.equals("New Market"))
                    		        {
                    		        		path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList3.csv";
                    		        }
                    		        else if(loc.equals("North York"))
                    		        {
                    		        		path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList4.csv";
                    		        }
                    		        try {
                    					mi.update2(path);
                    				} catch (Exception e1) {
                    					// TODO Auto-generated catch block
                    					e1.printStackTrace();
                    				}
                    				editpage.setVisible(false);
                    				editpage.removeAll();
                            		mainPage.revalidate();
                            		mainPage.repaint();
                    				mainPage.setVisible(true);
                    			}
                    			
                    		});
        				}
        			});
        		
        		JButton removeBtn = new JButton("Remove");
        		removeBtn.setBounds(520, y, 100, 25);
        		removeBtn.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent arg0) {
        					mi.items.remove(i);
        					
            		        String path = "";
            		        if(loc.equals("Toronto"))
            		        {
            						path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv";
            		        }
            		        else if(loc.equals("Vaughan"))
            		        {
            		        		path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList2.csv";
            		        }
            		        else if(loc.equals("New Market"))
            		        {
            		        		path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList3.csv";
            		        }
            		        else if(loc.equals("North York"))
            		        {
            		        		path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList4.csv";
            		        }
            		        try {
            					mi.update2(path);
            				} catch (Exception e1) {
            					// TODO Auto-generated catch block
            					e1.printStackTrace();
            				}
            		        
            		        pName.setVisible(false);
            		        pPrice.setVisible(false);
            		        removeBtn.setVisible(false);
            		        editBtn.setVisible(false);
            		        mainPage.revalidate();
            		        mainPage.repaint();
            		        
        				}
        			});
        		
        		y = 40 + y;
        		
        		mainPage.add(removeBtn);
        		mainPage.add(editBtn);
        		mainPage.add(pName);
        		mainPage.add(pPrice);
        		
        		mainPage.revalidate();
        		mainPage.repaint();
        }     
	}
}
