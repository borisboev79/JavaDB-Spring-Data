import auxiliary.MyEntityManager;
import entities.Employee;

import java.math.BigDecimal;
import java.util.List;

import static auxiliary.Queries.GET_DEPARTMENTS;

public class Ex02_10_IncreaseSalaries_FP {
    public static void main(String[] args) {

        javax.persistence.EntityManager em = MyEntityManager.create();

        em.getTransaction().begin();

       em.createQuery(GET_DEPARTMENTS, Employee.class)
                .getResultList()
                .stream()
                .peek(e -> e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12))))
                .peek(em::persist)
                .forEach(e -> System.out.printf("%s %s ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getSalary()));

        em.getTransaction().commit();
        em.close();


    }
}
