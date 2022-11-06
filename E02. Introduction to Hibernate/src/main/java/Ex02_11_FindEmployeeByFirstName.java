import auxiliary.MyEntityManager;
import entities.Employee;

import javax.persistence.EntityManager;
import java.util.Scanner;

import static auxiliary.Queries.GET_NAMES_BY_PATTERN;

public class Ex02_11_FindEmployeeByFirstName {
    public static void main(String[] args) {
        EntityManager em = MyEntityManager.create();

        String input = new Scanner(System.in).nextLine();

        em.getTransaction().begin();

        em.createQuery(GET_NAMES_BY_PATTERN + ":ptn", Employee.class)
                .setParameter("ptn", input + "%")
                .getResultList()

                        .forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));

        em.getTransaction().commit();
        em.close();
    }
}
