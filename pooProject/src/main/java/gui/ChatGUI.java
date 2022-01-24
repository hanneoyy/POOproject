package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import manager.convoManager;
import message.Message;

public class ChatGUI implements ActionListener{
	JFrame frame;
	final JTextArea chatArea;
	final JTextField msg;
	JButton sendBtn;
	convoManager cm;
	String distantPseudo;
	
	public ChatGUI(convoManager cm, String distantPseudo, ArrayList<Message> history, String distantIP) {
		this.cm = cm;
		this.distantPseudo = distantPseudo;
		
		this.frame = new JFrame("chat window");		
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
		
		for (Message message : history) {
			message.printMessage();
			System.out.println("ICCCIIIIII DISTANTIP : " + distantIP);
			System.out.println("ICCCIIIIII MESSAGE.SENDER : " + message.getSender());
			if ((message.getSender() == distantIP)) {
				this.chatArea.setText(chatArea.getText().trim() + "\n\n  " + this.distantPseudo + " : " + message.getMessage());
			} else {
				this.chatArea.setText(this.chatArea.getText().trim() + "\n\n  You : " + message.getMessage());
			}
		}
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void newMessage(String message) {
		this.chatArea.setText(chatArea.getText().trim() + "\n\n  " + this.distantPseudo + " : " + message);
	}
	
	public static void main(String[] args) {
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String msg_out = "";
    	msg_out = msg.getText().trim();
    	this.chatArea.setText(this.chatArea.getText().trim() + "\n\n  You : " + msg_out);
		this.cm.sendMessage(msg_out);
		msg.setText("");
	}		
}
