package StudentInfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame frame;
	private JTextField n;
	private JTextField u;
	private JPasswordField p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 673, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(229, 40, 210, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(129, 168, 118, 44);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(129, 223, 101, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(129, 269, 101, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		n = new JTextField();
		n.setBounds(276, 183, 86, 20);
		frame.getContentPane().add(n);
		n.setColumns(10);
		
		u = new JTextField();
		u.setBounds(276, 226, 86, 20);
		frame.getContentPane().add(u);
		u.setColumns(10);
		
		p = new JPasswordField();
		p.setBounds(276, 269, 86, 20);
		frame.getContentPane().add(p);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(129, 309, 80, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JRadioButton r2 = new JRadioButton("female");
		r2.setBounds(338, 308, 140, 23);
		frame.getContentPane().add(r2);
		
		JRadioButton r1 = new JRadioButton("male");
		r1.setBounds(276, 308, 60, 23);
		frame.getContentPane().add(r1); 
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		JLabel lblNewLabel_4_1 = new JLabel("Hobbies");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4_1.setBounds(129, 348, 80, 14);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JComboBox c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Playing", "Playingg", "Playinggg", "Sleeping", "Sleepingg", "Sleepinggg"}));
		c1.setBounds(276, 346, 86, 24);
		frame.getContentPane().add(c1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=n.getText(), username=u.getText(), password=p.getText(), hobbies=(String) c1.getSelectedItem(),gender = null;
				if(r2.isSelected()) {
					gender="female";
				}else if(r1.isSelected()) {
					gender="male";
				}else {
					JOptionPane.showMessageDialog(btnNewButton, "Are you a gay?");
				}
				
				Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/3year","root","mrec");
					String q= "Insert into Student_info values('"+name+"','"+username+"','"+password+"','"+gender+"','"+hobbies+"')"; 
					java.sql.Statement sta =con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton, "Done!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(276, 409, 101, 31);
		frame.getContentPane().add(btnNewButton);
	}
}
