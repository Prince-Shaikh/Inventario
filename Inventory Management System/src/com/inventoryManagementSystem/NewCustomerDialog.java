package com.inventoryManagementSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class NewCustomerDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldPhone;
	private JTextField textFieldName;
	private JTextField textFieldID;
	private JTextArea textAreaAddress;

	/**
	 * Create the dialog.
	 */
	public NewCustomerDialog() {
		setTitle("New Customer");
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 450, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 140, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewCustomer = new JLabel("New Customer");
			lblNewCustomer.setForeground(Color.WHITE);
			lblNewCustomer.setFont(new Font("Montserrat", Font.BOLD, 30));
			lblNewCustomer.setBounds(94, 23, 243, 31);
			contentPanel.add(lblNewCustomer);
		}
		{
			textAreaAddress = new JTextArea();
			textAreaAddress.setFont(new Font("Lato", Font.PLAIN, 16));
			textAreaAddress.setBounds(138, 262, 260, 100);
			contentPanel.add(textAreaAddress);
		}
		{
			JLabel label = new JLabel("Address");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Montserrat", Font.BOLD, 16));
			label.setBounds(50, 262, 76, 16);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Phone");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Montserrat", Font.BOLD, 16));
			label.setBounds(50, 210, 56, 16);
			contentPanel.add(label);
		}
		{
			textFieldPhone = new JTextField();
			textFieldPhone.setFont(new Font("Lato", Font.PLAIN, 16));
			textFieldPhone.setColumns(10);
			textFieldPhone.setBounds(138, 201, 260, 34);
			contentPanel.add(textFieldPhone);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setFont(new Font("Lato", Font.PLAIN, 16));
			textFieldName.setColumns(10);
			textFieldName.setBounds(138, 146, 260, 34);
			contentPanel.add(textFieldName);
		}
		{
			JLabel label = new JLabel("Name");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Montserrat", Font.BOLD, 16));
			label.setBounds(50, 155, 56, 16);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("ID");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Montserrat", Font.BOLD, 16));
			label.setBounds(50, 99, 56, 16);
			
			contentPanel.add(label);
		}
		{
			textFieldID = new JTextField();
			textFieldID.setEditable(false);
			textFieldID.setFont(new Font("Lato", Font.PLAIN, 16));
			textFieldID.setColumns(10);
			textFieldID.setBounds(138, 90, 116, 34);
			textFieldID.setText("" + (Customer.getidCount()+1));
			contentPanel.add(textFieldID);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 140, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.setBackground(new Color(70, 130, 180));
				okButton.setForeground(Color.WHITE);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name = null,address = null;
						String phoneNumber = null;
						try {
							name = textFieldName.getText();
							address  = textAreaAddress.getText();
							phoneNumber = textFieldPhone.getText();
						}catch(NullPointerException exception) {
							return;
						}
						
						if(name.length()!= 0) {
							App.customers.add(new Customer(name,address,phoneNumber));
						}else {
							JOptionPane.showMessageDialog(null, "Name is Required!");
						}
						dispose();
					}
				});
				okButton.setFont(new Font("Montserrat", Font.PLAIN, 20));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(70, 130, 180));
				cancelButton.setForeground(Color.WHITE);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Montserrat", Font.PLAIN, 20));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	

}
