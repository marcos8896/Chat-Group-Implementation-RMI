import java.rmi.*;
import java.rmi.server.*;
 
public class Messenger extends UnicastRemoteObject implements MessengerInterface{
 
	private String username;
	private GroupChatInterface server;
	public Messenger(String u, GroupChatInterface s) throws RemoteException {
		username=u;
		server=s;
	}
	public String getUsername() throws RemoteException{
		return username;	
	}
	public void tell(String s) throws RemoteException{		
		System.out.println(s);		
	}
}