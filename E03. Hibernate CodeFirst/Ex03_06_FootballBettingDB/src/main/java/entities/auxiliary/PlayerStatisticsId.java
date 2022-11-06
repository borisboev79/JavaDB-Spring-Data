package entities.auxiliary;

import entities.Game;
import entities.Player;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

public class PlayerStatisticsId implements Serializable {
    @ManyToOne
    @JoinColumn
    private Game game;

    @ManyToOne
    @JoinColumn
    private Player player;

    public PlayerStatisticsId() {
    }

    public PlayerStatisticsId(Game game, Player player) {
        this.game = game;
        this.player = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerStatisticsId that)) return false;
        return game.equals(that.game) && player.equals(that.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, player);
    }

}
