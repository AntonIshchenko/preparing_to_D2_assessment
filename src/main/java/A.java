public class A {
   public static void main(String[] args) {
      StringBuilder sb1 = new StringBuilder("2a");
      StringBuilder sb2 = new StringBuilder("2a");

      System.out.print(sb1 == sb2);
      System.out.print(sb1.equals(sb2));
   }
}
