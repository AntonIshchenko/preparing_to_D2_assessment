package dijkstraalgorithm;

public class DijkstraAlgorithmRunner implements Runnable {

   @Override
   public void run() {
      GraphProcessing
            .proceedGraph(ConsoleInterface.getRootNode(), ConsoleInterface.getGraph())
            .getNodes()
            .forEach((key, value) -> System.out.println("Distance from " + ConsoleInterface.getRootNode() + " to " + key + " = " + value.getDistance()));
   }

}
