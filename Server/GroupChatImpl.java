import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
 
public class GroupChatImpl extends UnicastRemoteObject implements GroupChatInterface{
	
	private Hashtable l=new Hashtable();
	 
	public GroupChatImpl() throws RemoteException{ }
	
	public boolean login(MessengerInterface m) throws RemoteException{
		l.put(m.getUsername(), m);
		m.tell("[Server] Welcome Client "+m.getUsername());
		return true;
	}	
	public void sendToAll(String s,MessengerInterface from) throws RemoteException{
		System.out.println("\n["+from.getUsername()+"] "+s);
		Enumeration usernames = l.keys();
        while(usernames.hasMoreElements()){
		       String user=(String) usernames.nextElement();
		       MessengerInterface m=(MessengerInterface)l.get(user);
		       if (user.equals(from.getUsername())){continue;}
		       
		       try{
		    	   m.tell("\n["+from.getUsername()+"] "+s);
		       }catch(Exception e){e.printStackTrace();}
        }
	}	  
	public MessengerInterface getMessenger(String username)  throws RemoteException{
		MessengerInterface m=(MessengerInterface)l.get(username);
		return m;
	}	  
}