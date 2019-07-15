//package com.inventoryManagementSystem;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import java.awt.Toolkit;
//import java.util.concurrent.TimeUnit;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import javax.swing.ImageIcon;
//import javax.swing.SwingConstants;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Font;
//import javax.swing.JProgressBar;
//
//public class LoginScreen extends JFrame {
//
//	private JPanel contentPane;
//	private JProgressBar progressBar;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginScreen frame = new LoginScreen();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public LoginScreen() {
////		setVisible(true);
//		setResizable(false);
//		setUndecorated(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1150, 600);
//		setLocationRelativeTo(null);
//		contentPane = new JPanel();
//		contentPane.setBackground(new Color(70, 130, 180));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		
//		JLabel label = new JLabel("");
//		label.setBounds(161, 211, 827, 285);
//		label.setHorizontalAlignment(SwingConstants.CENTER);
//		label.setIcon(new ImageIcon(LoginScreen.class.getResource("/com/inventoryManagementSystem/IMS.png")));
//		contentPane.add(label);
//		
//		JLabel lblInventario = new JLabel("Inventario");
//		lblInventario.setForeground(Color.WHITE);
//		lblInventario.setFont(new Font("Segoe Script", Font.BOLD, 40));
//		lblInventario.setBounds(464, 154, 228, 56);
//		contentPane.add(lblInventario);
//		
//		progressBar = new JProgressBar();
//		progressBar.setForeground(new Color(255, 140, 0));
//		progressBar.setBounds(-11, 588, 1177, 14);
//		contentPane.add(progressBar);
//		
//		JLabel lblAInventoryManagement = new JLabel("A INVENTORY MANAGEMENT APPLICATION");
//		lblAInventoryManagement.setHorizontalAlignment(SwingConstants.CENTER);
//		lblAInventoryManagement.setForeground(Color.WHITE);
//		lblAInventoryManagement.setFont(new Font("Roboto", Font.BOLD, 30));
//		lblAInventoryManagement.setBounds(244, 476, 662, 49);
//		contentPane.add(lblAInventoryManagement);
//		
//		JLabel label_1 = new JLabel("");
//		label_1.setIcon(new ImageIcon(LoginScreen.class.getResource("/com/inventoryManagementSystem/logoSmall.png")));
//		label_1.setForeground(Color.WHITE);
//		label_1.setFont(new Font("Segoe Script", Font.BOLD, 30));
//		label_1.setBounds(525, 34, 100, 122);
//		contentPane.add(label_1);
//		
//		runProgressBar();
//		
////		int i=0;//Creating an integer variable and intializing it to 0
////		 
////        while( i<=100)
////        {
////            try{
////                //Pausing execution for 50 milliseconds
////                progressBar.setValue(i);//Setting value of Progress Bar
////                TimeUnit.SECONDS.sleep(4);;
//////                Thread.sleep(500);
//////                message.setText("LOADING "+Integer.toString(i)+"%");//Setting text of the message JLabel
////                i++;
////                if(i==100) {
////                	new App().setVisible(true);
////                    this.dispose();
////                    
////                }
////            }catch(Exception e){
////                e.printStackTrace();
////            }
//// 
//// 
//// 
////        }
////		
//		
//		
//		
//	}
//	
//	private void runProgressBar() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					
//					int i=0;//Creating an integer variable and intializing it to 0
//					 
//			        while( i<=100)
//			        {
//			                //Pausing execution for 50 milliseconds
//			                progressBar.setValue(i);//Setting value of Progress Bar
////			                TimeUnit.SECONDS.sleep(4);;
////			                Thread.sleep(500);
//			                Thread.currentThread().sleep(500);
//			                
//			                i++;
//			                if(i==100) {
//			                	new App().setVisible(true);
////			                    this.dispose();
//			                    
//			                }
//			        }
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	
//	
//	
//}
