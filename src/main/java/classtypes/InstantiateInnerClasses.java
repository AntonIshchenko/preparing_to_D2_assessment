package classtypes;

public class InstantiateInnerClasses {

   private InstantiateInnerClasses() {}

   public static void main() {
      Outer outer = new Outer();
      Outer.PublicInner publicInner = new Outer().new PublicInner();
      publicInner.printNames();
      Outer.NestedInner nestedInner = new Outer.NestedInner();
      nestedInner.printNames();
      //Outer.PrivateInner privateInner = outer.getPrivateInner(); can not access private class
      outer.runPrivateClassMethod();
      outer.createAnonymousClass();
   }

}
