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

import Entities.Orders;

public class OrdersForm implements ActionListener{
	JFrame frame;//Order_id	Customer_id	Date_and_time
	JLabel ordid_lb=new JLabel("Order_id");
	JLabel cstid_lb=new JLabel("Customer_id");
	JLabel datetime_lb=new JLabel("Date_and_time");
	
	JTextField ordid_txf=new JTextField();
	JTextField cstid_txf=new JTextField();
	JTextField datetime_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public OrdersForm(){
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
		frame.setTitle("ORDERS FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.yellow);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		ordid_lb.setBounds(10,10,130,30);
		cstid_lb.setBounds(10,50,130,30);
		datetime_lb.setBounds(10,90,150,30);
		
		ordid_txf.setBounds(170,10,200,30);
		cstid_txf.setBounds(170,50,200,30);
		datetime_txf.setBounds(170,90,200,30);

		insert_btn.setBounds(10,220,85,30);
		read_btn.setBounds(110,220,85,30);
		update_btn.setBounds(210,220,85,30);
		delete_btn.setBounds(310,220,85,30);
		
		table.setBounds(450, 10, 770, 300);
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		ordid_lb.setFont(font);
		cstid_lb.setFont(font);
		datetime_lb.setFont(font);
		
		ordid_txf.setFont(font);
		cstid_txf.setFont(font);
		datetime_txf.setFont(font);

		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add( ordid_lb);
		frame.add(cstid_lb);
		frame.add(datetime_lb);
		
		frame.add( ordid_txf);
		frame.add(cstid_txf);
		frame.add(datetime_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
		ActionEvent ();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Orders or=new Orders();
		if(e.getSource()==insert_btn) {
			or.setCstid(cstid_txf.getText());
			or.setDatetime(datetime_txf.getText());
			
			or.insertData();
			
		}
		
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Order_id");
            model.addColumn("Customer_id");
            model.addColumn("Date_and_time");
           
            //Order_id	Customer_id	Date_and_time
            ResultSet resultSet =Orders.viewData();
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
			int id=Integer.parseInt(ordid_txf.getText());
			or.setCstid(cstid_txf.getText());
			or.setDatetime(datetime_txf.getText());
			or.update(id);
	    }
	  else {
			int id=Integer.parseInt(ordid_txf.getText());
			or.delete(id);}
             }
	public static void main(String[] args) {
		OrdersForm stf= new OrdersForm();
		System.out.println(stf);

	      }

	
	}

