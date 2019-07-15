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

public class NewProductDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldPrice;
	private JTextField textFieldName;
	private JTextField textFieldID;
	private JTextArea textAreaDiscription;

	/**
	 * Create the dialog.
	 */
	public NewProductDialog() {
		setTitle("New Product");
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 450, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 140, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewCustomer = new JLabel("New Product");
			lblNewCustomer.setForeground(Color.WHITE);
			lblNewCustomer.setFont(new Font("Montserrat", Font.BOLD, 30));
			lblNewCustomer.setBounds(109, 23, 214, 31);
			contentPanel.add(lblNewCustomer);
		}
		{
			textAreaDiscription = new JTextArea();
			textAreaDiscription.setFont(new Font("Lato", Font.PLAIN, 16));
			textAreaDiscription.setBounds(138, 262, 260, 100);
			contentPanel.add(textAreaDiscription);
		}
		{
			JLabel lblDiscription = new JLabel("Discription");
			lblDiscription.setForeground(Color.WHITE);
			lblDiscription.setFont(new Font("Montserrat", Font.BOLD, 16));
			lblDiscription.setBounds(34, 262, 94, 16);
			contentPanel.add(lblDiscription);
		}
		{
			JLabel lblPrice = new JLabel("Price");
			lblPrice.setForeground(Color.WHITE);
			lblPrice.setFont(new Font("Montserrat", Font.BOLD, 16));
			lblPrice.setBounds(53, 210, 56, 16);
			contentPanel.add(lblPrice);
		}
		{
			textFieldPrice = new JTextField();
			textFieldPrice.setFont(new Font("Lato", Font.PLAIN, 16));
			textFieldPrice.setColumns(10);
			textFieldPrice.setBounds(138, 201, 260, 34);
			contentPanel.add(textFieldPrice);
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
			label.setBounds(53, 155, 56, 16);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("ID");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Montserrat", Font.BOLD, 16));
			label.setBounds(68, 99, 26, 16);
			
			contentPanel.add(label);
		}
		{
			textFieldID = new JTextField();
			textFieldID.setEditable(false);
			textFieldID.setFont(new Font("Lato", Font.PLAIN, 16));
			textFieldID.setColumns(10);
			textFieldID.setBounds(138, 90, 116, 34);
			textFieldID.setText("" + (Product.getidCount()+1));
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
						String name = null,discription = null;
						double price = 0;
						try {
							name = textFieldName.getText();
							discription  = textAreaDiscription.getText();
							try {
								price = Double.parseDouble(textFieldPrice.getText());
							}catch(NumberFormatException exception) {
								if(textFieldPrice.getText().length() == 0) {
									JOptionPane.showMessageDialog(null, "Product Must Have a Price!!");
								}else {
									JOptionPane.showMessageDialog(null, "Price Must be a Number!!");
								}
								return;
							}
							
						}catch(NullPointerException exception) {
							return;
						}
						
						if(name.length()!= 0) {
							App.products.add(new Product(name,discription,price));
						}else {
							JOptionPane.showMessageDialog(null, "Name is Required!");
							return;
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
