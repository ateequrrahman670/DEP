import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ResourceManager extends Remote {
    String getResource(String resourceName) throws RemoteException;
    void addResource(String resourceName, String resourceValue) throws RemoteException;
}