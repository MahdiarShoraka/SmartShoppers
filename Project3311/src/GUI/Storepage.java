package GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import implementation.Item;
import implementation.MaintainItem;
import implementation.MaintainShoppingList;
import implementation.MaintainUser;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Choice;

import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Storepage extends JFrame {

	private JTextField searchField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Storepage frame = new Storepage();
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
	public Storepage() {

        setBounds(100, 100, 1078, 839);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle("Store Page");
        
        JPanel mainP = new JPanel();
        mainP.setBackground(SystemColor.inactiveCaption);
        getContentPane().add(mainP, BorderLayout.CENTER);
        mainP.setLayout(null);


        JScrollPane jsp = new JScrollPane(mainP);
        mainP.setPreferredSize(new Dimension(750, 1000));
        getContentPane().add(jsp);
        
		JPanel infoP = new JPanel();
		infoP.setBackground(SystemColor.DARK_GRAY);
		infoP.setBounds(22, 190, 994, 710);
		infoP.setVisible(false);
		infoP.setLayout(null);
		mainP.add(infoP);
		
        JLabel lblHelloWorld = new JLabel("Welcome to ShoppersLand!");
        lblHelloWorld.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblHelloWorld.setBounds(43, 42, 184, 19);
        mainP.add(lblHelloWorld);
        
        JPanel itemsP = new JPanel();
        itemsP.setBackground(SystemColor.window);
        itemsP.setBounds(22, 190, 994, 711);
        mainP.add(itemsP);
        itemsP.setLayout(null);
        
        
        JButton btnYourCart = new JButton("Your Cart");
        btnYourCart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Cart cart = new Cart();
        		cart.setVisible(true);
        	}
        });
        btnYourCart.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnYourCart.setBounds(886, 72, 130, 30);
        mainP.add(btnYourCart);

        Choice chooseCatg = new Choice();
        chooseCatg.setBounds(43, 77, 290, 30);
        mainP.add(chooseCatg);
        chooseCatg.add("Phone");
        chooseCatg.add("Tablet");
        chooseCatg.add("Laptop");
        
        JLabel lblProduct = new JLabel("Product");
        lblProduct.setBounds(70, 158, 100, 25);
        mainP.add(lblProduct);
        lblProduct.setForeground(Color.BLUE);
        lblProduct.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblProduct.setVisible(false);
        
        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(330, 158, 100, 25);
        mainP.add(lblPrice);
        lblPrice.setForeground(Color.BLUE);
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblPrice.setVisible(false);
        
        JButton searchBtn = new JButton("Search By Category");
        searchBtn.setBounds(43, 101, 147, 30);
        searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        mainP.add(searchBtn);
        //Start Searching by Category
        
        searchBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		itemsP.removeAll();
                lblPrice.setVisible(true);
                lblProduct.setVisible(true);
                
                MaintainItem mi = new MaintainItem();
                MaintainUser u = new MaintainUser();
                String path = "";
                try {
					u.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
                if(u.users.get(u.users.size()-1).getStore().equals("Toronto"))
                {
                	path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv";
                }
                else if(u.users.get(u.users.size()-1).getStore().equals("Vaughan"))
                {
                	path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList2.csv";
                }
                else if(u.users.get(u.users.size()-1).getStore().equals("New Market")) 
                {
                	path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList3.csv";
                }
                else if(u.users.get(u.users.size()-1).getStore().equals("North York"))
                {
                	path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList4.csv";
                }
                try {
        			mi.load(path);
        		} catch (Exception e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
                int y = 0;
                for(Item i : mi.items)
                {
                	//searching the category
                	if(chooseCatg.getSelectedItem().equals(i.getCategory()))
                	{
                		//Showing the names of items
                		y = 40 + y;
                		JLabel pName = new JLabel(i.getName());
                		pName.setBounds(50, y, 175, 30);
                		pName.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		
                		JLabel pPrice = new JLabel(String.valueOf(i.getPrice()));
                		pPrice.setBounds(300, y, 175, 30);
                		pPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		
		        		if(i.isOnSale == true)
		        		{
		        			JLabel pSale = new JLabel("ON SALE");
		        			pSale.setBounds(900, y, 175, 30);
		        			pSale.setFont(new Font("Tahoma", Font.ITALIC, 14));
		        			itemsP.add(pSale);
		        			
		        		}
                		JButton addBtn = new JButton("Add to Cart");
                        addBtn.setBounds(700, y, 175, 30);
                        addBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
                		addBtn.addActionListener(new ActionListener() {
                		public void actionPerformed(ActionEvent e) {
                				MaintainUser u = new MaintainUser();
                				MaintainShoppingList sl = new MaintainShoppingList();
                
                				try {
									u.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
                				int num = i.getAmount();
                				if(num>0)
                				{
                					sl.users.add(u.users.get(u.users.size()-1));
                					sl.items.add(i);
                					num--;
                					i.setAmount(num);
                					try {
                						sl.update("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\OrderList.csv");
                					} catch (Exception e1) {
                						// TODO Auto-generated catch block
                						e1.printStackTrace();
                					}
                				}
                				else if(num == 0)
                				{
                					JOptionPane.showMessageDialog(null, "This Item Is Out of Stock!", "out of stock", JOptionPane.WARNING_MESSAGE);
                				}
                			}	
                		});
                		
    					try {
							mi.update2(path);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                		
                		JButton infoBtn = new JButton("Product Info");
                        infoBtn.setBounds(450, y, 175, 30);
                        infoBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
                		infoBtn.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		infoP.setVisible(true);
                        		itemsP.setVisible(false);
                        		
                        		JButton bSearch = new JButton("Back to Search");
                        		bSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
                        		bSearch.setBounds(580, 10, 130, 30);
                        		infoP.add(bSearch);
                        		bSearch.addActionListener(new ActionListener() {
                        			public void actionPerformed(ActionEvent e) {
                        				infoP.setVisible(false);
                        				infoP.removeAll();
                        				itemsP.setVisible(true);
                        			}
                        		});
                        		
                        		JLabel prodName = new JLabel(i.getName());
                                prodName.setBounds(60, 60, 300, 35);
                                infoP.add(prodName);
                                prodName.setForeground(Color.WHITE);
                                prodName.setFont(new Font("Tahoma", Font.BOLD, 20));
                                
                                JTextArea dsc = new JTextArea();
                                dsc.setEditable(false);  
                                dsc.setCursor(null);  
                                dsc.setOpaque(false);  
                                dsc.setFocusable(false);
                                dsc.setLineWrap(true);
                                dsc.setWrapStyleWord(true);
                                dsc.setBounds(60, 100, 600, 600);
                                infoP.add(dsc);
                                dsc.append(i.getDesc());
                                dsc.setForeground(Color.WHITE);
                                dsc.setFont(new Font("Tahoma", Font.PLAIN, 15));
                          
                        	}
                        });
                		itemsP.add(addBtn);
                		itemsP.add(infoBtn);
                		itemsP.add(pName);
                	    itemsP.add(pPrice);
                	    //Refreshing the panel and showing the Correct Changed Category
                		itemsP.revalidate();
                		itemsP.repaint();
                	}
                }
        	}
        });
        
        //Search Field
        searchField = new JTextField();
        searchField.setBounds(400, 70, 296, 25);
        mainP.add(searchField);
        searchField.setColumns(10);
        
        JButton searchByNameBtn = new JButton("Search By Name");
        searchByNameBtn.setBounds(409, 101, 130, 30);
        searchByNameBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        mainP.add(searchByNameBtn);
        searchByNameBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		itemsP.removeAll();
                lblPrice.setVisible(true);
                lblProduct.setVisible(true);
                
                MaintainItem mi = new MaintainItem();
                MaintainUser u = new MaintainUser();
                String path = "";
                try {
					u.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
                if(u.users.get(u.users.size()-1).getStore().equals("Toronto"))
                {
                	path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv";
                }
                else if(u.users.get(u.users.size()-1).getStore().equals("Vaughan"))
                {
                	path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList2.csv";
                }
                else if(u.users.get(u.users.size()-1).getStore().equals("New Market")) 
                {
                	path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList3.csv";
                }
                else if(u.users.get(u.users.size()-1).getStore().equals("North York")) 
                {
                	path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList4.csv";
                }
                try {
        			mi.load(path);
        		} catch (Exception e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
                int y = 0;
                for(Item i : mi.items)
                {
                	//searching the category
                	if(i.getName().toLowerCase().contains(searchField.getText().toLowerCase()) && !searchField.getText().equals(""))
                	{
                		//Showing the names of items
                		y = 40 + y;
                		JLabel pName = new JLabel(i.getName());
                		pName.setBounds(50, y, 175, 30);
                		pName.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		
                		JLabel pPrice = new JLabel(String.valueOf(i.getPrice()));
                		pPrice.setBounds(300, y, 175, 30);
                		pPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		
		        		if(i.isOnSale == true)
		        		{
		        			JLabel pSale = new JLabel("ON SALE");
		        			pSale.setBounds(900, y, 175, 30);
		        			pSale.setFont(new Font("Tahoma", Font.ITALIC, 14));
		        			itemsP.add(pSale);
		        			
		        		}
                		
                		
                		JButton addBtn = new JButton("Add to Cart");
                        addBtn.setBounds(700, y, 175, 30);
                        addBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
                		addBtn.addActionListener(new ActionListener() {
                		public void actionPerformed(ActionEvent e) {
                				MaintainUser u = new MaintainUser();
                				MaintainShoppingList sl = new MaintainShoppingList();
                
                				try {
									u.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
                				int num = i.getAmount();
                				if(num>0)
                				{
                					sl.users.add(u.users.get(u.users.size()-1));
                					sl.items.add(i);
                					num--;
                					i.setAmount(num);
                					try {
                						sl.update("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\OrderList.csv");
                					} catch (Exception e1) {
                						// TODO Auto-generated catch block
                						e1.printStackTrace();
                					}
                				}
                				else if(num == 0)
                				{
                					JOptionPane.showMessageDialog(null, "This Item Is Out of Stock!", "out of stock", JOptionPane.WARNING_MESSAGE);
                				}
                			}	
                		});
                		
    					try {
							mi.update2(path);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                		
                		JButton infoBtn = new JButton("Product Info");
                        infoBtn.setBounds(450, y, 175, 30);
                        infoBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
                		infoBtn.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		infoP.setVisible(true);
                        		itemsP.setVisible(false);
                        		
                        		JButton bSearch = new JButton("Back to Search");
                        		bSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
                        		bSearch.setBounds(580, 10, 130, 30);
                        		infoP.add(bSearch);
                        		bSearch.addActionListener(new ActionListener() {
                        			public void actionPerformed(ActionEvent e) {
                        				infoP.setVisible(false);
                        				infoP.removeAll();
                        				itemsP.setVisible(true);
                        			}
                        		});
                        		
                        		JLabel prodName = new JLabel(i.getName());
                                prodName.setBounds(60, 60, 300, 35);
                                infoP.add(prodName);
                                prodName.setForeground(Color.WHITE);
                                prodName.setFont(new Font("Tahoma", Font.BOLD, 20));
                                
                                JTextArea dsc = new JTextArea();
                                dsc.setEditable(false);  
                                dsc.setCursor(null);  
                                dsc.setOpaque(false);  
                                dsc.setFocusable(false);
                                dsc.setLineWrap(true);
                                dsc.setWrapStyleWord(true);
                                dsc.setBounds(60, 100, 600, 600);
                                infoP.add(dsc);
                                dsc.append(i.getDesc());
                                dsc.setForeground(Color.WHITE);
                                dsc.setFont(new Font("Tahoma", Font.PLAIN, 15));
                          
                        	}
                        });
                		itemsP.add(addBtn);
                		itemsP.add(infoBtn);
                		itemsP.add(pName);
                	    itemsP.add(pPrice);
                	    //Refreshing the panel and showing the Correct Changed Category
                		itemsP.revalidate();
                		itemsP.repaint();
                	}
                }
        	}
        });
        
        JButton searchSale = new JButton("Search Deals");
        searchSale.setBounds(203, 101, 130, 30);
        searchSale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        mainP.add(searchSale);
        //Start Searching by Category
        
        searchSale.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		itemsP.removeAll();
                lblPrice.setVisible(true);
                lblProduct.setVisible(true);
                
                MaintainItem mi = new MaintainItem();
                MaintainUser u = new MaintainUser();
                String path = "";
                try {
					u.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
                if(u.users.get(u.users.size()-1).getStore().equals("Toronto"))
                {
                	path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList.csv";
                }
                else if(u.users.get(u.users.size()-1).getStore().equals("Vaughan"))
                {
                	path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList2.csv";
                }
                else if(u.users.get(u.users.size()-1).getStore().equals("New Market")) 
                {
                	path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList3.csv";
                }
                else if(u.users.get(u.users.size()-1).getStore().equals("North York")) 
                {
                	path = "C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\ItemList4.csv";
                }
                try {
        			mi.load(path);
        		} catch (Exception e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
                int y = 0;
                for(Item i : mi.items)
                {
                	//searching the category
                	if(i.getSale() == true)
                	{
                		//Showing the names of items
                		y = 40 + y;
                		JLabel pName = new JLabel(i.getName());
                		pName.setBounds(50, y, 175, 30);
                		pName.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		
                		JLabel pPrice = new JLabel(String.valueOf(i.getPrice()));
                		pPrice.setBounds(300, y, 175, 30);
                		pPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
                		
		        		if(i.isOnSale == true)
		        		{
		        			JLabel pSale = new JLabel("ON SALE");
		        			pSale.setBounds(900, y, 175, 30);
		        			pSale.setFont(new Font("Tahoma", Font.ITALIC, 14));
		        			itemsP.add(pSale);
		        			
		        		}
                		
                		JButton addBtn = new JButton("Add to Cart");
                        addBtn.setBounds(700, y, 175, 30);
                        addBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
                		addBtn.addActionListener(new ActionListener() {
                		public void actionPerformed(ActionEvent e) {
                				MaintainUser u = new MaintainUser();
                				MaintainShoppingList sl = new MaintainShoppingList();
                
                				try {
									u.load("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\SignInInfo.csv");
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
                				int num = i.getAmount();
                				if(num>0)
                				{
                					sl.users.add(u.users.get(u.users.size()-1));
                					sl.items.add(i);
                					num--;
                					i.setAmount(num);
                					try {
                						sl.update("C:\\Users\\mahdi\\eclipse-workspace\\Project3311\\OrderList.csv");
                					} catch (Exception e1) {
                						// TODO Auto-generated catch block
                						e1.printStackTrace();
                					}
                				}
                				else if(num == 0)
                				{
                					JOptionPane.showMessageDialog(null, "This Item Is Out of Stock!", "out of stock", JOptionPane.WARNING_MESSAGE);
                				}
                			}	
                		});
                		
    					try {
							mi.update2(path);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                		
                		JButton infoBtn = new JButton("Product Info");
                        infoBtn.setBounds(450, y, 175, 30);
                        infoBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
                		infoBtn.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		infoP.setVisible(true);
                        		itemsP.setVisible(false);
                        		
                        		JButton bSearch = new JButton("Back to Search");
                        		bSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
                        		bSearch.setBounds(580, 10, 130, 30);
                        		infoP.add(bSearch);
                        		bSearch.addActionListener(new ActionListener() {
                        			public void actionPerformed(ActionEvent e) {
                        				infoP.setVisible(false);
                        				infoP.removeAll();
                        				itemsP.setVisible(true);
                        			}
                        		});
                        		
                        		JLabel prodName = new JLabel(i.getName());
                                prodName.setBounds(60, 60, 300, 35);
                                infoP.add(prodName);
                                prodName.setForeground(Color.WHITE);
                                prodName.setFont(new Font("Tahoma", Font.BOLD, 20));
                                
                                JTextArea dsc = new JTextArea();
                                dsc.setEditable(false);  
                                dsc.setCursor(null);  
                                dsc.setOpaque(false);  
                                dsc.setFocusable(false);
                                dsc.setLineWrap(true);
                                dsc.setWrapStyleWord(true);
                                dsc.setBounds(60, 100, 600, 600);
                                infoP.add(dsc);
                                dsc.append(i.getDesc());
                                dsc.setForeground(Color.WHITE);
                                dsc.setFont(new Font("Tahoma", Font.PLAIN, 15));
                          
                        	}
                        });
                		itemsP.add(addBtn);
                		itemsP.add(infoBtn);
                		itemsP.add(pName);
                	    itemsP.add(pPrice);
                	    //Refreshing the panel and showing the Correct Changed Category
                		itemsP.revalidate();
                		itemsP.repaint();
                	}
                }
        	}
        });
        
		JButton logOutButton = new JButton("Log Out");
		logOutButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		logOutButton.setBounds(886, 130, 130, 30);
		mainP.add(logOutButton);
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

	}
}
