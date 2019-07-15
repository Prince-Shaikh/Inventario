package com.inventoryManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class App extends JFrame implements ActionListener {

	//ArrayLists 
	protected static ArrayList<Vendor> vendors = new ArrayList<>();
	protected static ArrayList<Customer> customers = new ArrayList<>();
	protected static ArrayList<Product> products = new ArrayList<>();
	protected static ArrayList<Invoice> purchaseInvoices = new ArrayList<>();
	protected static ArrayList<Invoice> saleInvoices = new ArrayList<>();
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setTitle("Inventario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		this.setLocationRelativeTo(null);
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		setJMenuBar(menuBar);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmVendor = new JMenuItem("Vendors");
		mntmVendor.setActionCommand("Vendor");
		mntmVendor.addActionListener(this);
		mnView.add(mntmVendor);
		
		JMenuItem mntmCustomer = new JMenuItem("Customers");
		mntmCustomer.setActionCommand("Customer");
		mntmCustomer.addActionListener(this);
		mnView.add(mntmCustomer);
		
		JMenuItem mntmProducts = new JMenuItem("Products");
		mntmProducts.setActionCommand("Products");
		mntmProducts.addActionListener(this);
		mnView.add(mntmProducts);
		
		JMenu mnInvoices = new JMenu("Invoices");
		menuBar.add(mnInvoices);
		
		JMenuItem mntmPurchase = new JMenuItem("Purchase");
		mntmPurchase.setActionCommand("Purchase");
		mntmPurchase.addActionListener(this);
		mnInvoices.add(mntmPurchase);
		
		JMenuItem mntmSales = new JMenuItem("Sales");
		mntmSales.setActionCommand("Sale");
		mntmSales.addActionListener(this);
		mnInvoices.add(mntmSales);
		
		JMenu mnInventory = new JMenu("Inventory");
		menuBar.add(mnInventory);
		
		JMenuItem mntmViewInventory = new JMenuItem("View Inventory");
		mntmViewInventory.setActionCommand("Inventory");
		mntmViewInventory.addActionListener(this);
		mnInventory.add(mntmViewInventory);
		
		JMenu mnReports = new JMenu("Reports");
		menuBar.add(mnReports);
		
		JMenuItem mntmGenerateReports = new JMenuItem("Generate Reports");
		mntmGenerateReports.setActionCommand("Reports");
		mntmGenerateReports.addActionListener(this);
		mnReports.add(mntmGenerateReports);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 140, 0));
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(App.class.getResource("/com/inventoryManagementSystem/LogoMain.png")));
		panel_1.add(label, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 3, 10, 10));
		
		JButton btnVendor = new JButton("Vendors");
		btnVendor.setActionCommand("Vendor");
		btnVendor.addActionListener(this);
		btnVendor.setForeground(new Color(255, 255, 255));
		btnVendor.setBackground(new Color(70, 130, 180));
		btnVendor.setFont(new Font("Montserrat Alternates Medium", Font.BOLD, 22));
		panel.add(btnVendor);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.setActionCommand("Products");
		btnProducts.addActionListener(this);
		btnProducts.setForeground(new Color(255, 255, 255));
		btnProducts.setBackground(new Color(70, 130, 180));
		btnProducts.setFont(new Font("Montserrat Alternates Medium", Font.BOLD, 22));
		panel.add(btnProducts);
		
		JButton btnCustomer = new JButton("Customers");
		btnCustomer.setActionCommand("Customer");
		btnCustomer.addActionListener(this);
		btnCustomer.setForeground(new Color(255, 255, 255));
		btnCustomer.setBackground(new Color(70, 130, 180));
		btnCustomer.setFont(new Font("Montserrat Alternates Medium", Font.BOLD, 22));
		panel.add(btnCustomer);
		
		JButton btnPurchaseInvoice = new JButton("Purchase Invoice");
		btnPurchaseInvoice.setActionCommand("Purchase");
		btnPurchaseInvoice.addActionListener(this);
		btnPurchaseInvoice.setForeground(new Color(255, 255, 255));
		btnPurchaseInvoice.setBackground(new Color(70, 130, 180));
		btnPurchaseInvoice.setFont(new Font("Montserrat Alternates Medium", Font.BOLD, 22));
		panel.add(btnPurchaseInvoice);
		
		JButton btnSalesInvoice = new JButton("Sales Invoice");
		btnSalesInvoice.setActionCommand("Sale");
		btnSalesInvoice.addActionListener(this);
		btnSalesInvoice.setForeground(new Color(255, 255, 255));
		btnSalesInvoice.setBackground(new Color(70, 130, 180));
		btnSalesInvoice.setFont(new Font("Montserrat Alternates Medium", Font.BOLD, 22));
		panel.add(btnSalesInvoice);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setActionCommand("Inventory");
		btnInventory.addActionListener(this);
		btnInventory.setForeground(new Color(255, 255, 255));
		btnInventory.setBackground(new Color(70, 130, 180));
		btnInventory.setFont(new Font("Montserrat Alternates Medium", Font.BOLD, 22));
		panel.add(btnInventory);
		
		
		addDummyData();
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		String command = action.getActionCommand();
		if(command.equals("Vendor")) {

			new VendorScreen().setVisible(true);
			
		}else if(command.equals("Products")) {
			
			new ProductScreen().setVisible(true);
			
		}else if(command.equals("Customer")) {
			
			new CustomerScreen().setVisible(true);
		
		}else if(command.equals("Purchase")) {
			
			new PurchaseScreen().setVisible(true);
			
		}else if(command.equals("Sale")) {
			
			new SaleScreen().setVisible(true);
			
		}else if(command.equals("Inventory")) {
			new InventoryScreen().setVisible(true);
		}else if(command.equals("Reports")) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new ReportsScreen().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			
			
			
			
