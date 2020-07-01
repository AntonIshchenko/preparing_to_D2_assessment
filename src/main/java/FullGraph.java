import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FullGraph {

   private Map<String, Node> nodes = new LinkedHashMap<>();

   public void addNode(String name, Node node) {
      nodes.put(name, node);
   }

   public Map<String, Node> getNodes() {
      return new HashMap<>(nodes);
   }

}
