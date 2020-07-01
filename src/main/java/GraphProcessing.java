import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphProcessing {

   public static FullGraph proceedGraph(String rootNode, FullGraph graph) {
      List<String> keys = getKeysWithFirstRootNode(graph, rootNode);
      return calculateDistances(graph, keys, rootNode);
   }

   private static String getNextName(List<String> keys, FullGraph graph) {
      Double minDistance = Double.POSITIVE_INFINITY;
      String minKey = "";
      for (String key : keys) {
         if (!graph.getNodes().get(key).isDone()) {
            if (minDistance > graph.getNodes().get(key).getDistance()) {
               minKey = key;
               minDistance = graph.getNodes().get(key).getDistance();
            }
         }
      }
      return minKey;
   }

   private static List<String> getKeysWithFirstRootNode(FullGraph graph, String rootNode) {
      Set<String> keySet = graph.getNodes().keySet();
      List<String> keys = new ArrayList<>();
      keys.add(rootNode);
      keySet.remove(rootNode);
      keys.addAll(keySet);
      return keys;
   }

   private static FullGraph calculateDistances(FullGraph graph, List<String> keys, String rootNode) {
      graph.getNodes().get(rootNode).setDistance(0d);
      Node currentNode = graph.getNodes().get(rootNode);
      String srcName = rootNode;

      for (int i = 0; i < keys.size(); i++) {
         Map<String, Double> connectedNodes = graph.getNodes().get(srcName).getPairsNodeDistance();

         for (String dstName : keys) {
            if (connectedNodes.containsKey(dstName)) {
               Double distance = graph.getNodes().get(srcName).getDistance() + currentNode.getPairsNodeDistance().get(dstName);
               if (distance < graph.getNodes().get(dstName).getDistance()) {
                  graph.getNodes().get(dstName).setDistance(distance);
               }
            }
         }

         graph.getNodes().get(srcName).setDone();
         srcName = getNextName(keys, graph);
         currentNode = graph.getNodes().get(srcName);
      }
      return graph;
   }

}

