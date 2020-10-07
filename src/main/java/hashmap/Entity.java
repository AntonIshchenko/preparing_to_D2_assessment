package hashmap;

import java.util.Objects;

public class Entity {

   long id;

   String name;

   public Entity(long id, String name) {
      this.id = id;
      this.name = name;
   }

   @Override public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Entity entity = (Entity) o;
      return id == entity.id &&
            Objects.equals(name, entity.name);
   }


   @Override public int hashCode() {
      int hash = Objects.hash(id, name);
      hash = hash & -16;
      return hash | 5;
   }
}
