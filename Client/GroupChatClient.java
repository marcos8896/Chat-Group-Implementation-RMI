import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.io.*;
import java.util.*;
 
public class GroupChatClient {
 
    public static void main(String[] args) {
      try {
		      // System.setSecurityManager(new RMISecurityManager());
		      GroupChatInterface server = (GroupChatInterface)Naming.lookup("rmi://localhost:2010/groupchat");
		      	
		      Scanner scanner=new Scanner(System.in);
		      System.out.println("[System] Client Messenger esta corriendo.");
		      System.out.print("Escribe tu nombre y presiona enter: ");
		      String username = scanner.nextLine();
		      MessengerInterface m=new Messenger(username,server);
		      server.login(m);
		      server.sendToAll("Conectado" + "\n",m);	
		      for(;;){  	
		    	  String aa = scanner.nextLine();
          server.sendToAll(aa,m);
		      System.out.print(username + ": ");
          
	    	  }
       }catch (Exception e) {
          System.out.println("Client Exception: " + e);
          e.printStackTrace();
       }
    }
}