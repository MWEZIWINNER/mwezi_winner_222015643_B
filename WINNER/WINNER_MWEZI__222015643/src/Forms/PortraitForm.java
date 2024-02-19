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

import Entities.Portrait;

public class PortraitForm implements ActionListener{
	JFrame frame;//Portrait_id	Artist_id	Warehouse_id	Portrait_name	Portrait_cost
	JLabel stid_lb=new JLabel("Portrait_id");
	JLabel artid_lb=new JLabel("Artist_id");
	JLabel warehsid_lb=new JLabel("Warehouse_id");
	JLabel prtrname_lb=new JLabel("Portrait_name");
	JLabel prtrcost_lb=new JLabel("Portrait_cost");
	
	JTextField stid_txf=new JTextField();
	JTextField artid_txf=new JTextField();
	JTextField warehsid_txf=new JTextField();
	JTextField prtrname_txf=new JTextField();
	JTextField prtrcost_txf=new JTextField();

	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public PortraitForm(){
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
		frame.setTitle("PORTRAIT FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		stid_lb.setBounds(10,10,130,30);
		artid_lb.setBounds(10,50,130,30);
		warehsid_lb.setBounds(10,90,150,30);
		prtrname_lb.setBounds(10,130,200,30);
		prtrcost_lb.setBounds(10,170,150,30);
		
		stid_txf.setBounds(170,10,200,30);
		artid_txf.setBounds(170,50,200,30);
		warehsid_txf.setBounds(170,90,200,30);
		prtrname_txf.setBounds(170,130,200,30);
		prtrcost_txf.setBounds(170,170,200,30);

	    insert_btn.setBounds(10,250,85,30);
		read_btn.setBounds(110,250,85,30);
		update_btn.setBounds(210,250,85,30);
		delete_btn.setBounds(310,250,85,30);
		
		table.setBounds(450, 10, 770, 300);
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		stid_lb.setFont(font);
		artid_lb.setFont(font);
		warehsid_lb.setFont(font);
		prtrname_lb.setFont(font);
		prtrcost_lb.setFont(font);
		
		stid_txf.setFont(font);
		artid_txf.setFont(font);
		warehsid_txf.setFont(font);
		prtrname_txf.setFont(font);
		prtrcost_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(stid_lb);
		frame.add(artid_lb);
		frame.add(warehsid_lb);
		frame.add(prtrname_lb);
		frame.add(prtrcost_lb);
		
		frame.add(stid_txf);
		frame.add(artid_txf);
		frame.add(warehsid_txf);
		frame.add(prtrname_txf);
		frame.add(prtrcost_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
		ActionEvent ();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Portrait Pt=new Portrait();
		if(e.getSource()==insert_btn) {
			
			Pt.setArtid(artid_txf.getText());
			Pt.setWarehsid(warehsid_txf.getText());
			Pt.setPrtrname(prtrname_txf.getText());
			Pt.setPrtrcost(prtrcost_txf.getText());
		
			Pt.insertData();
			
		}
		
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Portrait_id");
            model.addColumn("Artist_id");
            model.addColumn("Warehouse_id");
            model.addColumn("Portrait_name");
            model.addColumn("Portrait_cost");
            //Portrait_id	Artist_id	Warehouse_id	Portrait_name	Portrait_cost
            ResultSet resultSet =Portrait.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } 

	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(stid_txf.getText());

			Pt.setArtid(artid_txf.getText());
			Pt.setWarehsid(warehsid_txf.getText());
			Pt.setPrtrname(prtrname_txf.getText());
			Pt.setPrtrcost(prtrcost_txf.getText());
			Pt.update(id);
	    }
	  else {
			int id=Integer.parseInt(stid_txf.getText());
			Pt.delete(id);}

		
	}
	public static void main(String[] args) {
		PortraitForm stf= new PortraitForm();
		System.out.println(stf);

	      }

	
	}


