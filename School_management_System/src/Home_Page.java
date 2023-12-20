import java.awt.*;

import java.sql.*;
import javax.swing.*;

import com.mysql.cj.jdbc.DatabaseMetaData;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Home_Page {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Home Page");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 245, 255));
		panel.setBounds(6, 6, 438, 260);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Add a Student");
		btnNewButton.setBackground(new Color(124, 147, 195));
		btnNewButton.setFont(new Font("Futura", Font.PLAIN, 17));
		btnNewButton.setBounds(6, 6, 142, 71);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				New_Admission admis = new New_Admission();
				try {
					admis.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete an entry");
		btnNewButton_1.setBackground(new Color(124, 147, 195));
		btnNewButton_1.setFont(new Font("Futura", Font.PLAIN, 17));
		btnNewButton_1.setBounds(148, 6, 142, 71);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Search sea = new Search();
				sea.main(null);
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Fee Collection");
		btnNewButton_2.setBackground(new Color(124, 147, 195));
		btnNewButton_2.setFont(new Font("Futura", Font.PLAIN, 17));
		btnNewButton_2.setBounds(291, 6, 141, 71);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Search_fee fee = new Search_fee();
				fee.main(null);
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Class Strength");
		btnNewButton_3.setBackground(Color.RED);
		btnNewButton_3.setFont(new Font("Futura", Font.PLAIN, 17));
		btnNewButton_3.setBounds(6, 79, 142, 71);
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Class_Search strength = new Class_Search();
				strength.main(null);
			}
		});
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Add Class");
		btnNewButton_4.setBackground(new Color(124, 147, 195));
		btnNewButton_4.setFont(new Font("Futura", Font.PLAIN, 17));
		btnNewButton_4.setBounds(148, 79, 142, 71);
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Adding_Class add = new Adding_Class();
				add.main(null);
			}
		});
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New Database");
		btnNewButton_5.setBackground(new Color(124, 147, 195));
		btnNewButton_5.setFont(new Font("Futura", Font.PLAIN, 17));
		btnNewButton_5.setBounds(291, 79, 141, 71);
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				New_Database year = new New_Database();
				year.main(null);
			}
		});
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Classes");
		btnNewButton_6.setBackground(new Color(124, 147, 195));
		btnNewButton_6.setFont(new Font("Futura", Font.PLAIN, 17));
		btnNewButton_6.setBounds(6, 153, 142, 71);
		btnNewButton_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Class_List list = new Class_List();
				list.main(null);
			}
		});
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Fee Heads");
		btnNewButton_7.setBackground(new Color(124, 147, 195));
		btnNewButton_7.setFont(new Font("Futura", Font.PLAIN, 17));
		btnNewButton_7.setBounds(290, 153, 142, 71);
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Print");
		btnNewButton_8.setFont(new Font("Futura", Font.PLAIN, 17));
		btnNewButton_8.setBounds(148, 153, 142, 71);
		panel.add(btnNewButton_8);
		
		JLabel lblNewLabel = new JLabel("ADARSH VIDYALAYA, 11/223 SOUTER GANJ, KANPUR(208001)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel.setBounds(6, 236, 426, 16);
		panel.add(lblNewLabel);
		
		frame.setVisible(true);
	}
}
