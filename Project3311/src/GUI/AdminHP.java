package GUI;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import implementation.Item;
import implementation.MaintainAdmin;
import implementation.MaintainItem;
import implementation.MaintainManager;
import implementation.MaintainStore;
import implementation.Manager;
import implementation.Store;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AdminHP extends JFrame {
//test
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHP frame = new AdminHP();
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
	public AdminHP() {
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1260, 917);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 7, 1028, 866);
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		JPanel storeNames = new JPanel();
		storeNames.setBounds(10, 128, 881, 742);
		panel.add(storeNames);
		storeNames.setLayout(null);
		storeNames.setVisible(false);
		
		JPanel managers = new JPanel();
		managers.setBounds(10, 128, 881, 742);
		panel.add(managers);
		managers.setLayout(null);
		managers.setVisible(false);
		
		JPanel addManagers = new JPanel();
		addManagers.setBounds(10, 128, 881, 742);
		panel.add(addManagers);
		addManagers.setLayout(null);
		addManagers.setVisible(false);
		
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
		
		JButton btnNewButton = new JButton("Stores");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(1082, 55, 112, 35);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.setVisible(false);
				storeNames.setVisible(true);
				storeHours.setVisible(false);
				storeHours.removeAll();
				storeMap.setVisible(false);
				storeMap.removeAll();
				managers.setVisible(false);
				addManagers.setVisible(false);
			}
		});
		
		JButton btnManagers = new JButton("Managers");
		btnManagers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managers.setVisible(true);
				panel_1.removeAll();
				panel_1.setVisible(false);
				storeHours.setVisible(false);
				storeHours.removeAll();
				storeMap.setVisible(false);
				storeMap.removeAll();
				storeNames.setVisible(false);
			
				
				MaintainManager mm = new MaintainManager();
				try {
					mm.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ManagersList.csv");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
        		JButton addManager = new JButton("Add New Manager");
        		addManager.setBounds(100, 550, 100, 25);
        		managers.add(addManager);
        		addManager.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent arg0) {
        				managers.setVisible(false);
        				addManagers.setVisible(true);
        				
    	        		JLabel name1 = new JLabel("First Name:");
    	        		name1.setBounds(50, 100, 175, 30);
    	        		name1.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	        		addManagers.add(name1);
    	        		
    	        		JLabel name2 = new JLabel("Last Name:");
    	        		name2.setBounds(50, 200, 175, 30);
    	        		name2.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	        		addManagers.add(name2);
    	        		
    	        		JLabel email1 = new JLabel("Email:");
    	        		email1.setBounds(50, 300, 175, 30);
    	        		email1.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	        		addManagers.add(email1);
    	        		
    	        		JLabel password1 = new JLabel("Password:");
    	        		password1.setBounds(50, 400, 175, 30);
    	        		password1.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	        		addManagers.add(password1);
    	        		
						JTextField name1T = new JTextField();
						name1T.setColumns(10);
						name1T.setBounds(150, 100, 100, 30);
						addManagers.add(name1T);
						
						JTextField name2T = new JTextField();
						name2T.setColumns(10);
						name2T.setBounds(150, 200, 100, 30);
						addManagers.add(name2T);
						
						JTextField email1T = new JTextField();
						email1T.setColumns(10);
						email1T.setBounds(150, 300, 100, 30);
						addManagers.add(email1T);
						
						JTextField password1T = new JTextField();
						password1T.setColumns(10);
						password1T.setBounds(150, 400, 100, 30);
						addManagers.add(password1T);
						
						Choice choice = new Choice();
						choice.setBackground(Color.WHITE);
						choice.setBounds(50, 500, 289, 25);
						addManagers.add(choice);
						choice.add("Toronto");
						choice.add("Vaughan");
						choice.add("New Market");
						choice.add("North York");
						
		        		JButton addManager2 = new JButton("Add Manager");
		        		addManager2.setBounds(450, 600, 100, 25);
		        		addManagers.add(addManager2);
		        		addManager2.addActionListener(new ActionListener() {
		        			public void actionPerformed(ActionEvent arg0) {
		        				
	            		        Manager manager = new Manager(name1T.getText(),name2T.getText(),email1T.getText(),password1T.getText(),new Store());
	            		        manager.getStore().setLocation(choice.getSelectedItem());
	            		        mm.managers.add(manager);
		        				try {
	            					mm.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ManagersList.csv");
	            				} catch (Exception e1) {
	            					// TODO Auto-generated catch block
	            					e1.printStackTrace();
	            				}
		        				
		        				addManagers.setVisible(false);
		        				managers.revalidate();
		        				managers.repaint();
		        				managers.setVisible(true);
		        				}
		        			});
        				}
        			});
        		
				int y = 100;
				for(Manager m : mm.managers)
				{
					//Showing the names and emails
	        		JLabel mName = new JLabel(m.getLastName());
	        		mName.setBounds(50, y, 175, 30);
	        		mName.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        		managers.add(mName);
	        		
	        		JLabel mEmail = new JLabel(m.getEmail());
	        		mEmail.setBounds(200, y, 175, 30);
	        		mEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        		managers.add(mEmail);
	        		
	        		JLabel mStore = new JLabel(m.getStore().getLocation());
	        		mStore.setBounds(350, y, 175, 30);
	        		mStore.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        		managers.add(mStore);
	        		
	        		
	        		JButton removeBtn5 = new JButton("Remove");
	        		removeBtn5.setBounds(450, y, 100, 25);
	        		managers.add(removeBtn5);
	        		removeBtn5.addActionListener(new ActionListener() {
	        			public void actionPerformed(ActionEvent arg0) {
	        					mm.managers.remove(m);
	        					
	            		        try {
	            					mm.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ManagersList.csv");
	            				} catch (Exception e1) {
	            					// TODO Auto-generated catch block
	            					e1.printStackTrace();
	            				}
	            		        
	            		        mName.setVisible(false);
	            		        mEmail.setVisible(false);
	            		        removeBtn5.setVisible(false);
	            		        
	        				}
	        			});
	        		
	        		y = y + 50;
				}
			}
		});
		btnManagers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManagers.setBounds(1082, 10, 112, 35);
		panel.add(btnManagers);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MaintainAdmin a = new MaintainAdmin();
				
				try {
					a.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo3.csv");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				a.admins.remove(a.admins.size()-1);
				SignIn si = new SignIn();
				si.setVisible(true);
				try {
					a.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo3.csv");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogOut.setBounds(1082, 802, 112, 35);
		panel.add(btnLogOut);
		
		MaintainStore ms1 = new MaintainStore();
		
		try {
			ms1.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\StoreList.csv");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int x=0;
		for(Store s1 : ms1.stores)
		{
			if(s1.getLocation().equals("Vaughan"))
			{
				x++;
			}
		}

		JButton vaughanBtn = new JButton("Vaughan");
		vaughanBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vaughanBtn.setBounds(55, 111, 119, 33);
		storeNames.add(vaughanBtn);
		if(x==0)
		{
			vaughanBtn.setVisible(false);
		}
		vaughanBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeNames.setVisible(false);
				panel_1.removeAll();
				panel_1.setVisible(true);

						JPanel editpage = new JPanel();
						editpage.setBackground(Color.WHITE);
						editpage.setBounds(0, 0, 843, 837);
						editpage.setVisible(false);
						editpage.setLayout(null);
						panel_1.add(editpage);

						JPanel mainPage = new JPanel();
						mainPage.setBackground(SystemColor.inactiveCaption);
						mainPage.setBounds(0, 0, 843, 837);
						mainPage.setLayout(null);
						panel_1.add(mainPage);
						
						JPanel addItemP = new JPanel();
						addItemP.setBackground(Color.WHITE);
						addItemP.setBounds(10, 10, 833, 827);
						addItemP.setVisible(false);
						panel_1.add(addItemP);
						addItemP.setLayout(null);
						
						

						JLabel lblNewLabel = new JLabel("Vaughan Store Items");
						lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel.setBounds(39, 24, 200, 40);
						mainPage.add(lblNewLabel);
						
						JButton removeStore = new JButton("Remove Store");
						removeStore.setFont(new Font("Tahoma", Font.PLAIN, 12));
						removeStore.setBounds(864, 80, 155, 35);
						panel_1.add(removeStore);
						removeStore.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								MaintainStore ms = new MaintainStore();
								
								try {
									ms.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\StoreList.csv");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								for(int i=0; i<ms.stores.size(); i++)
								{
									if(ms.stores.get(i).getLocation().equals("Vaughan"))
									{
										ms.stores.remove(ms.stores.get(i));
									}
								}
								
								try {
									ms.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\StoreList.csv");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
								storeNames.remove(vaughanBtn);
								panel_1.setVisible(false);
								storeNames.setVisible(true);
							}
						});
						
						JButton btnNewButton = new JButton("Change Store Hours");
						btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
						btnNewButton.setBounds(864, 130, 155, 35);
						panel_1.add(btnNewButton);
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panel_1.setVisible(false);
								storeHours.setVisible(true);
							}
						});
						
						JButton btnChangeStoreMap = new JButton("Change Store Map");
						btnChangeStoreMap.setFont(new Font("Tahoma", Font.PLAIN, 12));
						btnChangeStoreMap.setBounds(864, 180, 155, 35);
						panel_1.add(btnChangeStoreMap);
						btnChangeStoreMap.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panel_1.setVisible(false);
								storeMap.setVisible(true);
							}
						});
						
						JButton addBtn = new JButton("Add a new Item");
						addBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
						addBtn.setBounds(864, 230, 155, 35);
						panel_1.add(addBtn);
						addBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								mainPage.setVisible(false);
								addItemP.setVisible(true);
							}
						});
				        
				        MaintainItem mi = new MaintainItem();
				        String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList2.csv";

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
								MaintainStore ms = new MaintainStore();
								
								try {
									ms.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\StoreList.csv");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								for(Store s : ms.stores)
								{
									if(s.getLocation().equals(vaughanBtn.getText()))
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
				        		panel_1.revalidate();
				        		panel_1.repaint();
				        		panel_1.setVisible(true);
							}
						});
						
						JButton bSearch2 = new JButton("Back to Search");
						bSearch2.setFont(new Font("Tahoma", Font.PLAIN, 12));
						bSearch2.setBounds(500, 20, 130, 30);
						storeHours.add(bSearch2);
						bSearch2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								storeHours.setVisible(false);
								panel_1.revalidate();
								panel_1.repaint();
								panel_1.setVisible(true);
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
									if(s.getLocation().equals("Vaughan"))
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
								panel_1.revalidate();
								panel_1.repaint();
								panel_1.setVisible(true);
							}
						});

						JButton bSearch4 = new JButton("Back to Search");
						bSearch4.setFont(new Font("Tahoma", Font.PLAIN, 12));
						bSearch4.setBounds(500, 20, 130, 30);
						storeMap.add(bSearch4);
						bSearch4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								storeMap.setVisible(false);
								panel_1.revalidate();
								panel_1.repaint();
								panel_1.setVisible(true);
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
								String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList2.csv";
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
				        
				        for(Item i : mi.items)
				        {
				        		//Showing the items
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
				                    		
				                    		JTextField eName = new JTextField();
				                    		eName.setBounds(65, 130, 200, 30);
				                    		editpage.add(eName);
				                    		eName.setColumns(10);
				                    		
				                    		JTextField ePrice = new JTextField();
				                    		ePrice.setColumns(10);
				                    		ePrice.setBounds(65, 210, 200, 30);
				                    		editpage.add(ePrice);
				                    		
				                    		JTextField eAmount = new JTextField();
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

				                    		        String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList2.csv";

				                    		        try {
				                    					mi.update2(path);
				                    				} catch (Exception e1) {
				                    					// TODO Auto-generated catch block
				                    					e1.printStackTrace();
				                    				}
				                    			}
				                    		});
				                    		
				        				}
				        			});
				        		
				        		JButton removeBtn = new JButton("Remove");
				        		removeBtn.setBounds(520, y, 100, 25);
				        		removeBtn.addActionListener(new ActionListener() {
				        			public void actionPerformed(ActionEvent arg0) {
				        					mi.items.remove(i);
				        					
				            		        String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList2.csv";

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
		});
		
		

		int x2 = 0;
		for(Store s1 : ms1.stores)
		{
			if(s1.getLocation().equals("Toronto"))
			{
				x2++;
			}
		}
		
		JButton btnNewButton_1_1 = new JButton("Toronto");
		if(x2==0)
		{
			btnNewButton_1_1.setVisible(false);
		}
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeNames.setVisible(false);
				
				panel_1.setVisible(true);

						
						JPanel editpage = new JPanel();
						editpage.setBackground(Color.WHITE);
						editpage.setBounds(0, 0, 843, 837);
						editpage.setVisible(false);
						editpage.setLayout(null);
						panel_1.add(editpage);

						
						JPanel mainPage = new JPanel();
						mainPage.setBackground(SystemColor.inactiveCaption);
						mainPage.setBounds(0, 0, 843, 837);
						mainPage.setLayout(null);
						panel_1.add(mainPage);
						
						JPanel addItemP = new JPanel();
						addItemP.setBackground(Color.WHITE);
						addItemP.setBounds(10, 10, 833, 827);
						addItemP.setVisible(false);
						panel_1.add(addItemP);
						addItemP.setLayout(null);


						JLabel lblNewLabel = new JLabel("Toronto Store Items");
						lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel.setBounds(39, 24, 200, 40);
						mainPage.add(lblNewLabel);
						
						JButton removeStore = new JButton("Remove Store");
						removeStore.setFont(new Font("Tahoma", Font.PLAIN, 12));
						removeStore.setBounds(864, 80, 155, 35);
						panel_1.add(removeStore);
						removeStore.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								MaintainStore ms = new MaintainStore();
								
								try {
									ms.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\StoreList.csv");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								for(int i=0; i<ms.stores.size(); i++)
								{
									if(ms.stores.get(i).getLocation().equals("Toronto"))
									{
										ms.stores.remove(ms.stores.get(i));
									}
								}
								
								try {
									ms.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\StoreList.csv");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
								storeNames.remove(btnNewButton_1_1);
								panel_1.setVisible(false);
								storeNames.setVisible(true);
							}
						});
						
						JButton btnNewButton = new JButton("Change Store Hours");
						btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
						btnNewButton.setBounds(864, 130, 155, 35);
						panel_1.add(btnNewButton);
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panel_1.setVisible(false);
								storeHours.setVisible(true);
							}
						});
						
						JButton btnChangeStoreMap = new JButton("Change Store Map");
						btnChangeStoreMap.setFont(new Font("Tahoma", Font.PLAIN, 12));
						btnChangeStoreMap.setBounds(864, 180, 155, 35);
						panel_1.add(btnChangeStoreMap);
						btnChangeStoreMap.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panel_1.setVisible(false);
								storeMap.setVisible(true);
							}
						});
						
						JButton addBtn = new JButton("Add a new Item");
						addBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
						addBtn.setBounds(864, 230, 155, 35);
						panel_1.add(addBtn);
						addBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								mainPage.setVisible(false);
								addItemP.setVisible(true);
							}
						});
				        
				        MaintainItem mi = new MaintainItem();
				        String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv";

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
									if(s.getLocation().equals(btnNewButton_1_1.getText()))
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
								panel_1.revalidate();
								panel_1.repaint();
								panel_1.setVisible(true);
							}
						});
						
						JButton bSearch2 = new JButton("Back to Search");
						bSearch2.setFont(new Font("Tahoma", Font.PLAIN, 12));
						bSearch2.setBounds(500, 20, 130, 30);
						storeHours.add(bSearch2);
						bSearch2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								storeHours.setVisible(false);
								panel_1.revalidate();
								panel_1.repaint();
								panel_1.setVisible(true);
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
									if(s.getLocation().equals("Toronto"))
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
								panel_1.revalidate();
								panel_1.repaint();
								panel_1.setVisible(true);
							}
						});

						JButton bSearch4 = new JButton("Back to Search");
						bSearch4.setFont(new Font("Tahoma", Font.PLAIN, 12));
						bSearch4.setBounds(500, 20, 130, 30);
						storeMap.add(bSearch4);
						bSearch4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								storeMap.setVisible(false);
								panel_1.revalidate();
								panel_1.repaint();
								panel_1.setVisible(true);
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
								String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv";
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
				                    		
				                    		JTextField eName = new JTextField();
				                    		eName.setBounds(65, 130, 200, 30);
				                    		editpage.add(eName);
				                    		eName.setColumns(10);
				                    		
				                    		JTextField ePrice = new JTextField();
				                    		ePrice.setColumns(10);
				                    		ePrice.setBounds(65, 210, 200, 30);
				                    		editpage.add(ePrice);
				                    		
				                    		JTextField eAmount = new JTextField();
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


				                    		        String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv";

				                    		        try {
				                    					mi.update2(path);
				                    				} catch (Exception e1) {
				                    					// TODO Auto-generated catch block
				                    					e1.printStackTrace();
				                    				}
				                    			}
				                    		});
				                    		
				        				}
				        			});
				        		
				        		JButton removeBtn = new JButton("Remove");
				        		removeBtn.setBounds(520, y, 100, 25);
				        		removeBtn.addActionListener(new ActionListener() {
				        			public void actionPerformed(ActionEvent arg0) {
				        					mi.items.remove(i);
				        					
				            		        String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv";

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
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(55, 53, 119, 33);
		storeNames.add(btnNewButton_1_1);
		
		int x3 = 0;
		for(Store s1 : ms1.stores)
		{
			if(s1.getLocation().equals("New Market"))
			{
				x3++;
			}
		}
		
		JButton btnNewButton_1_2 = new JButton("New Market");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_2.setBounds(55, 171, 119, 33);
		storeNames.add(btnNewButton_1_2);
		if(x3==0) btnNewButton_1_2.setVisible(false);

		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeNames.setVisible(false);
				panel_1.setVisible(true);

						JPanel editpage = new JPanel();
						editpage.setBackground(Color.WHITE);
						editpage.setBounds(0, 0, 843, 837);
						editpage.setVisible(false);
						editpage.setLayout(null);
						panel_1.add(editpage);

						JPanel mainPage = new JPanel();
						mainPage.setBackground(SystemColor.inactiveCaption);
						mainPage.setBounds(0, 0, 843, 837);
						mainPage.setLayout(null);
						panel_1.add(mainPage);
						
						JPanel addItemP = new JPanel();
						addItemP.setBackground(Color.WHITE);
						addItemP.setBounds(10, 10, 833, 827);
						addItemP.setVisible(false);
						panel_1.add(addItemP);
						addItemP.setLayout(null);

						JLabel lblNewLabel = new JLabel("New Market Store Items");
						lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel.setBounds(39, 24, 200, 40);
						mainPage.add(lblNewLabel);
						
						JButton removeStore = new JButton("Remove Store");
						removeStore.setFont(new Font("Tahoma", Font.PLAIN, 12));
						removeStore.setBounds(864, 80, 155, 35);
						panel_1.add(removeStore);
						removeStore.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								MaintainStore ms = new MaintainStore();
								
								try {
									ms.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\StoreList.csv");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								for(int i=0; i<ms.stores.size(); i++)
								{
									if(ms.stores.get(i).getLocation().equals("New Market"))
									{
										ms.stores.remove(ms.stores.get(i));
									}
								}
								
								try {
									ms.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\StoreList.csv");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
								storeNames.remove(btnNewButton_1_2);
								panel_1.setVisible(false);
								storeNames.setVisible(true);
							}
						});
						
						JButton btnNewButton = new JButton("Change Store Hours");
						btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
						btnNewButton.setBounds(864, 130, 155, 35);
						panel_1.add(btnNewButton);
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panel_1.setVisible(false);
								storeHours.setVisible(true);
							}
						});
						
						JButton btnChangeStoreMap = new JButton("Change Store Map");
						btnChangeStoreMap.setFont(new Font("Tahoma", Font.PLAIN, 12));
						btnChangeStoreMap.setBounds(864, 180, 155, 35);
						panel_1.add(btnChangeStoreMap);
						btnChangeStoreMap.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panel_1.setVisible(false);
								storeMap.setVisible(true);
							}
						});
						
						JButton addBtn = new JButton("Add a new Item");
						addBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
						addBtn.setBounds(864, 230, 155, 35);
						panel_1.add(addBtn);
						addBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								mainPage.setVisible(false);
								addItemP.setVisible(true);
							}
						});
				        
				        MaintainItem mi = new MaintainItem();
				        String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv";

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
									if(s.getLocation().equals(btnNewButton_1_2.getText()))
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
								panel_1.revalidate();
								panel_1.repaint();
								panel_1.setVisible(true);
							}
						});
						
						JButton bSearch2 = new JButton("Back to Search");
						bSearch2.setFont(new Font("Tahoma", Font.PLAIN, 12));
						bSearch2.setBounds(500, 20, 130, 30);
						storeHours.add(bSearch2);
						bSearch2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								storeHours.setVisible(false);
								panel_1.revalidate();
								panel_1.repaint();
								panel_1.setVisible(true);
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
									if(s.getLocation().equals("New Market"))
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
								panel_1.revalidate();
								panel_1.repaint();
								panel_1.setVisible(true);
							}
						});

						JButton bSearch4 = new JButton("Back to Search");
						bSearch4.setFont(new Font("Tahoma", Font.PLAIN, 12));
						bSearch4.setBounds(500, 20, 130, 30);
						storeMap.add(bSearch4);
						bSearch4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								storeMap.setVisible(false);
								panel_1.revalidate();
								panel_1.repaint();
								panel_1.setVisible(true);
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
								String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList3.csv";
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
				                    		
				                    		JTextField eName = new JTextField();
				                    		eName.setBounds(65, 130, 200, 30);
				                    		editpage.add(eName);
				                    		eName.setColumns(10);
				                    		
				                    		JTextField ePrice = new JTextField();
				                    		ePrice.setColumns(10);
				                    		ePrice.setBounds(65, 210, 200, 30);
				                    		editpage.add(ePrice);
				                    		
				                    		JTextField eAmount = new JTextField();
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

				                    		        String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList3.csv";

				                    		        try {
				                    					mi.update2(path);
				                    				} catch (Exception e1) {
				                    					// TODO Auto-generated catch block
				                    					e1.printStackTrace();
				                    				}
				                    			}
				                    		});
				                    		
				        				}
				        			});
				        		
				        		JButton removeBtn = new JButton("Remove");
				        		removeBtn.setBounds(520, y, 100, 25);
				        		removeBtn.addActionListener(new ActionListener() {
				        			public void actionPerformed(ActionEvent arg0) {
				        					mi.items.remove(i);
				        					
				            		        String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList3.csv";

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
		});
		
		
		int x4 = 0;
		for(Store s1 : ms1.stores)
		{
			if(s1.getLocation().equals("North York"))
			{
				x4++;
			}
		}
				
		JButton btnNewButton_11 = new JButton("North York");
		btnNewButton_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_11.setBounds(55, 231, 119, 33);
		storeNames.add(btnNewButton_11);
		if(x4==0) btnNewButton_11.setVisible(false);
		
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeNames.setVisible(false);
				panel_1.setVisible(true);

						JPanel editpage = new JPanel();
						editpage.setBackground(Color.WHITE);
						editpage.setBounds(0, 0, 843, 837);
						editpage.setVisible(false);
						editpage.setLayout(null);
						panel_1.add(editpage);

						JPanel mainPage = new JPanel();
						mainPage.setBackground(SystemColor.inactiveCaption);
						mainPage.setBounds(0, 0, 843, 837);
						mainPage.setLayout(null);
						panel_1.add(mainPage);
						
						JPanel addItemP = new JPanel();
						addItemP.setBackground(Color.WHITE);
						addItemP.setBounds(10, 10, 833, 827);
						addItemP.setVisible(false);
						panel_1.add(addItemP);
						addItemP.setLayout(null);

						JLabel lblNewLabel = new JLabel("North York Store Items");
						lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
						lblNewLabel.setBounds(39, 24, 200, 40);
						mainPage.add(lblNewLabel);
						
						JButton removeStore = new JButton("Remove Store");
						removeStore.setFont(new Font("Tahoma", Font.PLAIN, 12));
						removeStore.setBounds(864, 80, 155, 35);
						panel_1.add(removeStore);
						removeStore.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								MaintainStore ms = new MaintainStore();
								
								try {
									ms.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\StoreList.csv");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								for(int i=0; i<ms.stores.size(); i++)
								{
									if(ms.stores.get(i).getLocation().equals("North York"))
									{
										ms.stores.remove(ms.stores.get(i));
									}
								}
								
								try {
									ms.update2("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\StoreList.csv");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
								storeNames.remove(btnNewButton_11);
								panel_1.setVisible(false);
								storeNames.setVisible(true);
							}
						});
						
						JButton btnNewButton = new JButton("Change Store Hours");
						btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
						btnNewButton.setBounds(864, 130, 155, 35);
						panel_1.add(btnNewButton);
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panel_1.setVisible(false);
								storeHours.setVisible(true);
							}
						});
						
						JButton btnChangeStoreMap = new JButton("Change Store Map");
						btnChangeStoreMap.setFont(new Font("Tahoma", Font.PLAIN, 12));
						btnChangeStoreMap.setBounds(864, 180, 155, 35);
						panel_1.add(btnChangeStoreMap);
						btnChangeStoreMap.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panel_1.setVisible(false);
								storeMap.setVisible(true);
							}
						});
						
						JButton addBtn = new JButton("Add a new Item");
						addBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
						addBtn.setBounds(864, 230, 155, 35);
						panel_1.add(addBtn);
						addBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								mainPage.setVisible(false);
								addItemP.setVisible(true);
							}
						});
				        
				        MaintainItem mi = new MaintainItem();
				        String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv";

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
									if(s.getLocation().equals("North York"))
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
								panel_1.revalidate();
								panel_1.repaint();
								panel_1.setVisible(true);
							}
						});
						
						JButton bSearch2 = new JButton("Back to Search");
						bSearch2.setFont(new Font("Tahoma", Font.PLAIN, 12));
						bSearch2.setBounds(500, 20, 130, 30);
						storeHours.add(bSearch2);
						bSearch2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								storeHours.setVisible(false);
								panel_1.revalidate();
								panel_1.repaint();
								panel_1.setVisible(true);
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
									if(s.getLocation().equals("North York"))
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
								panel_1.revalidate();
								panel_1.repaint();
								panel_1.setVisible(true);
							}
						});

						JButton bSearch4 = new JButton("Back to Search");
						bSearch4.setFont(new Font("Tahoma", Font.PLAIN, 12));
						bSearch4.setBounds(500, 20, 130, 30);
						storeMap.add(bSearch4);
						bSearch4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								storeMap.setVisible(false);
								panel_1.revalidate();
								panel_1.repaint();
								panel_1.setVisible(true);
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
								String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList4.csv";
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
				                    		
				                    		JTextField eName = new JTextField();
				                    		eName.setBounds(65, 130, 200, 30);
				                    		editpage.add(eName);
				                    		eName.setColumns(10);
				                    		
				                    		JTextField ePrice = new JTextField();
				                    		ePrice.setColumns(10);
				                    		ePrice.setBounds(65, 210, 200, 30);
				                    		editpage.add(ePrice);
				                    		
				                    		JTextField eAmount = new JTextField();
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

				                    		        String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList4.csv";

				                    		        try {
				                    					mi.update2(path);
				                    				} catch (Exception e1) {
				                    					// TODO Auto-generated catch block
				                    					e1.printStackTrace();
				                    				}
				                    			}
				                    		});
				                    		
				        				}
				        			});
				        		
				        		JButton removeBtn = new JButton("Remove");
				        		removeBtn.setBounds(520, y, 100, 25);
				        		removeBtn.addActionListener(new ActionListener() {
				        			public void actionPerformed(ActionEvent arg0) {
				        					mi.items.remove(i);
				        					
				            		        String path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList4.csv";

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
		});
		
	}
}
