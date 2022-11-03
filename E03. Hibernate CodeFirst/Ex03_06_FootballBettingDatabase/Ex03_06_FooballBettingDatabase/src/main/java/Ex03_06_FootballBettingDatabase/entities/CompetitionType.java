package Ex03_06_FootballBettingDatabase.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "competition_types")
public class CompetitionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column
    private long id;

    @Column
    private String name;

}