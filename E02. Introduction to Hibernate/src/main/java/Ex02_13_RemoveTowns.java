import auxiliary.MyEntityManager;
import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

import static auxiliary.Queries.GET_ADDRESSES_BY_TOWN_NAME;
import static auxiliary.Queries.GET_TOWN_NAME;

public class Ex02_13_RemoveTowns {
    public static void main(String[] args) {
        EntityManager em = MyEntityManager.create();

        String input = new Scanner(System.in).nextLine();

        List<Address> forDeletion = em.createQuery(GET_ADDRESSES_BY_TOWN_NAME + ":tn", Address.class)
                .setParameter("tn", input)
                .getResultList();

        int deletedCount = forDeletion.size();

        em.getTransaction().begin();

        for (Address address : forDeletion) {
            address.getEmployees().forEach(e -> e.setAddress(null));
            em.remove(address);
        }

        Town town = em.createQuery(GET_TOWN_NAME + ":tn", Town.class)
                .setParameter("tn", input)
                .getSingleResult();
        em.remove(town);

        String wordForAddress = deletedCount == 1 ? "address" : "addresses";

        System.out.printf("%d %s in %s deleted", deletedCount, wordForAddress, input);

        em.getTransaction().commit();
        em.close();
    }
}
