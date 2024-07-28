import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class ResourceManagerImplementation extends UnicastRemoteObject implements ResourceManager {
    private Map<String, String> resources;

    protected ResourceManagerImplementation() throws RemoteException {
        resources = new HashMap<>();
    }

    @Override
    public String getResource(String resourceName) throws RemoteException {
        return resources.get(resourceName);
    }

    @Override
    public void addResource(String resourceName, String resourceValue) throws RemoteException {
        resources.put(resourceName, resourceValue);
    }
}