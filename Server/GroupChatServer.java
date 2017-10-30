import java.rmi.*;
import java.rmi.server.*;
 
public class GroupChatServer {
    public static void main(String[] args) {
         try {
        	 	// System.setSecurityManager(new RMISecurityManager());        	 	
				GroupChatImpl obj=new GroupChatImpl();
                Naming.rebind("rmi://localhost:2010/groupchat", obj);
 
                System.out.println("[System] Chat Server is ready.");               
	 }catch (Exception e) {
         System.out.println("Chat Server failed: " + e);
      }
    }
}