package com.inventoryManagementSystem;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
//import net.miginfocom.swing.MigLayout;
//import net.sourceforge.jdatepicker.DateModel;
//import net.sourceforge.jdatepicker.JDatePicker;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import net.miginfocom.swing.MigLayout;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class SaleScreen extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldQTY;
	private JButton btnSave;
	private JTable table;
	private JComboBox<String> comboBoxCustomer;
	private JComboBox<String> comboBoxProduct;
	private DefaultTableModel tableModel;
	private JDateChooser dateChooser;
	private JTextField textFieldTotal;
	private JTextField textFieldStock;

	/**
	 * Create the frame.
	 */
	public SaleScreen() {
		setTitle("Sales Invoice");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
//		panel.setPreferredSize(new Dimension(1280,250));
		panel.setMaximumSize(new Dimension(1280,500));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[][830.00,grow][59.00][pref:200:300,grow,left][:600.00:700px,grow,right]", "[55.00][40.00][10.00][40.00][10.00][40.00][15.00]"));
		
		JLabel lblPurchaseInvoice = new JLabel("SALES INVOICE");
		lblPurchaseInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPurchaseInvoice.setForeground(new Color(255, 255, 255));
		lblPurchaseInvoice.setFont(new Font("Montserrat", Font.BOLD, 30));
		panel.add(lblPurchaseInvoice, "cell 0 0 5 1,alignx center,aligny center");
		
		JLabel lblID = new JLabel("Invoice No");
		lblID.setForeground(new Color(255, 255, 255));
		lblID.setFont(new Font("Montserrat", Font.BOLD, 16));
		panel.add(lblID, "cell 0 1,alignx center");
		
		textFieldID = new JTextField();
		textFieldID.setHorizontalAlignment(SwingConstants.TRAILING);
		textFieldID.setEditable(false);
		textFieldID.setFont(new Font("Lato", Font.PLAIN, 16));
		panel.add(textFieldID, "flowx,cell 1 1,grow");
		textFieldID.setColumns(10);
		
		JLabel lblVendor = new JLabel("Customer");
		lblVendor.setForeground(new Color(255, 255, 255));
		lblVendor.setFont(new Font("Montserrat", Font.BOLD, 16));
		panel.add(lblVendor, "cell 0 3,alignx center");
				
		comboBoxCustomer = new JComboBox<String>();
		comboBoxCustomer.setFont(new Font("Lato", Font.PLAIN, 16));
		panel.add(comboBoxCustomer, "cell 1 3,grow");
				
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setForeground(new Color(255, 255, 255));
		lblProduct.setFont(new Font("Montserrat", Font.BOLD, 16));
		panel.add(lblProduct, "cell 0 5,alignx center");
				
		comboBoxProduct = new JComboBox<String>();
		comboBoxProduct.setActionCommand("ProductCombo");
		comboBoxProduct.addActionListener(this);
		comboBoxProduct.setFont(new Font("Lato", Font.PLAIN, 16));
		panel.add(comboBoxProduct, "cell 1 5,grow");
				
		JLabel lblQty = new JLabel("QTY");
		lblQty.setForeground(new Color(255, 255, 255));
		lblQty.setFont(new Font("Montserrat", Font.BOLD, 16));
		panel.add(lblQty, "flowx,cell 3 5,alignx trailing");
				
		textFieldQTY = new JTextField();
		textFieldQTY.setFont(new Font("Lato", Font.PLAIN, 16));
		panel.add(textFieldQTY, "cell 3 5,grow");
		textFieldQTY.setColumns(10);
				
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBackground(new Color(70, 130, 180));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setActionCommand("ADD");
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("Montserrat", Font.BOLD, 16));
		panel.add(btnAdd, "cell 3 5,alignx left,growy");
				
		JLabel lblDate_1 = new JLabel("Date");
		lblDate_1.setForeground(new Color(255, 255, 255));
		lblDate_1.setFont(new Font("Montserrat", Font.BOLD, 16));
		panel.add(lblDate_1, "cell 1 1,alignx center");
						
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setBackground(new Color(70, 130, 180));
		dateChooser.getCalendarButton().setFont(new Font("Lato", Font.PLAIN, 26));
		dateChooser.setFont(new Font("Lato", Font.PLAIN, 16));
		panel.add(dateChooser, "cell 1 1,grow");
				
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
				
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
				
		table = new JTable();
		table.setFont(new Font("Lato", Font.PLAIN, 20));
		scrollPane.setViewportView(table);

		//Initializing screen data
		updateCustomers();
		updateProducts();
		dateChooser.setDate(new Date());
		textFieldID.setText(App.saleInvoices.size()+1+"");
		
		JLabel lblInStock = new JLabel("IN STOCK");
		lblInStock.setForeground(Color.WHITE);
		lblInStock.setFont(new Font("Montserrat", Font.BOLD, 16));
		panel.add(lblInStock, "flowx,cell 4 5");
		
		textFieldStock = new JTextField();
		textFieldStock.setEditable(false);
		textFieldStock.setFont(new Font("Lato", Font.PLAIN, 16));
		textFieldStock.setColumns(10);
		panel.add(textFieldStock, "cell 4 5,alignx trailing,growy");
		
		
		tableModel = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		};
		
		String[] colNames = {"S.no","Product Name","Price","Quantity","Total Price"};
		
		tableModel.setColumnIdentifiers(colNames);
		tableModel.setRowCount(0);
		
		table.setModel(tableModel);
		
		table.setRowHeight(50);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(1280, 60));
		panel_2.setBackground(new Color(255, 140, 0));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new MigLayout("", "[1100][1240.00px][1000][1200.00]", "[:50:50]"));
		
		JLabel lblTotal = new JLabel("TOTAL: ");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Montserrat", Font.BOLD, 19));
		panel_2.add(lblTotal, "flowx,cell 0 0,alignx leading,aligny center");
		
		btnSave = new JButton("SAVE");
		panel_2.add(btnSave, "flowx,cell 3 0,grow");
		btnSave.setBackground(new Color(70, 130, 180));
		btnSave.setForeground(Color.WHITE);
		btnSave.setActionCommand("Save");
		btnSave.addActionListener(this);
		btnSave.setFont(new Font("Montserrat", Font.BOLD, 16));
		
		JButton btnPrint = new JButton("SAVE & PRINT");
		panel_2.add(btnPrint, "cell 3 0,grow");
		btnPrint.setBackground(new Color(70, 130, 180));
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setActionCommand("Print");
		btnPrint.addActionListener(this);
		btnPrint.setFont(new Font("Montserrat", Font.BOLD, 16));
		
		textFieldTotal = new JTextField();
		textFieldTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		textFieldTotal.setEditable(false);
		textFieldTotal.setFont(new Font("Lato", Font.PLAIN, 16));
		textFieldTotal.setColumns(10);
		textFieldTotal.setText("0");
		panel_2.add(textFieldTotal, "cell 0 0,grow");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMaxWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setMaxWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setMaxWidth(150);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if(command.equals("ADD")) {
			int index = comboBoxProduct.getSelectedIndex();
			if(index != 0) {
				Product product = App.products.get(index-1);
				int num = tableModel.getRowCount() + 1;
				double price = product.getPrice();
				
				int qty;
				try {
					qty = Integer.parseInt(textFieldQTY.getText());
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Qty Must Be A NUMBER!");
					return;
				}
				
				if(qty<=0) {
					JOptionPane.showMessageDialog(null, "Quantity Can not be 0 or Negative!");
					textFieldQTY.setText("");
					return;
				}
				
				int inStock = Integer.parseInt(textFieldStock.getText());
				if(inStock == 0) {
					
					JOptionPane.showMessageDialog(null, "OUT OF STOCK!!");
				
				}else if(qty<=inStock) {
					
					DecimalFormat formatter = new DecimalFormat("#0.00");
					
					tableModel.addRow(new Object[] {num, product.getName(), price, qty, formatter.format(price*qty)});
					
					double total = Double.parseDouble(textFieldTotal.getText()) + (price*qty);
					textFieldTotal.setText(String.format("%.2f",total));
					
					textFieldQTY.setText("");
					comboBoxProduct.setSelectedIndex(0);
				}else {
					JOptionPane.showMessageDialog(null, "Canot sell more than in Stock!!");
				}
				
				
			}
			
		}else if(command.equals("Save")) {
			
			if(comboBoxCustomer.getSelectedIndex() != 0) {
				if(table.getRowCount() != 0) {
					
					saveInvoice();
					
					tableModel.setRowCount(0);
					comboBoxCustomer.setSelectedIndex(0);
					
					
					int newID = Integer.parseInt(textFieldID.getText()) + 1;
					textFieldID.setText("" + newID);
					
					textFieldTotal.setText("0");
					
				}else {
					JOptionPane.showMessageDialog(null, "Enter Produts first!");
				}	
				
			}else {
				JOptionPane.showMessageDialog(null, "Please Select a Customer first!");
			}
			
		}else if(command.equals("Print")) {			//WHen Print Button Is Pressed
			
			if(comboBoxCustomer.getSelectedIndex() != 0) {
				if(table.getRowCount() != 0) {
					//Getting invoice id
					
					int id = Integer.parseInt(textFieldID.getText())-1;
					saveInvoice();
					StringBuilder str = new StringBuilder();
					
					str.append("<------------------------------------------- SALES INVOICE ------------------------------------------->\n");
					str.append(String.format("\nCustomer: %s", comboBoxCustomer.getSelectedItem()));
					
					Date date = dateChooser.getDate();
					SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, YYYY");
					str.append(String.format("\nDate:     %s", formatter.format(date)));
					
					str.append("\n\n---------------------------------------------------------------------------------------------------------------------\n");
					str.append("S.No\tProducts\t\tPrice\tQuantity\tTotal");
					str.append("\n---------------------------------------------------------------------------------------------------------------------\n");
					
					ArrayList<InvoiceItem> items = App.saleInvoices.get(id).getInvoiceData();
					for(InvoiceItem i : items) {
						int sno = i.getSno();
						String product = i.getProduct().getName();
						double price = i.getPrice();
						int qty = i.getQuantity();
						double total = i.getTotal();
						
						str.append(String.format("\n%d\t%s\t\t%.2f\t%d\t%.2f",sno,product,price,qty,total ));
					}
					
					JTextArea area = new JTextArea();
					area.append(str.toString());
					try {
						area.print();
						//Resetting the screen state
						tableModel.setRowCount(0);
						comboBoxCustomer.setSelectedIndex(0);
						textFieldID.setText(textFieldID.getText()+1+"");
						textFieldTotal.setText("0");
						
					} catch (PrinterException e) {
						JOptionPane.showMessageDialog(null, "Printer Error!!!");
					}
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Enter Produts first!");
				}	
				
			}else {
				JOptionPane.showMessageDialog(null, "Please Select a Vendor first!");
			}
							
		}else if(command.equals("ProductCombo")) {
			String item = (String) comboBoxProduct.getSelectedItem();
			if(item!="Products") {
				int p = searchProductByName(item);
				textFieldStock.setText(App.products.get(p).getQuantity()+"");
			}
		}
			
	}
		
	
	/**
	 * Function to save invoice in the ArrayList APP.saleInvoices
	 */
	private void saveInvoice() {
		ArrayList<InvoiceItem> invoiceItems = new ArrayList<>();
		
		
		for(int i = 0; i<table.getRowCount();i++) {
			int sno = (int) tableModel.getValueAt(i, 0);
			
			String productName = (String) tableModel.getValueAt(i, 1);
			Product p = App.products.get(searchProductByName(productName));
			
			double price = p.getPrice();
			
			int qty = (int) tableModel.getValueAt(i, 3);
			
			double total = price*qty;
			
			p.setQuantity(p.getQuantity() - qty);
			invoiceItems.add(new InvoiceItem(sno, p, qty, price, total));
			
		}
		int id = Integer.parseInt(textFieldID.getText());
		Customer c = App.customers.get(comboBoxCustomer.getSelectedIndex()-1);
		
		App.saleInvoices.add(new Invoice(id, dateChooser.getDate(), c , invoiceItems));
	}
	
	
	private int searchProductByName(String name) {
		for(int i = 0; i<comboBoxProduct.getItemCount();i++) {
			if(comboBoxProduct.getItemAt(i).equals(name)) {
				return i-1;
			}
		}
		
		return -1;
		
	}
	
	private void updateCustomers() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Customers");
		for(Customer c: App.customers) {
			model.addElement(c.getName());
		}
		comboBoxCustomer.setModel(model);
		if(App.customers.size()<1)
			comboBoxCustomer.setEnabled(false);
		else
			comboBoxCustomer.setEnabled(true);
		
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
}
