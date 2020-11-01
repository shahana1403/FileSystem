import data.Data;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.Timer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.apache.commons.io.FileUtils;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

public class Client extends javax.swing.JFrame implements ActionListener {
	static private final String newline = "\n";
	
    static String date=java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME.format(ZonedDateTime.now(ZoneOffset.systemDefault())).toString();
   	
    	JButton downloadBut, listBut, disconnectBut; 
     	DataInputStream inFromServer; 
    	DataOutputStream outToServer;
    	JFileChooser fc; 
    	JComboBox<String> combo; 
    	FileInputStream in;  
    	int i;
    	
    public Client() {
    	getContentPane().setBackground(new Color(204, 255, 255));
       
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setOpaque(true);
        jLabel1.setBackground(new Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jButton1 = new javax.swing.JButton();
        jButton1.setFont(new Font("Dialog", Font.PLAIN, 13));
        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        txtIp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setFont(new Font("Dialog", Font.BOLD, 12));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); 
        jLabel1.setText("Home");

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt.setEditable(false);
        txt.setColumns(20);
        txt.setRows(5);
        jScrollPane1.setViewportView(txt);

        jLabel2.setText("Enter IP address");
        
      	listBut = new JButton("Lists of files");
      	listBut.setFont(new Font("Dialog", Font.PLAIN, 12));
      	listBut.addActionListener(this);
      		
      		
      	downloadBut = new JButton("Download");
      	downloadBut.setFont(new Font("Dialog", Font.PLAIN, 12));
      	downloadBut.addActionListener(this);
      		
        disconnectBut = new JButton("Disconnect");
        disconnectBut.setFont(new Font("Dialog", Font.PLAIN, 12));
        disconnectBut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					exitClient();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
        combo = new JComboBox<String>(); // Declaring object of combobox class
        
        lblNewLabel = new JLabel("Choose files to download:");
        lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(34)
        			.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(txtIp, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
        			.addGap(124))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(19)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 656, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(20, Short.MAX_VALUE))
        		.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(73)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(94, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(listBut, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        					.addGap(184)
        					.addComponent(downloadBut, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        					.addGap(37)
        					.addComponent(disconnectBut, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
        					.addGap(59))))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(182)
        			.addComponent(combo, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(381, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtIp, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
        			.addGap(16)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(combo, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        				.addComponent(listBut, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createParallelGroup(Alignment.BASELINE, false)
        					.addComponent(disconnectBut, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        					.addComponent(downloadBut, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
        			.addGap(21))
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        mnNewMenu = new JMenu("Home");
        mnNewMenu.setForeground(new Color(0, 0, 0));
        mnNewMenu.setFont(new Font("Dialog", Font.BOLD, 14));
        menuBar.add(mnNewMenu);
        
        mnNewMenu_1 = new JMenu("Instructions");
        mnNewMenu_1.setForeground(new Color(0, 0, 0));
        mnNewMenu_1.setFont(new Font("Dialog", Font.BOLD, 14));
        menuBar.add(mnNewMenu_1);
        
        mntmNewMenuItem_1 = new JMenuItem("How to download files?");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			        	Instruction instructions =new Instruction();
			        	instructions.setVisible(true);
						dispose();
					}
				});
			
        mnNewMenu_1.add(mntmNewMenuItem_1);
              
        mnNewMenu_2 = new JMenu("LOGOUT");
        mnNewMenu_2.setForeground(new Color(0, 0, 0));
        mnNewMenu_2.setFont(new Font("Dialog", Font.BOLD, 14));
        menuBar.add(mnNewMenu_2);
        
        mntmNewMenuItem_2 = new JMenuItem("LOGOUT");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			        	LoginPage login =new LoginPage();
			        	login.setVisible(true);
						dispose();
					}
				});
        mnNewMenu_2.add(mntmNewMenuItem_2);
    }

  
	protected void exitClient() {
		// TODO Auto-generated method stub
		System.exit(0);
	}


	private Socket socket;
    private ObjectOutputStream out;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            socket = new Socket(txtIp.getText().trim(), 9999);
            txt.append("Connection successful ...\n");
            out = new ObjectOutputStream(socket.getOutputStream());
            Data data = new Data();
            data.setStatus("new");
            data.setName("customer");
            out.writeObject(data);
            out.flush();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @Override
	public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == listBut) {
			try {
				listOfFiles();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}else if (e.getSource() == downloadBut) {
			try {
				downloadFile();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}else if (e.getSource() == disconnectBut) {
			try {
				exitClient();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
    
    private void send(){
		// TODO Auto-generated method stub
    	try {
    		File file = fc.getSelectedFile(); 
    		socket = new Socket(txtIp.getText().trim(), 9999);
    		DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); 
    		FileInputStream fis = new FileInputStream(file);
    		byte[] buffer = new byte[4096]; 
    		dos.writeUTF(file.getName());
    		while (fis.read(buffer) > 0) {
    			dos.write(buffer);
    		}
    		txt.append("File " +file.getName()+" uploaded successfully"+ newline); 
    		String msg= "File " +file.getName()+" uploaded successfully"+ newline; 
    		int res=msg.length(); 
    		String httpMsg="Host: http://127.0.0.1\n"+"Date:"+date+"\n";
    		txt.append(httpMsg + newline);
    		dos.flush();
  	
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // socket connection
    }
	

	private void listOfFiles() {
		// TODO Auto-generated method stub
		 {
			 //Please change directory as per your pc
			File folder = new File("C:/Users/Shahana/Desktop/FileSystem/files/"); 
			File[] listOfFiles = folder.listFiles();
			combo.removeAllItems();
			
			for (int i = 0; i < listOfFiles.length; i++) { 
				if (listOfFiles[i].isFile()) {
					txt.append(listOfFiles[i].getName()+ newline); 
					String msg = listOfFiles[i].getName()+ newline; 
					int res=msg.length(); 
					
					combo.addItem(listOfFiles[i].getName());
				} 
			}
			
		}
		
	}


	
	private void downloadFile() throws IOException {
		// TODO Auto-generated method stub
		String selectedBook = (String) combo.getSelectedItem();
	    
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	    	//Please change directory as per your pc
	    	File source = new File("C:/Users/Shahana/Desktop/FileSystem/files/"+selectedBook); 
	    	File dest = new File("C:/Users/Shahana/Desktop/Download/"+selectedBook); 
	    	FileUtils.copyFile(source, dest);
	    	txt.append("File " +selectedBook+" downloaded successfully"+ "\n"); 
	    	String msg= "File " +selectedBook+" downloaded successfully"+ "\n"; 
	    	int res=msg.length(); 
	    	String httpMsg="Date:"+date;
			txt.append(httpMsg + newline);
	    	
	    }catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	    	
	    } finally {
			
			// closing I/O streams
	        
			is.close();
	        os.close();
			} 
	}    
		
	

	public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt;
    private javax.swing.JTextField txtIp;
    private JMenuBar menuBar;
    private JTextField textField;
    private JMenu mnNewMenu;
    private JMenu mnNewMenu_1;
    private JMenu mnNewMenu_2;
    private JLabel lblNewLabel;
    private JMenuItem mntmNewMenuItem;
    private JMenuItem mntmNewMenuItem_1;
    private JMenuItem mntmNewMenuItem_2;
}

