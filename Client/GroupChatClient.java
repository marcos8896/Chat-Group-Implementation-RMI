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
		      System.out.println("[System] Client Messenger is running");
		      System.out.println("Enter a username to login and press Enter:");
		      String username = scanner.nextLine();
		      MessengerInterface m=new Messenger(username,server);
		      server.login(m);
		      server.sendToAll("Just Connected",m);	
		      for(;;){  	
		    	  String aa = scanner.nextLine();
				  server.sendToAll(aa,m);				    		  				  				    	  
	    	  }
       }catch (Exception e) {
          System.out.println("Hello Client exception: " + e);
          e.printStackTrace();
       }
    }
}