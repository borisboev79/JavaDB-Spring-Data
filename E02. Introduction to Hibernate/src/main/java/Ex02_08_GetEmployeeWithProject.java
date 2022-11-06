import entities.Employee;
import auxiliary.MyEntityManager;
import entities.Project;

import javax.persistence.EntityManager;
import java.util.Scanner;
import java.util.stream.Collectors;

import static auxiliary.Queries.GET_EMPLOYEES_BY_ID;

public class Ex02_08_GetEmployeeWithProject {

    public static void main(String[] args) {

        EntityManager em = MyEntityManager.create();
        final int empId = new Scanner(System.in).nextInt();

        em.getTransaction().begin();

        Employee employee = em.createQuery(GET_EMPLOYEES_BY_ID + ":id", Employee.class)
                .setParameter("id", empId)
                .getSingleResult();

        System.out.printf("%s %s - %s%n%s", employee.getFirstName(), employee.getLastName(),
                employee.getJobTitle(), employee.getProjects().stream()
                        .map(Project::getName)
                        .sorted()
                        .collect(Collectors.joining(System.lineSeparator())));


        em.getTransaction().commit();
        em.close();
    }
}
