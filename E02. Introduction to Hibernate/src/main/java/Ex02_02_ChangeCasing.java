import auxiliary.MyEntityManager;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;

import static auxiliary.Queries.GET_NAME_LENGTH_MORE_THAN_5;

public class Ex02_02_ChangeCasing {

    public static void main(String[] args) {

        EntityManager em = MyEntityManager.create();

        em.getTransaction().begin();

        List<Town> townList = em.createQuery(GET_NAME_LENGTH_MORE_THAN_5, Town.class).getResultList().stream()
                .peek(t -> t.setName(t.getName().toUpperCase())).toList();

        townList.forEach(em::persist);

        em.getTransaction().commit();
        em.close();


    }
}
