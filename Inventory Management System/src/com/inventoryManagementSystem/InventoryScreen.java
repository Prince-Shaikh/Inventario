package com.inventoryManagementSystem;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldSearch;
	private DefaultTableModel tableModel;

	/**
	 * Create the frame.
	 */
	public InventoryScreen() {
		setTitle("Inventory");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		this.setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("Lato", Font.PLAIN, 18));
		table.setColumnSelectionAllowed(false);
		scrollPane.setViewportView(table);
		
		
		//Code for the Table!!
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableModel = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		};
		
		String[] colNames = {"Product ID","Product Name","QTY in Stock"};
		tableModel.setColumnIdentifiers(colNames);
		tableModel.setRowCount(0);
		
		table.setModel(tableModel);
		
		refreshTable(App.products);
		
		
		
		
		//Fixing Table row and Column Sizes
		table.setRowHeight(50);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMaxWidth(50);;
		
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setMaxWidth(200);
		
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(255, 140, 0));
		panelTop.setMaximumSize(new Dimension(1280,100));
		contentPane.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new MigLayout("", "[][][400][550,grow][][][][][150]", "[43.00][40][]"));
		
		JLabel lblInventory = new JLabel("INVENTORY");
		lblInventory.setForeground(Color.WHITE);
		lblInventory.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblInventory.setAlignmentX(0.5f);
		panelTop.add(lblInventory, "cell 0 0 9 1,alignx center,aligny center");
		
		JLabel label = new JLabel("Search");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Montserrat", Font.BOLD, 16));
		panelTop.add(label, "flowy,cell 1 1,alignx left");
		
		JLabel label_1 = new JLabel("(By NAME)");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Montserrat", Font.PLAIN, 12));
		panelTop.add(label_1, "cell 1 1,alignx left");
		
		textFieldSearch = new JTextField();
		textFieldSearch.setToolTipText("Search By Name");
		textFieldSearch.setFont(new Font("Lato", Font.PLAIN, 16));
		textFieldSearch.setColumns(10);
		
		
		//Search Functionality
		textFieldSearch.setFocusable(true);
		textFieldSearch.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String searchStr = ""; 
				searchStr = textFieldSearch.getText();
				
				if(searchStr.length() != 0) {
					ArrayList<Product> products = new ArrayList<>();
					for(Product p : App.products) {
						if(p.getName().toUpperCase().contains(searchStr.toUpperCase())) {
							products.add(p);
						}
					}
					refreshTable(products);
				}else {
					refreshTable(App.products);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {}
			
		});
		
		panelTop.add(textFieldSearch, "cell 2 1,grow");
		
		JButton btnPrint = new JButton("PRINT");
		//Print Button Functionality
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					if(table.getRowCount() != 0) {
						
						StringBuilder str = new StringBuilder();
						
						str.append("<----------------------------------------- INVENTORY DETAILS ----------------------------------------->\n");
						
						Date date = new Date();
						SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, YYYY");
						str.append(String.format("\nDate: %s", formatter.format(date)));
						
						str.append("\n\n---------------------------------------------------------------------------------------------------------------------\n");
						str.append("Product\tProduct Name\t\t\tQuantity\n");
						str.append(" Code");
						str.append("\n---------------------------------------------------------------------------------------------------------------------\n");
				
						ArrayList<Product> products = new ArrayList<>();	// ArrayList to store products in the table
						
						for(int i = 0;i<table.getRowCount();i++) {
							
							int productID = (int) table.getValueAt(i, 0);
							Product p = searchProductByID(productID);
							if(p != null) {
								products.add(p);
							}
							
						}
						
						for(Product p : products) {
							
							int id = p.getID();
							String name = p.getName();
							int quantity = p.getQuantity();
							
							str.append(String.format("\n   %d\t%s\t\t\t     %d",id,name,quantity ));
						}
						
						JTextArea area = new JTextArea();
						area.append(str.toString());
						try {
							area.print();
							//Resetting the screen state
							textFieldSearch.setText("");
							refreshTable(App.products);
							
						} catch (PrinterException e) {
							JOptionPane.showMessageDialog(null, "Printer Error!!!");
						}
						
						
					}else {
						JOptionPane.showMessageDialog(null, "No Data To Print!");
					}	
				
				
			}
		});
		
		btnPrint.setFont(new Font("Lato", Font.BOLD, 20));
		btnPrint.setToolTipText("Print Table");
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setBackground(new Color(70, 130, 180));
		btnPrint.setActionCommand("New");
		panelTop.add(btnPrint, "cell 8 1,grow");
	}
	
	public void refreshTable(ArrayList<Product> data) {
		tableModel.setRowCount(0);
		for(Product p : data) {
			tableModel.addRow(new Object[] {p.getID(),p.getName(),p.getQuantity()});
		}

	}
	
	private Product searchProductByID(int id) {
		for(Product p : App.products) {
			if(p.getID() == id) {
				return p;
			}
		}
		
		return null;
		
	}

}
