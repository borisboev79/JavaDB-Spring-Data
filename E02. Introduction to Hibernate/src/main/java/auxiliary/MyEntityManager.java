package auxiliary;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public enum MyEntityManager {
    ;

    public static EntityManager create(){
        return Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
    }
}
