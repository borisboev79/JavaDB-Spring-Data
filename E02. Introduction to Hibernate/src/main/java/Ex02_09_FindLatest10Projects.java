import auxiliary.MyEntityManager;
import entities.Project;

import javax.persistence.EntityManager;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

import static auxiliary.Queries.GET_PROJECTS_BY_START_DATE;

public class Ex02_09_FindLatest10Projects {
    public static void main(String[] args) {
        EntityManager em = MyEntityManager.create();

        em.getTransaction().begin();

        em.createQuery(GET_PROJECTS_BY_START_DATE, Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf("Project name: %s%n" +
                        "\t\tProject Description: %s%n" +
                        "\t\tProject Start Date: %s%n" +
                        "\t\tProject End Date: %s%n",
                        p.getName(),
                        p.getDescription(),
                        p.getStartDate().minusHours(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")),
                        p.getEndDate()));


        em.getTransaction().commit();
        em.close();
    }
}
