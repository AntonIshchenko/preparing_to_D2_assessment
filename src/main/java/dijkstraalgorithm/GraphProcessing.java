package dijkstraalgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphProcessing {

   private GraphProcessing() {}

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
      Map<String, Node> graphNodes = graph.getNodes();
      graphNodes.get(rootNode).setDistance(0d);
      Node currentNode = graphNodes.get(rootNode);
      String srcKey = rootNode;

      for (int i = 0; i < keys.size(); i++) {
         Map<String, Double> connectedNodes = graphNodes.get(srcKey).getConnectedNodes();

         for (String dstKey : keys) {
            if (connectedNodes.containsKey(dstKey)) {
               Double distance = graphNodes.get(srcKey).getDistance() + currentNode.getConnectedNodes().get(dstKey);
               if (distance < graphNodes.get(dstKey).getDistance()) {
                  graphNodes.get(dstKey).setDistance(distance);
               }
            }
         }

         graphNodes.get(srcKey).setDone();
         srcKey = getNextName(keys, graph);
         if (srcKey.isEmpty()) {
            break;
         }
         currentNode = graphNodes.get(srcKey);
      }
      return graph;
   }

}

