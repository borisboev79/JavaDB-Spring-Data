package entities.auxiliary;

import entities.Bet;
import entities.Game;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BedGameId implements Serializable {
    @ManyToOne
    @JoinColumn
    private Bet bet;

    @ManyToOne
    @JoinColumn
    private Game game;

    public BedGameId() {
    }

    public BedGameId(Bet bet, Game game) {
        this.bet = bet;
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BedGameId bedGameId)) return false;
        return bet.equals(bedGameId.bet) && game.equals(bedGameId.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bet, game);
    }

    public Bet getBet() {
        return bet;
    }

    public Game getGame() {
        return game;
    }
}
