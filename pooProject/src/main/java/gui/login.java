package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class login {
	
	public static void main(String[] args) {
		// Creation de la fenetre
		JFrame frame = new JFrame("Login");
		
		// Partie pseudo
		JLabel pseudoLbl = new JLabel("User : ");
		pseudoLbl.setBounds(90, 70, 100, 30);
		JTextField pseudo = new JTextField();
		pseudo.setBounds(170, 70, 300, 30);
		
		// Bouton pour soumettre le formulaire 
		JButton submit = new JButton("Submit");
		submit.setBounds(370, 120, 100, 30);
		
		// comparer ce qui est entré avec les pseudos presents dans la bdd 
		// si valide alors ajouter un utilisateur
		// sinon demander à réécrire
		
		// ajouter les elements a la fenetre
		frame.add(pseudoLbl);
		frame.add(pseudo);
		frame.add(submit);
		// parametres de la fenetre
 		frame.setSize(750,600);
 	    frame.setLayout(null);
 	    frame.setVisible(true);  
 	    
 	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fermeture de l'application
	}
}
