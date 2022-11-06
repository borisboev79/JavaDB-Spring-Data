package entities.auxiliary;

import entities.Bet;
import entities.Game;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BetGameId implements Serializable {
    @ManyToOne
    @JoinColumn
    private Bet bet;

    @ManyToOne
    @JoinColumn
    private Game game;

    public BetGameId() {
    }

    public BetGameId(Bet bet, Game game) {
        this.bet = bet;
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BetGameId betGameId)) return false;
        return bet.equals(betGameId.bet) && game.equals(betGameId.game);
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
