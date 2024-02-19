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

import Entities.Transaction;

public class TransactionForm implements ActionListener{
	JFrame frame;//Transaction_id	Order_id	Portrait_id	Transaction_Date
	JLabel trnsid_lb=new JLabel("Transaction_id");
	JLabel ordid_lb=new JLabel("Order_id");
	JLabel prtrid_lb=new JLabel("Portrait_id");
	JLabel trnsdate_lb=new JLabel("Transaction_Date");
	
	JTextField trnsid_txf=new JTextField();
	JTextField ordid_txf=new JTextField();
	JTextField prtrid_txf=new JTextField();
	JTextField trnsdate_txf=new JTextField();
	
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public TransactionForm(){
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
		frame.setTitle("TRANSACTION FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		trnsid_lb.setBounds(10,10,190,30);
		ordid_lb.setBounds(10,50,130,30);
	    prtrid_lb.setBounds(10,90,150,30);
	    trnsdate_lb.setBounds(10,130,200,30);
		
		trnsid_txf.setBounds(190,10,200,30);
		ordid_txf.setBounds(190,50,200,30);
		prtrid_txf.setBounds(190,90,200,30);
		trnsdate_txf.setBounds(190,130,200,30);
		
		insert_btn.setBounds(10,230,85,30);
		read_btn.setBounds(110,230,85,30);
		update_btn.setBounds(210,230,85,30);
		delete_btn.setBounds(310,230,85,30);
		
		table.setBounds(450, 10, 700, 300);
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		trnsid_lb.setFont(font);
		ordid_lb.setFont(font);
		prtrid_lb.setFont(font);
		trnsdate_lb.setFont(font);
		
		trnsid_txf.setFont(font);
		ordid_txf.setFont(font);
		prtrid_txf.setFont(font);
		trnsdate_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(trnsid_lb);
		frame.add(ordid_lb);
		frame.add(prtrid_lb);
		frame.add(trnsdate_lb);
		
		frame.add(trnsid_txf);
		frame.add(ordid_txf);
		frame.add(prtrid_txf);
		frame.add(trnsdate_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
		ActionEvent ();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Transaction  trt=new Transaction ();
		if(e.getSource()==insert_btn) {
			
			trt.setOrdid(ordid_txf.getText());
			trt.setPrtrid(prtrid_txf.getText());
			trt.setTrnsdate(trnsdate_txf.getText());
			trt.insertData();
			
		}
		
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Transaction_id");
            model.addColumn("Order_id");
            model.addColumn("Portrait_id");
            model.addColumn("Transaction_Date");
           
            //Transaction_id	Order_id	Portrait_id	Transaction_Date
            ResultSet resultSet =Transaction.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } 

	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(trnsid_txf.getText());
			trt.setOrdid(ordid_txf.getText());
			trt.setPrtrid(prtrid_txf.getText());
			trt.setTrnsdate(trnsdate_txf.getText());
			trt.update(id);
	    }
	  else {
			int id=Integer.parseInt(trnsid_txf.getText());
			trt.delete(id);}

		
	}
	public static void main(String[] args) {
		TransactionForm stf= new TransactionForm();
		System.out.println(stf);

	      }

	
	}



