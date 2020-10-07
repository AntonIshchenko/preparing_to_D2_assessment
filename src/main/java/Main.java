import classtypes.InstantiateInnerClasses;
import dijkstraalgorithm.DijkstraAlgorithmRunner;
import streams.HandleEmployees;

import java.util.regex.Pattern;

public class Main {

   public static void main(String[] args) {

      String s1 = "All match string";
      String s2 = "All";

      String wildcardForRegex = s2.replace("*",".*").replace("_", ".");
      System.out.println(Pattern.matches(wildcardForRegex, s1));

      String s3 = s2.replace("*","");
      System.out.println(s3);

      System.out.println(s1.contains(s3));

   }

   private static void runDijkstra() {
      Thread thread1 = new Thread(new DijkstraAlgorithmRunner());
      thread1.start();
   }

   protected static void runStreams() {
      Thread thread2 = new Thread(new HandleEmployees());
      thread2.start();
   }

}


//      runStreams();
//      InstantiateInnerClasses.main();
//      runDijkstra();