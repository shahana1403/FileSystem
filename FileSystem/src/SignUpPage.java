//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import java.awt.Font;
//
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
//import javax.swing.border.EmptyBorder;
//
//
//
//import java.awt.Color;
//import java.awt.Label;
//import java.awt.Button;
//import java.awt.Checkbox;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import javax.swing.JComboBox;
//
//import java.sql.*;
//import javax.swing.JTextPane;
//import javax.swing.AbstractButton;
//import javax.swing.JCheckBox;
//
//public class SignUpPage extends JFrame {
//
//	private JPanel contentPane;
//	private JTextField uname;
//	private JTextField email;
//	private JTextField passwd;
//	private JTextField cpwd;
//	
//	//database URL
//	
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignUpPage frame = new SignUpPage();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	//Connection connection=null;
//	
//	public SignUpPage() {
//
//		setBackground(new Color(255, 255, 102));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 400, 400);
//		contentPane = new JPanel();
//		contentPane.setBackground(new Color(255, 255, 102));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		Label label = new Label("SIGN UP");
//		label.setFont(new Font("Consolas", Font.BOLD, 18));
//		label.setAlignment(Label.CENTER);
//		label.setBackground(new Color(204, 51, 0));
//		label.setBounds(0, 0, 384, 41);
//		contentPane.add(label);
//		
//		Label label_1 = new Label("Username");
//		label_1.setFont(new Font("Consolas", Font.PLAIN, 14));
//		label_1.setAlignment(Label.CENTER);
//		label_1.setBounds(29, 59, 101, 22);
//		contentPane.add(label_1);
//		
//		Label label_2 = new Label("Email");
//		label_2.setFont(new Font("Consolas", Font.PLAIN, 14));
//		label_2.setBounds(44, 102, 86, 22);
//		contentPane.add(label_2);
//		
//		JCheckBox chckbxNewStudent = new JCheckBox("Student");
//		chckbxNewStudent.setBounds(131, 246, 93, 21);
//		
//		JCheckBox chckbxNewTeacher = new JCheckBox("Teacher");
//		chckbxNewTeacher.setBounds(255, 246, 93, 21);
//		
//		Button button = new Button("REGISTER");
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				 LoginPage page =new LoginPage();
// 				page.setVisible(true);
// 				dispose();
////				
//					
////			
////Wrapper conn= null;
//			
//			
//				//declare variables
//				
////				String username="";
////				String pwd1="";
////				String pwd2="";
////				String inemail="";
////				String title="";
////				
////				//get values using getText() method
////				username = uname.getText().trim();
////				inemail = email.getText().trim();
////				pwd1 = passwd.getText().trim();
////				pwd2 = cpwd.getText().trim();
////				
////				String msg = "" + username;
////                msg += " \n";
//				
////		
////				//title = (String)job.getSelectedItem();
////				
////                                // check condition it field equals to blank throw error message
////				if (username.equals("")|| pwd1.equals("")|| pwd2.equals("")|| inemail.equals(""))
////				{
////					JOptionPane.showMessageDialog(null," name or password or Role is wrong","Error",JOptionPane.ERROR_MESSAGE);
////				}
////				try {  //else insert query is run properly
////                           
////					String IQuery = "INSERT INTO signup (Username,Email,Password,Confirm Password,Job) VALUES('"+username+"','"+inemail+"', '"+pwd1+"'"+pwd2+"','')";
////					PreparedStatement sta = connection.prepareStatement(IQuery);
////                    sta.executeUpdate(IQuery);
//////                    if (x == 0) {
//////                        JOptionPane.showMessageDialog(button, "This is alredy exist");
//////                    } else {
////                        JOptionPane.showMessageDialog(button,
////                            "Welcome, " + msg + "Your account is sucessfully created");
////                    //}
////                    connection.close();
////                } catch (Exception exception) {
////                    exception.printStackTrace();
////                }
////            }		
////			}
////			catch (SQLException se) 
////			{
////				//handle errors for JDBC
////				se.printStackTrace();
////			}
////			catch (Exception a) //catch block
////			{
////				a.printStackTrace();
////			}
//				        
//		        		
//				 try {
//					 Class.forName("com.mysql.jdbc.Driver");
//		                //Creating Connection Object
//		                Connection connection=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12373217","sql12373217","lmx44YtqGG");
//		                //Preapared Statement
//		                PreparedStatement Pstatement=connection.prepareStatement("INSERT INTO User (username,email,password,title) values(?,?,?,?)");
//		                //Specifying the values of it's parameter
//		                
//		                Pstatement.setString(2,uname.getText());
//		                Pstatement.setString(3,email.getText());
//		               
//		                
//		                Pstatement.setString(4,passwd.getText());
//		               
//		                
//		                if(passwd.getText().equalsIgnoreCase(cpwd.getText()))
//		                {
//		                    //Executing query
//		                    Pstatement.executeUpdate();
//		                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
//		                   
//		                }
//		                else
//		                {
//		                    JOptionPane.showMessageDialog(null,"password did not match");
//		                }
//		 
//		             
//						if(chckbxNewStudent.isSelected()) {
//							Pstatement.setString(6,chckbxNewStudent.getText());
//		        			chckbxNewTeacher.setSelected(false);
//		        		}
//		        		else if(chckbxNewTeacher.isSelected()) {
//		        			Pstatement.setString(6,chckbxNewTeacher.getText());
//		        			chckbxNewStudent.setSelected(false);
//		        		}
//		             
//		                //Checking for the Password match
//		                
//		            } catch (SQLException | ClassNotFoundException e1) {
//		                e1.printStackTrace();
//		            }
//		 
//		 
//		        }
//			
//		});
//		button.setBackground(new Color(255, 255, 153));
//		button.setBounds(44, 323, 94, 30);
//		contentPane.add(button);
//		
//		Button button_1 = new Button("EXIT");
//		button_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				LoginPage login=new LoginPage();
//				login.setVisible(true);
//				dispose();
//			}
//		});
//		button_1.setBackground(new Color(255, 255, 153));
//		button_1.setBounds(278, 323, 70, 30);
//		contentPane.add(button_1);
//		
//		Label label_4 = new Label("Create Password");
//		label_4.setFont(new Font("Consolas", Font.PLAIN, 14));
//		label_4.setBounds(44, 149, 122, 22);
//		contentPane.add(label_4);
//		
//		Label label_5 = new Label("Job");
//		label_5.setFont(new Font("Consolas", Font.PLAIN, 14));
//		label_5.setBounds(44, 237, 62, 30);
//		contentPane.add(label_5);
//		
//		Label label_3 = new Label("Confirm password");
//		label_3.setFont(new Font("Consolas", Font.PLAIN, 14));
//		label_3.setBounds(44, 195, 122, 22);
//		contentPane.add(label_3);
//		
//		uname = new JTextField();
//		uname.setBounds(136, 61, 212, 22);
//		contentPane.add(uname);
//		uname.setColumns(10);
//		
//		email = new JTextField();
//		email.setBounds(136, 112, 212, 20);
//		contentPane.add(email);
//		email.setColumns(10);
//		
//		passwd = new JTextField();
//		passwd.setBounds(172, 151, 176, 20);
//		contentPane.add(passwd);
//		passwd.setColumns(10);
//		
//		cpwd = new JTextField();
//		cpwd.setBounds(172, 197, 176, 20);
//		contentPane.add(cpwd);
//		cpwd.setColumns(10);
//		
//		String [] tit= new String[] {"Teacher","Student"};
//		
//		
//		contentPane.add(chckbxNewStudent);
//		
//		
//		contentPane.add(chckbxNewTeacher);
//		
//		
//		
//		Button button_2 = new Button("RESET");
//		button_2.setBackground(new Color(255, 255, 153));
//		button_2.setBounds(168, 323, 86, 30);
//		contentPane.add(button_2);
//	}
//}

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
//
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
//
//
//
import java.awt.Color;
import java.awt.Label;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import java.sql.*;
import javax.swing.JTextPane;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

 
public class SignUpPage implements ActionListener {
    JFrame frame;
    String[] gender={"Male","Female"};
    JLabel nameLabel=new JLabel("NAME");
    JLabel genderLabel=new JLabel("GENDER");
    //JLabel fatherNameLabel=new JLabel("FATHER NAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JLabel confirmPasswordLabel=new JLabel("CONFIRM PASSWORD");
    //JLabel cityLabel=new JLabel("CITY");
    JLabel emailLabel=new JLabel("EMAIL");
    JTextField nameTextField=new JTextField();
    JComboBox genderComboBox=new JComboBox(gender);
    //JTextField cityTextField=new JTextField();
    JTextField emailTextField=new JTextField();
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");
 
 
    SignUpPage()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setBackground(Color.ORANGE);
        frame.setTitle("Registration Form");
        frame.setBounds(40,40,380,600);
        frame.getContentPane().setBackground(new Color(153, 255, 255));
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        nameLabel.setBounds(20,20,40,70);
        genderLabel.setBounds(20,70,80,70);
        //fatherNameLabel.setBounds(20,120,100,70);
        passwordLabel.setBounds(20,170,100,70);
        confirmPasswordLabel.setBounds(20,220,140,70);
        //cityLabel.setBounds(20,270,100,70);
        emailLabel.setBounds(20,320,100,70);
        nameTextField.setBounds(180,43,165,23);
        genderComboBox.setBounds(180,93,165,23);
        //cityTextField.setBounds(180,293,165,23);
        emailTextField.setBounds(180,343,165,23);
        registerButton.setBounds(70,400,100,35);
        resetButton.setBounds(220,400,100,35);
    }
    public void addComponentsToFrame()
    {
        frame.getContentPane().add(nameLabel);
        frame.getContentPane().add(genderLabel);
        //frame.add(fatherNameLabel);
        frame.getContentPane().add(passwordLabel);
        frame.getContentPane().add(confirmPasswordLabel);
        //frame.add(cityLabel);
        frame.getContentPane().add(emailLabel);
        frame.getContentPane().add(nameTextField);
        frame.getContentPane().add(genderComboBox);
        //frame.add(cityTextField);
        frame.getContentPane().add(emailTextField);
        frame.getContentPane().add(registerButton);
        frame.getContentPane().add(resetButton);
        
        pwd = new JTextField();
        pwd.setBounds(180, 192, 165, 23);
        frame.getContentPane().add(pwd);
        pwd.setColumns(10);
        
        conpwd = new JTextField();
        conpwd.setBounds(180, 242, 165, 23);
        frame.getContentPane().add(conpwd);
        conpwd.setColumns(10);
    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }
 
    String uname;
    String genders;
    String passwd;
    String cpwd;
    String email;
    private JTextField pwd;
    private JTextField conpwd;
 
    @Override
    public void actionPerformed(ActionEvent e) {
    	 
        if(e.getSource()==registerButton)
        {
        	LoginPage login=new LoginPage();
		    login.setVisible(true);
			frame.dispose();
            try {
            	Class.forName("com.mysql.jdbc.Driver");
                //Creating Connection Object
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","");
                //Preapared Statement
                
                //Specifying the values of it's parameter
                uname=nameTextField.getText();
                genders=genderComboBox.getSelectedItem().toString();
               
                passwd=pwd.getText();
                cpwd=conpwd.getText();
                
                email=emailTextField.getText();
                
                PreparedStatement Pstatement=connection.prepareStatement("INSERT INTO student(USERNAME,GENDER,PASSWRD,CONFIRMPASSWRD,EMAIL) VALUES ('"+uname+"','"+genders+"','"+passwd+"','"+cpwd+"','"+email+"')");
                	
                //Checking for the Password match
                if(passwd.equalsIgnoreCase(cpwd))
                {
                    //Executing query
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"password did not match");
                }
             connection.close();
             
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
 
                   
        }
        if(e.getSource()==resetButton)
        {
            //Clearing Fields
            nameTextField.setText("");
//            genderComboBox.setSelectedItem("Male");
//            fatherTextField.setText("");
            pwd.setText("");
            conpwd.setText("");
            //cityTextField.setText("");
            emailTextField.setText("");
        }
 
    }
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}