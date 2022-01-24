package gui;

import java.awt.Color;
import java.awt.event.*;
import bddDistante.BddDistante;
import user.User;
import message.Message;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ConvoGui extends JFrame {

	// Creating area to show history conversation
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JTable table = new JTable(tableModel);

	private static final long serialVersionUID = 1L;
	JLabel label;
	
	// creation de la fenetre
	public ConvoGui(ArrayList<Message> history) { // User LocalUser, User distantUser, ArrayList<Message> history
		// A ENLEVER!! Pour tester
		int localUserId = 11;
		int distantUserId = 12;
		
		//Créer un nouveau frame pour stocker le bouton
	    JFrame frame = new JFrame("Conversation avec " + "toto");
	    
	    this.tableModel.addColumn("time");
		this.tableModel.addColumn("sender");
		this.tableModel.addColumn("Received");
		this.tableModel.addColumn("Sent");
		this.tableModel.insertRow(0, new Object[] { "01/02/00", "TEST", "Veldig spent p om noe dukker opp" });
	    
	    String sentMessage, receivedMessage;
	    for (Message message : history) {
	    	if (message.getSender() == String.valueOf(localUserId)) {
	    		sentMessage = message.getMessage();
	    		receivedMessage = "";
	    	} else {
	    		sentMessage = "";
	    		receivedMessage = message.getMessage();
	    	}
	    	tableModel.insertRow(tableModel.getRowCount(), new Object[] { message.getDateTime(), message.getSender(), receivedMessage, sentMessage });
	    }
	    
	    // formatting table
	    this.table.getColumnModel().getColumn(0).setMinWidth(150);
	    this.table.getColumnModel().getColumn(1).setMinWidth(75);
	    this.table.getColumnModel().getColumn(2).setMinWidth(250);
	    this.table.getColumnModel().getColumn(3).setPreferredWidth(Integer.MAX_VALUE);
	    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    	rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
    	this.table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);	    
	    
	    this.table.setBounds(10,10,730,300);
	    this.table.setBackground(Color.gray);
	    
	    // text area
	    JLabel msg = new JLabel("new message : ");
	    final JTextArea newMessageArea = new JTextArea();
	    newMessageArea.setBounds(100, 400, 500, 150);
	    msg.setBounds(100, 350, 100, 15);
	    
	    //Créer le bouton
	    JButton sendButton = new JButton("Send");
	    //Définir la position du bouton
	    sendButton.setBounds(600,300,200,40);
	    sendButton.setPreferredSize(getPreferredSize());
	    
	    sendButton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	String res;
	                try {
						String message = newMessageArea.getText();
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					};
	        }
	    });	   
	    
	    //Ajouter le bouton et le textArea au frame
	    frame.add(sendButton);
	    frame.add(newMessageArea);
	    frame.add(msg);
	    // frame.add(new JScrollPane(table));
	    frame.add(table);
	    frame.setSize(750,600);
	    frame.setLayout(null);
	    frame.setVisible(true);  
	    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close application
	}
	
	public void updateTable(Message message){
		int localUserId = 11; // A ENLEVER
		String sentMessage, receivedMessage;
		System.out.println(message.getSender());
		if (message.getSender() == String.valueOf(localUserId)) {
	    	sentMessage = message.getMessage();
	    	receivedMessage = "";
	    } else {
	    	sentMessage = "";
	    	receivedMessage = message.getMessage();
	    }
	    this.tableModel.insertRow(tableModel.getRowCount(), new Object[] { message.getDateTime(), message.getSender(), receivedMessage, sentMessage });
		// this.table.repaint();
		tableModel.fireTableDataChanged();

	}
	
	public static void main(String[] args) {
		// User localUser = new User("Toto", );
		// new ConvoGui(localUser, distantUser);
		// new ConvoGui();
	}
}
