package com.inventoryManagementSystem;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class ReportsScreen extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JRadioButton rdbtnPurchsae;
	private JRadioButton rdbtnSale;
	private JComboBox<String> comboBoxName;
	private JComboBox<String> comboBoxProduct;
	private JDateChooser dateChooserFrom;
	private JDateChooser dateChooserTo;
	private JLabel lblName;
	private DefaultTableModel tableModel;
	
	/**
	 * Create the frame.
	 */
	public ReportsScreen() {
		setTitle("Reports");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		panel.setPreferredSize(new Dimension(450,720));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(null);
		
		JLabel lblVendors = new JLabel("Reports");
		lblVendors.setBounds(158, 58, 133, 31);
		lblVendors.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblVendors.setForeground(Color.WHITE);
		lblVendors.setFont(new Font("Montserrat", Font.BOLD, 30));
		panel.add(lblVendors);
		
		lblName = new JLabel("Vendor");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblName.setBounds(38, 317, 88, 16);
		panel.add(lblName);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setForeground(Color.WHITE);
		lblProduct.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblProduct.setBounds(38, 372, 76, 16);
		panel.add(lblProduct);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(this);
		btnPrint.setActionCommand("Print");
		btnPrint.setBackground(new Color(70, 130, 180));
		btnPrint.setForeground(SystemColor.text);
		btnPrint.setBounds(70, 557, 120, 50);
		panel.add(btnPrint);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setActionCommand("Clear");
		btnClear.addActionListener(this);
		btnClear.setBackground(new Color(70, 130, 180));
		btnClear.setForeground(SystemColor.text);
		btnClear.setBounds(260, 557, 120, 50);
		panel.add(btnClear);
		
		
		ButtonGroup btngrp = new ButtonGroup();
		
		rdbtnPurchsae = new JRadioButton("PURCHASE");
		rdbtnPurchsae.setSelected(true);
		rdbtnPurchsae.setForeground(new Color(255, 255, 255));
		rdbtnPurchsae.setFont(new Font("Lato", Font.BOLD, 18));
		rdbtnPurchsae.setBackground(new Color(255, 140, 0));
		rdbtnPurchsae.setBounds(78, 124, 127, 25);
		btngrp.add(rdbtnPurchsae);
		panel.add(rdbtnPurchsae);
		
		rdbtnSale = new JRadioButton("SALE");
		rdbtnSale.setForeground(new Color(255, 255, 255));
		rdbtnSale.setFont(new Font("Lato", Font.BOLD, 18));
		rdbtnSale.setBackground(new Color(255, 140, 0));
		rdbtnSale.setBounds(283, 124, 88, 25);
		btngrp.add(rdbtnSale);
		panel.add(rdbtnSale);
		
		comboBoxName = new JComboBox<String>();
		comboBoxName.setBounds(130, 308, 260, 35);
		comboBoxName.setFont(new Font("Lato", Font.PLAIN, 16));
		comboBoxName.addActionListener(this);
		panel.add(comboBoxName);
		
		comboBoxProduct = new JComboBox<String>();
		comboBoxProduct.setBounds(130, 363, 260, 35);
		comboBoxProduct.setFont(new Font("Lato", Font.PLAIN, 16));
		comboBoxProduct.addActionListener(this);
		comboBoxProduct.setActionCommand("comboProduct");
		panel.add(comboBoxProduct);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setForeground(Color.WHITE);
		lblFrom.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblFrom.setBounds(38, 203, 45, 16);
		panel.add(lblFrom);
		
		PropertyChangeListener propertyListener = new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				dateListener();
			}
		};
		
		
		dateChooserFrom = new JDateChooser();
		dateChooserFrom.setDate(new Date());
		dateChooserFrom.setBounds(129, 194, 260, 35);
		dateChooserFrom.setFont(new Font("Lato", Font.PLAIN, 16));
		dateChooserFrom.addPropertyChangeListener(propertyListener);
		panel.add(dateChooserFrom);
		
		dateChooserTo = new JDateChooser();
		dateChooserTo.setDate(new Date());
		dateChooserTo.setBounds(130, 246, 260, 35);
		dateChooserTo.setFont(new Font("Lato", Font.PLAIN, 16));
		dateChooserTo.addPropertyChangeListener(propertyListener);
		panel.add(dateChooserTo);
		
		JLabel lblTp = new JLabel("To");
		lblTp.setForeground(Color.WHITE);
		lblTp.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblTp.setBounds(39, 255, 45, 16);
		panel.add(lblTp);
		
	
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("Lato", Font.PLAIN, 18));
		table.setColumnSelectionAllowed(false);
		scrollPane.setViewportView(table);
		
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableModel = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		};
		
		String[] colNames = {"Invoice ID","Entity","Date","Amount"};
		
		tableModel.setColumnIdentifiers(colNames);
		
		table.setModel(tableModel);
		//Setting table size
		
		table.setRowHeight(50);		
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(0).setMaxWidth(80);;

		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		
		rdbtnPurchsae.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				if(rdbtnPurchsae.isSelected()) {
					updateVendors();
					reset();
				}else {
					updateCustomers();
					reset();
				}
			}
			
		});
		updateVendors();
		updateProducts();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("Print")) {
			if(table.getRowCount() != 0) {
				
				StringBuilder str = new StringBuilder();
				
				str.append("<--------------------------------------------- REPORT --------------------------------------------->\n");
				
				Date dateFrom = dateChooserFrom.getDate();
				Date dateTo = dateChooserTo.getDate();
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, YYYY");
				str.append(String.format("\nFrom: %s", formatter.format(dateFrom)));
				str.append(String.format("\nTo: %s", formatter.format(dateTo)));
				
				
				str.append("\n\n---------------------------------------------------------------------------------------------------------------------\n");
				str.append("Invoice\tName\t\tDate\t\tAmount\n");
				str.append("  No");
				str.append("\n---------------------------------------------------------------------------------------------------------------------\n");
				
				double total = 0;
				for(int i = 0;i<table.getRowCount();i++) {
					
					int invoiceID = (int) table.getValueAt(i, 0);
					String name = (String) table.getValueAt(i, 1);
					String Date = (String) table.getValueAt(i, 2);
					double Amount = (double) table.getValueAt(i, 3);
					
					str.append(String.format("\n  %d\t%s\t\t%s\t\t%.2f",invoiceID,name,Date,Amount));
					total += Amount;
				}
				
				str.append("\n---------------------------------------------------------------------------------------------------------------------\n");
				str.append(String.format("\n   \t\t\t\t  Total: %.2f",total));
				
				JTextArea area = new JTextArea();
				area.append(str.toString());
				try {
					area.print();
					//Resetting the screen state
					reset();
					rdbtnPurchsae.setSelected(true);
					refreshTable(App.purchaseInvoices);
					
				} catch (PrinterException exception) {
					JOptionPane.showMessageDialog(null, "Printer Error!!!");
				}
				
				
			}else {
				JOptionPane.showMessageDialog(null, "No Data To Print!");
			}	
		
		
			
		}else if(command.equals("Clear")) {
			reset();
			
		}else if(command.equals("comboVendors")) {
			Vendor vendor; 
			if(comboBoxName.getSelectedIndex() != 0) {
				int index = comboBoxName.getSelectedIndex(); 
				vendor = App.vendors.get(index-1);
				
				ArrayList<Invoice> list = new ArrayList<>();
				for(Invoice i : App.purchaseInvoices) {
					if(i.getVendor() == vendor) {
						list.add(i);
					}
				}
				
				refreshTable(list);
				
			}else {
				refreshTable(App.purchaseInvoices);
			}
			
		}else if(command.equals("comboCustomers")) {
			
			Customer customer; 
			if(comboBoxName.getSelectedIndex() != 0) {
				int index = comboBoxName.getSelectedIndex(); 
				customer = App.customers.get(index-1);
				
				ArrayList<Invoice> list = new ArrayList<>();
				for(Invoice i : App.saleInvoices) {
					if(i.getCustomer() == customer) {
						list.add(i);
					}
				}
				
				refreshTable(list);
				
			}else 
				refreshTable(App.saleInvoices);
			
			
		}else if(command.equals("comboProduct")) {
			
			Product product; 
			if(comboBoxProduct.getSelectedIndex() != 0) {
				int index = comboBoxProduct.getSelectedIndex(); 
				product = App.products.get(index-1);
				
				ArrayList<Invoice> list = new ArrayList<>();
				
				if(rdbtnPurchsae.isSelected()) {
					for(Invoice i : App.purchaseInvoices) {
						ArrayList<InvoiceItem> items = i.getInvoiceData();
						for(InvoiceItem item : items) {
							if(item.getProduct() == product) {
								list.add(i);
								break;
							}
						}
					}
				}else {
					for(Invoice i : App.saleInvoices) {
						ArrayList<InvoiceItem> items = i.getInvoiceData();
						for(InvoiceItem item : items) {
							if(item.getProduct() == product) {
								list.add(i);
								break;
							}
						}
					}
				}
				
				refreshTable(list);
				
			}else {
				if(rdbtnPurchsae.isSelected()) 
						refreshTable(App.purchaseInvoices);
					else 
						refreshTable(App.saleInvoices);	
			}

			
			
		}else if(command.equals("date")) {
			dateListener();
			
		}
		
	}
	
	public <T extends Invoice> void refreshTable(ArrayList<T> data) {

		tableModel.setRowCount(0);
		
		for(T i : data) {
			
			int id = i.getID();
			String name = i.getName();
			Date date = i.getDate();
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, YYYY");
			double total = i.getTotal();
			
			tableModel.addRow(new Object[] {id,name,formatter.format(date),total});
		}
		
	}
	
	
	private void dateListener() {
		Date dateFrom = dateChooserFrom.getDate();
		Date dateTo = dateChooserTo.getDate();
		
		ArrayList<Invoice> list = new ArrayList<>();
		
		
		for(Invoice i : App.purchaseInvoices) {
			if((i.getDate().compareTo(dateFrom) > 0 && i.getDate().compareTo(dateTo) < 0) || i.getDate().compareTo(dateTo) == 0) {
				list.add(i);
			}
		}
		refreshTable(list);
	}
	
	
	private void updateVendors() {
		comboBoxName.setActionCommand("comboVendors");
		lblName.setText("Vendor");
		refreshTable(App.purchaseInvoices);
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Vendors");
		for(Vendor v: App.vendors) {
			model.addElement(v.getName());
		}
		comboBoxName.setModel(model);
		if(App.vendors.size()<1)
			comboBoxName.setEnabled(false);
		else
			comboBoxName.setEnabled(true);
		
	}
	
	private void updateCustomers() {
		comboBoxName.setActionCommand("comboCustomers");
		lblName.setText("Customer");
		refreshTable(App.saleInvoices);
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Customer");
		for(Customer p: App.customers) {
			model.addElement(p.getName());
		}
		comboBoxName.setModel(model);
		if(App.customers.size()<1)
			comboBoxName.setEnabled(false);
		else
			comboBoxName.setEnabled(true);
		
	}
	
	private void updateProducts() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Products");
		for(Product p: App.products) {
			model.addElement(p.getName());
		}
		comboBoxProduct.setModel(model);
		if(App.products.size()<1)
			comboBoxProduct.setEnabled(false);
		else
			comboBoxProduct.setEnabled(true);
		
	}
	
	private void reset() {
		dateChooserFrom.setDate(new Date());
		dateChooserTo.setDate(new Date());
		comboBoxName.setSelectedIndex(0);
		comboBoxProduct.setSelectedIndex(0);
	}	
	}

