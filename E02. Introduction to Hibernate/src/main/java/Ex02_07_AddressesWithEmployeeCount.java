import auxiliary.MyEntityManager;
import entities.Address;

import javax.persistence.EntityManager;

import static auxiliary.Queries.GET_ADDRESSES_BY_EMPLOYEES;

public class Ex02_07_AddressesWithEmployeeCount {

    public static void main(String[] args) {

        EntityManager em = MyEntityManager.create();

        em.getTransaction().begin();

        em.createQuery(GET_ADDRESSES_BY_EMPLOYEES, Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(a -> System.out.printf("%s, %s - %d employees%n", a.getText(),
                        a.getTown().getName(), a.getEmployees().size()));

        em.getTransaction().commit();
        em.close();
    }
}
