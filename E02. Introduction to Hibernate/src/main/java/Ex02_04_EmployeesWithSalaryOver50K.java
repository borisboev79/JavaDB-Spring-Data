import auxiliary.MyEntityManager;

import javax.persistence.EntityManager;

import static auxiliary.Queries.GET_SALARY_OVER_50000;

public class Ex02_04_EmployeesWithSalaryOver50K {

    public static void main(String[] args) {
        EntityManager em = MyEntityManager.create();

        em.getTransaction().begin();

        em.createQuery(GET_SALARY_OVER_50000, String.class)
                .getResultList()
                .forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
    }
}
