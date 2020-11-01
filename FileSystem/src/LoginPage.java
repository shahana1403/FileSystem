import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JPasswordField password;
	private JTextField nameemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setBackground(new Color(255, 255, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("LOGIN");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBackground(new Color(51, 153, 153));
		label.setBounds(0, 0, 384, 48);
		contentPane.add(label);
		
		Label label_1 = new Label("WELCOME");
		label_1.setFont(new Font("Dialog", Font.BOLD, 18));
		label_1.setAlignment(Label.CENTER);
		label_1.setBounds(0, 64, 384, 38);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Username/Email");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 13));
		label_2.setBounds(27, 123, 110, 22);
		contentPane.add(label_2);
		
		nameemail = new JTextField();
		nameemail.setBounds(143, 123, 178, 27);
		contentPane.add(nameemail);
		nameemail.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(143, 172, 178, 27);
		contentPane.add(password);
		
		Label label_3 = new Label("Password");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 13));
		label_3.setBounds(27, 172, 110, 22);
		contentPane.add(label_3);
		
		Label label_4 = new Label("Not yet a member? Then Sign Up here");
		label_4.setForeground(new Color(51, 0, 153));
		label_4.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_4.setBounds(10, 273, 202, 22);
		contentPane.add(label_4);
			
		
		
		Button button = new Button("LOGIN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Home page =new Home();
//				page.setVisible(true);
//				dispose();
				
				String uname;
				String email;
		        String pawd;
				 try {
					 Class.forName("com.mysql.jdbc.Driver");
		                //Creating Connection Object
		                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","");
		                //Preapared Statement
		                
					   uname=nameemail.getText(); 
					   email= nameemail.getText();
					   pawd=password.getText();
					   
					   PreparedStatement Pstatement=connection.prepareStatement("SELECT USERNAME,PASSWRD,EMAIL FROM student WHERE (USERNAME='"+uname+"' OR EMAIL='"+email+"') AND PASSWRD='"+pawd+"'");
					   
					   ResultSet rs= Pstatement.executeQuery();
					   
					   if (rs.next()) {
						   
						   Main page =new Main();
							page.setVisible(true);
							dispose();
							
							JOptionPane.showMessageDialog(null,"You have successfully logged in" );
						   
					   }else {
						   JOptionPane.showMessageDialog(null, "Wrong Username, Email or Password");
					   }
				 }catch (SQLException sqlException) {
					 sqlException.printStackTrace();
				 } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
       		     
				
				
			}
		});
		
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		button.setBackground(new Color(255, 255, 153));
		button.setBounds(216, 217, 89, 33);
		contentPane.add(button);
		
		Button buttonsign = new Button("Sign Up");
		buttonsign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpPage page2=new SignUpPage();
				page2.setVisible(true);
				dispose();
			}
		});
		
		buttonsign.setBackground(new Color(255, 255, 153));
		buttonsign.setFont(new Font("Dialog", Font.BOLD, 14));
		buttonsign.setBounds(218, 262, 87, 33);
		contentPane.add(buttonsign);
		
		Button button_1 = new Button("Change Password");
		button_1.setBackground(new Color(255, 255, 153));
		button_1.setFont(new Font("Dialog", Font.BOLD, 14));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword bo = new ChangePassword();
                bo.setTitle("Change Password");
                bo.setVisible(true);
        		
			}
		});
		button_1.setBounds(99, 309, 216, 33);
		contentPane.add(button_1);
		
		
		
//		Button button_1 = new Button("SIGN UP");
//		button_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				SignUpPage signup =new SignUpPage();
//				signup.setVisible(true);
//				dispose();	
//			}
		}
	}
