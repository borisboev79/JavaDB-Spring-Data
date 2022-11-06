import auxiliary.MyEntityManager;

import javax.persistence.EntityManager;

import static auxiliary.Queries.GET_DEPARTMENTS_MAX_SALARIES;

public class Ex02_12_EmployeesMaxSalaries {
    public static void main(String[] args) {
        EntityManager em = MyEntityManager.create();

        em.getTransaction().begin();

        em.createQuery(GET_DEPARTMENTS_MAX_SALARIES, Object[].class)
                .getResultList()
                .forEach(e -> System.out.printf("%s %.2f%n", e[0], e[1]));

        em.getTransaction().commit();
        em.close();

    }
}
