package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;

public class chat_server {
	
	static ServerSocket ss;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;

	public static void main(String[] args) {		
		/* ==============================================
		 * -------------------- FRAME -------------------
		   ============================================== */
		// Creation de la fenetre
		JFrame frame = new JFrame("Server");
		
		// Espace de chat
		final JTextArea chat = new JTextArea();
		chat.setBounds(50, 50, 675, 300);
		
		// Espace de messages 
		final JTextField msg = new JTextField();
		msg.setBounds(50, 375, 500, 30);
		
		// Bouton d'envoi
		JButton sendBtn = new JButton("Send");
		sendBtn.setBounds(575, 375, 150, 30);
		
		sendBtn.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	String msg_out = "";
	        	msg_out = msg.getText().trim();
	        	System.out.println(msg_out);
	        	try {
					dout.writeUTF(msg_out);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	chat.setText(chat.getText().trim() + "\n\nServer : " + msg_out);
	        }
	    });
		
		// ajout d'elements a la fenetre
		frame.add(chat);
		frame.add(msg);
		frame.add(sendBtn);
		// parametres de la fenetre
		frame.setSize(750,600);
	    frame.setLayout(null);
	    frame.setVisible(true);  
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    /* ==============================================
		 * ------------------- SERVER -------------------
		   ============================================== */
		
		String msg_in = "";
		try {
			ss = new ServerSocket(1501);
			s = ss.accept();
			
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			
			while(!msg_in.equals("exit!")) {
				msg_in = din.readUTF();
				chat.setText(chat.getText().trim() + "\n\nClient : " + msg_in);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
