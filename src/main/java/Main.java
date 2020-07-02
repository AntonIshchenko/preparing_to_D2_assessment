import dijkstraalgorithm.DijkstraAlgorithmRunner;

public class Main {

   public static void main(String[] args) {



      runDijkstra();
   }

   private static void runDijkstra() {
      Thread thread1 = new Thread(new DijkstraAlgorithmRunner());
      thread1.start();
   }

}
