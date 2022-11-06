import auxiliary.MyEntityManager;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;

import static auxiliary.Queries.GET_ALL_TOWNS;

public class Ex02_02_ChangeCasing_With_Detach {

    public static void main(String[] args) {

        EntityManager em = MyEntityManager.create();

        em.getTransaction().begin();

        List<Town> filteredTowns = em.createQuery(GET_ALL_TOWNS, Town.class).getResultList().stream().filter(t -> t.getName().length() > 5).peek(em::detach).toList();

        List<Town> result = filteredTowns.stream().peek(t -> t.setName(t.getName().toUpperCase())).toList();


        em.getTransaction().commit();
        em.close();

    }
}
