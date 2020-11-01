
	import java.awt.Color;
	import java.awt.EventQueue;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.TextField;

	public class ChangePassword extends JFrame {

	    private static final long serialVersionUID = 1L;
	    private JPanel contentPane;
	    private JTextField textField;
	    private JLabel lblEnterNewPassword;

	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {

	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    /**
	     * Create the frame.
	     */
	    public ChangePassword() {
	        setBounds(450, 360, 588, 234);
	        setResizable(false);

	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(153, 255, 255));
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        textField = new JTextField();
	        textField.setFont(new Font("Tahoma", Font.PLAIN, 28));
	        textField.setBounds(154, 110, 363, 26);
	        contentPane.add(textField);
	        textField.setColumns(10);

	       
	       

	        lblEnterNewPassword = new JLabel("Enter New Password :");
	        lblEnterNewPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
	        lblEnterNewPassword.setBounds(10, 110, 143, 26);
	        contentPane.add(lblEnterNewPassword);
	        
	        Label username = new Label("Username :");
	        username.setFont(new Font("Dialog", Font.PLAIN, 16));
	        username.setBounds(10, 65, 127, 26);
	        contentPane.add(username);
	        
	        TextField user = new TextField();
	        user.setFont(new Font("Tahoma", Font.PLAIN, 28));
	        user.setBounds(154, 65, 363, 26);
	        contentPane.add(user);
	        
	        JButton btnSearch = new JButton("Enter");
	        btnSearch.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {

	                String pstr = textField.getText();
	                String uname=user.getText();
	                try {
	                	Class.forName("com.mysql.jdbc.Driver");
//	                    System.out.println("update password name " + name);
//	                    System.out.println("update password");
//	                    
	                    

	                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root", "");

	                    PreparedStatement st = con.prepareStatement("UPDATE student SET PASSWRD='"+pstr+"', CONFIRMPASSWRD='"+pstr+"' WHERE USERNAME='"+uname+"'");

//	                    st.setString(1, pstr);
//	                    st.setString(2, name);
	                    st.executeUpdate();
	                    JOptionPane.showMessageDialog(btnSearch, "Password has been successfully changed");

	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                } catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

	            }
	        });
	        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 22));
	        btnSearch.setBackground(new Color(255, 255, 153));
	        btnSearch.setBounds(216, 152, 170, 33);
	        contentPane.add(btnSearch);
	    }
}

