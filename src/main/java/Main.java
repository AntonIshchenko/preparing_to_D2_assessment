public class Main {

   public static void main(String[] args) {

      FullGraph result = GraphProcessing.proceedGraph(ConsoleInterface.getRootNode(), ConsoleInterface.getGraph());

      result.getNodes().entrySet().forEach(
            a -> System.out.println("Distance from " + ConsoleInterface.getRootNode() + " to " + a.getKey() + " = " + a.getValue().getDistance())
      );
   }

}
