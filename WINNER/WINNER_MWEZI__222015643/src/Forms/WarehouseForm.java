package Forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Entities.Warehouse;

public class WarehouseForm implements ActionListener{
	JFrame frame;//Warehouse_id	Order_id	Location
	JLabel warehsid_lb=new JLabel("Warehouse_id");
	JLabel ordid_lb=new JLabel("Order_id");
	JLabel loctn_lb=new JLabel("Location");
	
	
	JTextField warehsid_txf=new JTextField();
	JTextField ordid_txf=new JTextField();
	JTextField loctn_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public WarehouseForm(){
		createForm();
	    }
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("WAREHOUSE FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.PINK);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		warehsid_lb.setBounds(10,10,170,30);
		ordid_lb.setBounds(10,50,130,30);
		loctn_lb.setBounds(10,90,150,30);
		
		warehsid_txf.setBounds(170,10,200,30);
		ordid_txf.setBounds(170,50,200,30);
		loctn_txf.setBounds(170,90,200,30);
		
		insert_btn.setBounds(10,230,85,30);
		read_btn.setBounds(110,230,85,30);
		update_btn.setBounds(210,230,85,30);
		delete_btn.setBounds(310,230,85,30);
		
		table.setBounds(450, 10, 770, 300);
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		warehsid_lb.setFont(font);
		ordid_lb.setFont(font);
		loctn_lb.setFont(font);
		
		warehsid_txf.setFont(font);
		ordid_txf.setFont(font);
		loctn_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(warehsid_lb);
		frame.add(ordid_lb);
		frame.add(loctn_lb);
		
		frame.add(warehsid_txf);
		frame.add(ordid_txf);
		frame.add(loctn_txf);
		
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
		ActionEvent ();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Warehouse WR=new Warehouse();
		if(e.getSource()==insert_btn) {
			WR.setOrdid(ordid_txf.getText());
			WR.setLoctn(loctn_txf.getText());
			WR.insertData();
			
		}
		
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Warehouse_id");
            model.addColumn("Order_id");
            model.addColumn("Location");
            
            //Warehouse_id	Order_id	Location
            ResultSet resultSet =Warehouse.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } 

	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(warehsid_txf.getText());
			WR.setOrdid(ordid_txf.getText());
			WR.setLoctn(loctn_txf.getText());
			WR.update(id);
	    }
	  else {
			int id=Integer.parseInt(warehsid_txf.getText());
			WR.delete(id);}

		
	}
	public static void main(String[] args) {
		WarehouseForm stf= new WarehouseForm();
		System.out.println(stf);

	      }

	
	}




