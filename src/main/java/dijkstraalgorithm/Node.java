package dijkstraalgorithm;

import java.util.HashMap;
import java.util.Map;

public class Node {

   private boolean done = false;
   private Double distance = Double.POSITIVE_INFINITY;
   private Map<String, Double> connectedNodes = new HashMap<>();

   public Double getDistance() {
      return distance;
   }

   public void setDistance(Double distance) {
      this.distance = distance;
   }

   public boolean isDone() {
      return done;
   }

   public void setDone() {
      done = true;
   }

   public void setDestination(String name, Double distance) {
      connectedNodes.put(name, distance);
   }

   public Map<String, Double> getConnectedNodes() {
      return new HashMap<>(connectedNodes);
   }

}
