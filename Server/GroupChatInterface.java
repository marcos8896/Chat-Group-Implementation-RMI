import java.rmi.*;
 
public interface GroupChatInterface extends Remote {
 
	  public boolean login (MessengerInterface m) throws RemoteException;
 
	  public void sendToAll(String s, MessengerInterface from) throws RemoteException;
 
	  public MessengerInterface getMessenger(String username)  throws RemoteException;
 
}