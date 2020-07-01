import java.util.HashMap;
import java.util.Map;

public class Node {

   private boolean done = false;
   private Double distance = Double.POSITIVE_INFINITY;
   private Map<String, Double> pairNodeDistance = new HashMap<>();

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
      pairNodeDistance.put(name, distance);
   }

   public Map<String, Double> getPairsNodeDistance() {
      return new HashMap<>(pairNodeDistance);
   }

}
