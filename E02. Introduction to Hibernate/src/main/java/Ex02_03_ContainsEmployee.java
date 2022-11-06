import auxiliary.MyEntityManager;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class Ex02_03_ContainsEmployee {

    public static void main(String[] args) {
        EntityManager em = MyEntityManager.create();

        final String[] name = new Scanner(System.in).nextLine().split(" ");
        final String firstName = name[0];
        final String lastName = name[1];

        em.getTransaction().begin();

        final Long match = em.createQuery("SELECT count(e) FROM Employee e WHERE e.firstName = :fn AND e.lastName = :ln", Long.class)
                .setParameter("fn", firstName)
                .setParameter("ln", lastName)
                .getSingleResult();

        System.out.println(match == 0 ? "No" : "Yes");

        em.getTransaction().commit();
        em.close();

    }
}
