import java.rmi.Naming;

public class ResourceManagerClient {
    public static void main(String[] args) {
        try {
            ResourceManager resourceManager = (ResourceManager) Naming.lookup("//localhost/ResourceManager");

            // Add resources
            resourceManager.addResource("Node1", "Resource1");
            resourceManager.addResource("Node2", "Resource2");

            // Get resources
            String resource1 = resourceManager.getResource("Node1");
            String resource2 = resourceManager.getResource("Node2");

            System.out.println("Resource from Node1: " + resource1);
            System.out.println("Resource from Node2: " + resource2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
