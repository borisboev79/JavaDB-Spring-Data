import auxiliary.MyEntityManager;
import entities.Address;

import javax.persistence.EntityManager;
import java.util.Scanner;

import static auxiliary.Queries.UPDATE_ADDRESS;

public class Ex02_06_AddNewAddressAndUpdateEmployee {

    public static void main(String[] args) {
        EntityManager em = MyEntityManager.create();
        String lastName = new Scanner(System.in).nextLine();

        em.getTransaction().begin();
        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");

        em.persist(newAddress);

        int count = em.createQuery(UPDATE_ADDRESS + ":ad WHERE e.lastName = :ln")
                .setParameter("ln", lastName)
                .setParameter("ad", newAddress)
                .executeUpdate();

        if (count > 0) {
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
        }
        em.close();

    }
}
