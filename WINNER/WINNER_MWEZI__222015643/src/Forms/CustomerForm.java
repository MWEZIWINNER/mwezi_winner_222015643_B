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

import Entities.Customer;

public class CustomerForm implements ActionListener{
	JFrame frame;//Customer_id	First_name	Last_name	Age	Phone_number	Creditcard_id
	JLabel stid_lb=new JLabel("Customer_id");
	JLabel fname_lb=new JLabel("first_name");
	JLabel lname_lb=new JLabel("last_name");
	JLabel age_lb=new JLabel("age");
	JLabel phone_lb=new JLabel("Phone_number");
	JLabel crdtid_lb=new JLabel("Creditcard_id");
	
	JTextField stid_txf=new JTextField();
	JTextField fname_txf=new JTextField();
	JTextField lname_txf=new JTextField();
	JTextField age_txf=new JTextField();
	JTextField phone_txf=new JTextField();
	JTextField crdtid_txf=new JTextField();
	
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public CustomerForm(){
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
		frame.setTitle("CUSTOMER FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		stid_lb.setBounds(10,10,130,30);
		fname_lb.setBounds(10,50,130,30);
		lname_lb.setBounds(10,90,150,30);
		age_lb.setBounds(10,130,200,30);
		phone_lb.setBounds(10,170,150,30);
		crdtid_lb.setBounds(10, 210, 100, 30);
		
		stid_txf.setBounds(170,10,200,30);
		fname_txf.setBounds(170,50,200,30);
		lname_txf.setBounds(170,90,200,30);
		age_txf.setBounds(170,130,200,30);
		phone_txf.setBounds(170,170,200,30);
		crdtid_txf.setBounds(170, 210, 200, 30);

		insert_btn.setBounds(10,300,85,30);
		read_btn.setBounds(110,300,85,30);
		update_btn.setBounds(210,300,85,30);
		delete_btn.setBounds(310,300,85,30);
		
		table.setBounds(450, 10, 770, 300);
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		stid_lb.setFont(font);
		fname_lb.setFont(font);
		lname_lb.setFont(font);
		age_lb.setFont(font);
		phone_lb.setFont(font);
		crdtid_lb.setFont(font);
		
		stid_txf.setFont(font);
		fname_txf.setFont(font);
		lname_txf.setFont(font);
		age_txf.setFont(font);
		phone_txf.setFont(font);
		crdtid_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}

	private void addcomponentforFrame() {
		frame.add(stid_lb);
		frame.add(fname_lb);
		frame.add(lname_lb);
		frame.add(age_lb);
		frame.add(phone_lb);
		frame.add(crdtid_lb);
		
		frame.add(stid_txf);
		frame.add(fname_txf);
		frame.add(lname_txf);
		frame.add(age_txf);
		frame.add(phone_txf);
		frame.add(crdtid_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
		ActionEvent ();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Customer st=new Customer();
		if(e.getSource()==insert_btn) {
			
			st.setFname(fname_txf.getText());
			st.setLname(lname_txf.getText());
			st.setAge(age_txf.getText());
			st.setPhone(phone_txf.getText());
			st.setCrdtid(crdtid_txf.getText());
			
			st.insertData();
			
		}
		
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Customer_id");
            model.addColumn("first_name");
            model.addColumn("last_name");
            model.addColumn("age");
            model.addColumn("Phone_number");
            model.addColumn("Creditcard_id");
            //Customer_id	First_name	Last_name	Age	Phone_number	Creditcard_id
            ResultSet resultSet =Customer.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), 
                                resultSet.getString(6)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } 

	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(stid_txf.getText());

			st.setFname(fname_txf.getText());
			st.setLname(lname_txf.getText());
			st.setAge(age_txf.getText());
			st.setPhone(phone_txf.getText());
			st.setCrdtid(crdtid_txf.getText());
			st.update(id);
	    }
	  else {
			int id=Integer.parseInt(stid_txf.getText());
			st.delete(id);}

		
	}
	public static void main(String[] args) {
		CustomerForm stf= new CustomerForm();
		System.out.println(stf);

	      }

	
	}

