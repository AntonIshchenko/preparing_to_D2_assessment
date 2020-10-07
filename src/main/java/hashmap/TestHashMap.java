package hashmap;

public class TestHashMap {

   public static void main(String[] args) {

//      A.getChar();
//      B.getChar();

//      Collection<Entity> collection = new ArrayList<>();
//
//
//      for (int i = 0; i < 10; i++) {
//         collection.add(new Entity(i, "Name" + i));
//      }
//
//      Stream<Entity> entityStream = collection.stream().filter(e -> e.id > 20);
//      System.out.println(entityStream.count());
////      entityStream.map(e -> e.name).findFirst().orElse("nope");
////      System.out.println(nope);

   }
}

class B {
   B() {
      System.out.println("B constructor");
   }
}

class A extends B {
   A() {
      this(1);
      System.out.println("A() constructor");
   }

   A(int i) {
      System.out.println("A(int) constructor");
   }

   public static void main(String[] args) {
      new A();
   }
}
