import auxiliary.MyEntityManager;
import entities.Employee;

import javax.persistence.EntityManager;

public class Ex02_05_EmployeesFromDepartment {

    private static final String PRINT_EMP_FORMAT = "%s %s from %s - $%.2f%n";

    public static void main(String[] args) {

        EntityManager em = MyEntityManager.create();

        em.getTransaction().begin();
        String department = "Research and Development";

        em.createQuery("SELECT e FROM Employee e " +
                        " WHERE e.department.name = :dp" +
                        " ORDER BY e.salary ASC, e.id", Employee.class)
                .setParameter("dp", department)
                .getResultList()
                .forEach(e -> System.out.printf(PRINT_EMP_FORMAT, e.getFirstName(), e.getLastName(),
                        e.getDepartment().getName(), e.getSalary()));

        em.getTransaction().commit();
        em.close();
    }
}
