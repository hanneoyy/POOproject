package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import conversation.convoController;
import user.User;

public class chat implements ActionListener{
	JFrame frame;
	final JTextArea chatArea;
	final JTextField msg;
	JButton sendBtn;
	convoController controller;
	
	public chat(User distantUser, convoController ctrl) {
		
		this.controller = ctrl;
		
		this.frame = new JFrame(distantUser.pseudo);
		
		this.chatArea = new JTextArea();
		this.chatArea.setBounds(50, 50, 675, 300);
		
		this.msg = new JTextField();
		this.msg.setBounds(50, 375, 500, 30);
		
		this.sendBtn = new JButton("Send");
		this.sendBtn.setBounds(575, 375, 150, 30);
		
		this.sendBtn.addActionListener(this);
		
		// ajout d'elements a la fenetre
		this.frame.add(chatArea);
		this.frame.add(msg);
		this.frame.add(sendBtn);
		
		// parametres de la fenetre
		this.frame.setSize(750,600);
		this.frame.setLayout(null);
		this.frame.setVisible(true);  
			    
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void newMessage(String message) {
		this.chatArea.setText(chatArea.getText().trim() + "\n\nClient : " + message);
	}
	
	public static void main(String[] args) {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String msg_out = "";
    	msg_out = msg.getText().trim();
    	chatArea.setText(chatArea.getText().trim() + "\n\nServer : " + msg_out);
		this.controller.sendMessage(msg_out);
		
	}
}