//			new ReportsScreen().setVisible(true);
		}
		
	}
	private void addDummyData() {
		
//		vendors.add(new Vendor("Shaikh","asdsdas","03128383391"));
//		vendors.add(new Vendor("Ali","asdsdas","0315846647"));
//		vendors.add(new Vendor("Marzia","Addres, lfaske lla ","03338464479"));
//		vendors.add(new Vendor("Shaikh Moiz","Loca st, Barca","03114646845"));
//		
//		customers.add(new Customer("Shaikh","asdsdas","03281516555"));
//		customers.add(new Customer("Ali","Seniora, come estas","03115645645"));
//		customers.add(new Customer("Baki","asdsdas","03334582165"));
//		customers.add(new Customer("ShenZen Pvt. Ltd","House No. 254 \ngilberg st, Lahore","03325465482"));
//		
//		
//		products.add(new Product("Miilk","Fresh Milk product from Olpers",130));
//		products.add(new Product("Buscit","Chocolate BUscites", 20.54));
//		products.add(new Product("Flour","",1150));
//		products.add(new Product("Tang 500g Jar","Jar of 500g of Tang Powder",2000));
		
		customers.add(new Customer("Al-Shaikh super store","Sho#24 Street 8 jinnah town quetta","03128383391"));
		customers.add(new Customer("Altaf super market ","Shop#512 Madarsa Road quetta","03338464479"));
		customers.add(new Customer("Eijaz store ","Shop#122 jail Road quetta","03133243254"));
		customers.add(new Customer("Bhutto super store ","Shop234 jail Road quetta","03333265431"));
		customers.add(new Customer("Adnan market ","Shop#675 kasi Road quetta","03214667868"));
		customers.add(new Customer("Al-Shanseeb ","shop#543 kasi Road quetta","03353786497"));
		customers.add(new Customer("Sharif super market ","shop#322 prince Road quetta","03333376876"));
		customers.add(new Customer("Al-Naseeb Shopping center","shop#232 prince Road quetta","03098675342"));
		
		
		vendors.add(new Vendor("hammad","House#24 Street 8 jinnah town quetta","03128383391"));
		vendors.add(new Vendor("javaria","House#154 Street 24 jinnah town quetta","0315846647"));
		vendors.add(new Vendor("atqa ","House#512 jail Road quetta","03338464479"));
		vendors.add(new Vendor("arshad ","House#432 jail Road quetta","03114646845"));
		vendors.add(new Vendor("shakeel ","House#567 jail Road quetta","03114646845"));
		vendors.add(new Vendor("anees ","House#111 jail Road quetta","03114646845"));
		vendors.add(new Vendor("majeed ","House#34 jail Road quetta","03114646845"));
		vendors.add(new Vendor("junaid ","House#221 jail Road quetta","03114646845"));
		vendors.add(new Vendor("kabir ","House#420 jail Road quetta","03114646845"));
		
		
		products.add(new Product("Miilk","Fresh Milk product from Olpers",130));
		products.add(new Product("Buscit","Chocolate Buscites", 20.54));
		products.add(new Product("Flour","Wheat flour",1150));
		products.add(new Product("coca-cola","cold drink",90));
		products.add(new Product("wheat thin ","baked whole grain food",1150));
		products.add(new Product("sting","cold drink",60));
		products.add(new Product("Fox's Biscuit","baked biscuit",150));
		products.add(new Product("kits","chocolate",300));
		products.add(new Product("chips ahoy","baked chops",150));
		products.add(new Product("oats","jar of 500 gm",700));
		products.add(new Product("Quaker oat","Jar of 500g ",1020));
		products.add(new Product("corn flakes","large pack ",900));
		products.add(new Product("corn flakes","small pack",600));

		
		ArrayList<InvoiceItem> items = new ArrayList<>();
		items.add(new InvoiceItem(1, products.get(0), 500, products.get(0).getPrice(),products.get(0).getPrice()*500));
		items.add(new InvoiceItem(2, products.get(1), 300, products.get(1).getPrice(),products.get(1).getPrice()*300));
		items.add(new InvoiceItem(3, products.get(2), 500, products.get(2).getPrice(),products.get(2).getPrice()*500));
		items.add(new InvoiceItem(4, products.get(4), 200, products.get(4).getPrice(),products.get(4).getPrice()*200));
		
		purchaseInvoices.add(new Invoice(1, new Date(), vendors.get(1), items ));
		
		
		items.clear();
		items.add(new InvoiceItem(1, products.get(0), 10, products.get(0).getPrice(),products.get(0).getPrice()*10));
		items.add(new InvoiceItem(2, products.get(3), 20, products.get(3).getPrice(),products.get(3).getPrice()*20));
		items.add(new InvoiceItem(3, products.get(1), 50, products.get(2).getPrice(),products.get(2).getPrice()*50));
		items.add(new InvoiceItem(4, products.get(6), 30, products.get(6).getPrice(),products.get(6).getPrice()*30));
		
		purchaseInvoices.add(new Invoice(02, new Date(), vendors.get(6), items));
		
		items.clear();
		items.add(new InvoiceItem(1, products.get(9), 10, products.get(9).getPrice(),products.get(9).getPrice()*10));
		items.add(new InvoiceItem(2, products.get(6), 20, products.get(6).getPrice(),products.get(6).getPrice()*20));
		items.add(new InvoiceItem(3, products.get(7), 50, products.get(7).getPrice(),products.get(7).getPrice()*50));
		items.add(new InvoiceItem(4, products.get(8), 30, products.get(8).getPrice(),products.get(8).getPrice()*30));
		
		purchaseInvoices.add(new Invoice(02, new Date(), vendors.get(7), items));
		
	}

}
