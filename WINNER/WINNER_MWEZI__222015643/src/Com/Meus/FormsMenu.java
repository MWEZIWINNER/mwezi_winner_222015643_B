package Com.Meus;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Forms.ArtistForm;
import Forms.CustomerForm;
import Forms.OrdersForm;
import Forms.PortraitForm;
import Forms.TransactionForm;
import Forms.WarehouseForm;


public class FormsMenu extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu Artistmenu;
    private JMenu Customermenu;
    private JMenu Ordersmenu;
    private JMenu Portraitmenu;
    private JMenu Transactionmenu;
    private JMenu Warehousemenu;
    private JMenu Logoutmenu;
    
    public FormsMenu() {
		// TODO Auto-generated constructor stub
	}
    
  
    private JMenuItem ArtistItem;
    private JMenuItem CustomerItem;
    private JMenuItem OrdersItem;
    private JMenuItem PortraitItem;
    private JMenuItem TransactionItem;
    private JMenuItem WarehouseItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public FormsMenu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        Artistmenu = new JMenu("Artist");
        Customermenu = new JMenu("Customer");
        Ordersmenu= new JMenu("Orders");
        Portraitmenu = new JMenu("Portrait");
        Transactionmenu = new JMenu("Transaction");
        Warehousemenu = new JMenu("Warehouse");
        Logoutmenu = new JMenu("SIGNING OUT");
        		

        // Create menu items
        menuBar.add(Artistmenu);
        ArtistItem = new JMenuItem("ArtistForm");
        ArtistItem.addActionListener(this);
        
        menuBar.add(Customermenu);
        CustomerItem = new JMenuItem("CustomerForm");
        CustomerItem.addActionListener(this);
        
        menuBar.add(Ordersmenu);
        OrdersItem = new JMenuItem("OrdersForm");
        OrdersItem.addActionListener(this);
        
        menuBar.add(Portraitmenu);
        PortraitItem = new JMenuItem("PortraitForm");
        PortraitItem.addActionListener(this);
        
        menuBar.add(Transactionmenu);
        TransactionItem = new JMenuItem("TransactionForm");
        TransactionItem.addActionListener(this);
        
        menuBar.add(Warehousemenu);
        WarehouseItem = new JMenuItem("WarehouseForm");
        WarehouseItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        Artistmenu.add(ArtistItem);
        Customermenu.add(CustomerItem);
        Ordersmenu.add(OrdersItem);
        Portraitmenu.add(PortraitItem);
        Transactionmenu.add(TransactionItem);
        Warehousemenu.add(WarehouseItem);
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ArtistItem) {
            new ArtistForm();
        
        } else if (e.getSource() == CustomerItem) {
            new CustomerForm();
        
        } else if (e.getSource() == OrdersItem) {
            new OrdersForm();
       
        } else if (e.getSource() == PortraitItem) {
           new PortraitForm();
        

        } else if (e.getSource() == TransactionItem) {
           new TransactionForm();
        
        } else if (e.getSource() == WarehouseItem) {
           new WarehouseForm();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormsMenu("TO ONLINE PORTRAIT SELLING MANAGEMENT SYSTEM"));
    }
}






