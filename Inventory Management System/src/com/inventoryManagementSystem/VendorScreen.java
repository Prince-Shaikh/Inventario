package com.inventoryManagementSystem;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class VendorScreen extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JTextField textFieldPhone;
	private JTextArea textAreaAddress;
	private JTable table;
	private JTextField textFieldSearch;
	
	/**
	 * Create the frame.
	 */
	public VendorScreen() {
		setTitle("Vendor");
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
		
		JLabel lblVendors = new JLabel("Vendors");
		lblVendors.setBounds(158, 58, 133, 31);
		lblVendors.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblVendors.setForeground(Color.WHITE);
		lblVendors.setFont(new Font("Montserrat", Font.BOLD, 30));
		panel.add(lblVendors);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setToolTipText("Search By Name");
		textFieldSearch.setFont(new Font("Lato", Font.PLAIN, 16));
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(126, 122, 165, 34);
		panel.add(textFieldSearch);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblSearch.setBounds(38, 122, 76, 16);
		panel.add(lblSearch);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblId.setBounds(38, 185, 56, 16);
		panel.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		textFieldId.setFont(new Font("Lato", Font.PLAIN, 16));
		textFieldId.setBounds(126, 176, 116, 34);
		panel.add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblName.setBounds(38, 241, 56, 16);
		panel.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Lato", Font.PLAIN, 16));
		textFieldName.setBounds(126, 232, 260, 34);
		textFieldName.requestFocusInWindow();
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblPhone.setBounds(38, 296, 56, 16);
		panel.add(lblPhone);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Lato", Font.PLAIN, 16));
		textFieldPhone.setBounds(126, 287, 260, 34);
		panel.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblAddress.setBounds(38, 348, 76, 16);
		panel.add(lblAddress);
		
		textAreaAddress = new JTextArea();
		textAreaAddress.setFont(new Font("Lato", Font.PLAIN, 16));
		textAreaAddress.setBounds(126, 348, 260, 168);
		panel.add(textAreaAddress);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(this);
		btnNew.setActionCommand("New");
		btnNew.setBackground(new Color(70, 130, 180));
		btnNew.setForeground(SystemColor.text);
		btnNew.setBounds(49, 557, 97, 50);
		panel.add(btnNew);
		
		JButton btnEdit = new JButton("Update");
		btnEdit.setActionCommand("Update");
		btnEdit.addActionListener(this);
		btnEdit.setBackground(new Color(70, 130, 180));
		btnEdit.setForeground(SystemColor.text);
		btnEdit.setBounds(172, 557, 97, 50);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setActionCommand("Delete");
		btnDelete.addActionListener(this);
		btnDelete.setBackground(new Color(70, 130, 180));
		btnDelete.setForeground(SystemColor.text);
		btnDelete.setBounds(289, 557, 97, 50);
		panel.add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setToolTipText("Search By Name");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(70, 130, 180));
		btnSearch.setActionCommand("New");
		btnSearch.setBounds(289, 122, 97, 34);
		btnSearch.addActionListener(this);
		btnSearch.setActionCommand("Search");
		panel.add(btnSearch);
		
		JLabel lblbyName = new JLabel("(By NAME)");
		lblbyName.setForeground(Color.WHITE);
		lblbyName.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lblbyName.setBounds(38, 140, 76, 16);
		panel.add(lblbyName);
		
	
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("Lato", Font.PLAIN, 18));
		table.setColumnSelectionAllowed(false);
		scrollPane.setViewportView(table);
		
		addWindowListener(new WindowAdapter() {
		      public void windowOpened(WindowEvent e) {
		        textFieldName.requestFocus();
		      }
		    });
		
		
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				try {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					int id = (int) model.getValueAt(table.getSelectedRow(), 0);
					
					fillData(id);
				}catch(ArrayIndexOutOfBoundsException ex) {
//					System.out.println("Exception was Cought!");
				}
				
			}
		});
		
		refreshTable(App.vendors);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("New")) {
			NewVendorDialog screen = new NewVendorDialog();
			WindowListener exitListener = new WindowAdapter() {
	            @Override
	            public void windowClosed(WindowEvent e) {
	                refreshTable(App.vendors);
	            }
	        };
	        screen.addWindowListener(exitListener);
			
		}else if(command.equals("Update")) {
			
			try {
				int id = Integer.parseInt(textFieldId.getText());
				int index = searchVendorById(id);
				
				String name,address,phone;
				
				name = textFieldName.getText();
				phone = textFieldPhone.getText();
				address = textAreaAddress.getText();
				
				if(index != -1) { 
					App.vendors.get(index).setName(name);
					App.vendors.get(index).setPhoneNumber(phone);
					App.vendors.get(index).setAddress(address);
					refreshTable(App.vendors);
					emptyFields();
				}
			}catch(NumberFormatException exception) {
				
			}
			
		}else if(command.equals("Delete")) {
			
			try {
				int id = Integer.parseInt(textFieldId.getText());
				int index = searchVendorById(id);
				if(index != -1) {
					App.vendors.remove(index);
					JOptionPane.showMessageDialog(null, "Vendor Details Deleted!");
					refreshTable(App.vendors);
					emptyFields();
				}
			}catch(NumberFormatException exception) {
				
			}
		}else if(command.equals("Search")) {
			String searchStr = ""; 
			searchStr = textFieldSearch.getText();
			
			if(searchStr.length() != 0) {
				ArrayList<Vendor> vendors = new ArrayList<Vendor>();
				for(Vendor v : App.vendors) {
					if(v.getName().toUpperCase().contains(searchStr.toUpperCase())) {
						vendors.add(v);
					}
				}
				refreshTable(vendors);
			}else {
				refreshTable(App.vendors);
			}
		}
		
	}
	
	public void refreshTable(ArrayList<Vendor> data) {
		DefaultTableModel model = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		};
		
		String[] colNames = {"ID","Name","Phone","Address"};
		
		model.setColumnIdentifiers(colNames);
		model.setRowCount(0);
		
		for(Vendor vendor : data) {
			model.addRow(new Object[] {vendor.getID(),vendor.getName(),vendor.getPhoneNumber(),vendor.getAddress()});
		}
		
		table.setModel(model);
		table.setRowHeight(50);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMaxWidth(50);;

		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setMaxWidth(200);
		
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		
	}
	private void emptyFields() {
		textFieldId.setText("");
		textFieldName.setText("");
		textFieldPhone.setText("");
		textFieldSearch.setText("");
		textAreaAddress.setText("");
	}

	private int searchVendorById(int id) {
		
		for(Vendor vendor : App.vendors) {
			if(vendor.getID() == id) {
				return App.vendors.indexOf(vendor);
			}
		}
		return -1;
	}
	private void fillData(int id) {
		int index = searchVendorById(id);
		try {
		textFieldId.setText(App.vendors.get(index).getID()+"");
		textFieldName.setText(App.vendors.get(index).getName());
		textFieldPhone.setText(App.vendors.get(index).getPhoneNumber());
		textAreaAddress.setText(App.vendors.get(index).getAddress());
		}catch(ArrayIndexOutOfBoundsException ex) {
//			System.out.println("Array OUT OF BOund");
		}
		
	}
}
