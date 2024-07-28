import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ResourceManagerServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // Create RMI registry on port 1099
            ResourceManager resourceManager = new ResourceManagerImplementation();
            Naming.rebind("ResourceManager", resourceManager);
            System.out.println("Resource Manager is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
