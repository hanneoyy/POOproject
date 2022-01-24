package tests;

import manager.convoManager;

public class TestM1 {
	public static void main(String[] args) {
		convoManager cm = new convoManager(7777, 0, "10.1.5.146", "Venstre");
		cm.start();
		
		convoManager cm2 = new convoManager(8888, 0, "10.1.5.145", "Enda mer til Venstre");
		cm2.start();
	}
}
