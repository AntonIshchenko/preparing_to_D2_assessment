import dijkstraalgorithm.DijkstraAlgorithmRunner;
import streams.HandleEmployees;

public class Main {

   public static void main(String[] args) {
      //runStreams();
      //      InstantiateInnerClasses.main();
      //      runDijkstra();
   }

   private static void runDijkstra() {
      Thread thread1 = new Thread(new DijkstraAlgorithmRunner());
      thread1.start();
   }

   private static void runStreams() {
      Thread thread2 = new Thread(new HandleEmployees());
      thread2.start();
   }
}
