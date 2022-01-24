package tests;

import manager.convoManager;

public class TestM3 {
	public static void main(String[] args) {
		convoManager cm = new convoManager(7777, 8888, "10.1.5.147", "Hoyre");
		cm.start();
		
		//Manager manager2 = new Manager();
		//manager2.start();
		//manager2.requestConversation("10.1.5.126");
	}

}
