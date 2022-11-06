package entities;

import entities.auxiliary.AutoId;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bets")
public class Bet extends AutoId {
    @Column(name = "bet_money")
    private double betMoney;

    @Column(name = "date_time")
    private LocalDateTime betDateAndTime;

    @ManyToOne
    @JoinColumn
    private User user;

    public Bet(){}

    public double getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(double betMoney) {
        this.betMoney = betMoney;
    }

    public LocalDateTime getBetDateAndTime() {
        return betDateAndTime;
    }

    public void setBetDateAndTime(LocalDateTime betDateAndTime) {
        this.betDateAndTime = betDateAndTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
