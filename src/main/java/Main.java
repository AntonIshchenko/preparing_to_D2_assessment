public class Main {

   public static void main(String[] args) {

      FullGraph result = GraphProcessing.proceedGraph(ConsoleInterface.getRootNode(), ConsoleInterface.getGraph());

      result.getNodes().keySet().forEach(a -> System.out.println("Distance to " + a + " = " + result.getNodes().get(a).getDistance()));
   }
   
}
