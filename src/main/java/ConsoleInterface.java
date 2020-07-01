import java.util.Scanner;
import java.util.Set;

public class ConsoleInterface {

   private static final FullGraph graph = new FullGraph();
   private static Scanner input = new Scanner(System.in);
   private static String rootNode;

   private ConsoleInterface(){}

   public static String getRootNode() {
      if(rootNode == null)
         getGraphFromInput();
      return rootNode;
   }

   public static FullGraph getGraph() {
      if (rootNode == null)
         getGraphFromInput();
      return graph;
   }

   private static void getGraphFromInput() {
      fillGraphWithNodes();
      setDistancesBetweenNodes();
      rootNode = setRootNode();
      input.close();
   }

   private static void fillGraphWithNodes() {
      System.out.println("Введите название всех нод графа, введите 'stop' чтобы закончить:");
      Scanner input = new Scanner(System.in);
      while (input.hasNext()) {
         String in = input.next();
         if (in.equals("stop"))
            break;
         graph.addNode(in, new Node());
      }
   }

   private static void setDistancesBetweenNodes() {
      System.out.println("Введите расстояния между нодами графа, -1 eсли ноды не соединены:");
      Set<String> allNames = graph.getNodes().keySet();
      for (String srcName : allNames) {
         for (String dstName : allNames) {
            if (srcName.equals(dstName))
               continue;
            System.out.println(srcName + "->" + dstName);
            String in = input.next();
            if (in.equals("-"))
               continue;
            graph.getNodes().get(srcName).setDestination(dstName, Double.parseDouble(in));
         }
      }
   }

   private static String setRootNode() {
      System.out.println("Введите имя корневой ноды:");
      int cnt = 0;
      while (cnt < 3) {
         String root = input.next();
         if (graph.getNodes().containsKey(root)) {
            rootNode = root;
            break;
         }
         System.out.println("Выберите из созданных нод: " + graph.getNodes().keySet().toString());
         cnt++;
      }
      return rootNode;
   }

}
