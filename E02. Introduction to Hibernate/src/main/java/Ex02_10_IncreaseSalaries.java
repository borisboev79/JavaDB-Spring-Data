import entities.Employee;
import auxiliary.MyEntityManager;

import java.util.List;

import static auxiliary.Queries.GET_DEPARTMENTS;

public class Ex02_10_IncreaseSalaries {
    public static void main(String[] args) {

        javax.persistence.EntityManager em = MyEntityManager.create();

        em.getTransaction().begin();

        List<Integer> deptIds = em.createQuery(GET_DEPARTMENTS, Integer.class).getResultList();

        em.createQuery("UPDATE Employee e SET e.salary = e.salary * 1.12 WHERE e.department.id IN (:id)").setParameter("id", deptIds)
                .executeUpdate();


        em.createQuery("SELECT e FROM Employee e WHERE e.department.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services')", Employee.class)
                .getResultList()
                .forEach(employee -> System.out.printf("%s %s ($%.2f)%n", employee.getFirstName(),
                        employee.getLastName(), employee.getSalary()));

        em.getTransaction().commit();
        em.close();


    }
}
