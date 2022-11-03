package entities;

import jakarta.persistence.*;

@Entity
@Table
public class Round {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
