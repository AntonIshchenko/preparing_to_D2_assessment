package classtypes;

public class Outer {

   private String firsName = "Private String";
   private static String secondName = "Private Static String";
   private static final String thirdName = "Private static String \n";
   private int number;

   public class PublicInner {

      public void printNames() {
         System.out.println(firsName);
         System.out.println(secondName);
         System.out.println(thirdName);
      }

   }

   private class PrivateInner {

      public void printNames() {
         System.out.println(firsName);
         System.out.println(secondName);
         System.out.println(thirdName);
      }
   }

   public static class NestedInner {

      public void printNames() {
         System.out.println("Cannot print first name because it's not static");
         System.out.println(secondName);
         System.out.println(thirdName);
      }
   }

   public PrivateInner getPrivateInner() {
      return new PrivateInner();
   }

   public void runPrivateClassMethod () {
      new PrivateInner().printNames();
   }

   public void createAnonymousClass() {
      int number = 5;
      final String local = "Final Local String";
      class ClassInMethod {
         public void printNames() {
//            System.out.println(number);// cannot print local variable because it's not final or effectively final
            System.out.println(local); // can print because it's class variable
            System.out.println(firsName); // can print because it's class variable
            System.out.println(secondName); // can print because it's class variable
            System.out.println(thirdName);
         }
      }
      number++;
      new ClassInMethod().printNames();
   }

}

