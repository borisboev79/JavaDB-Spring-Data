package entities;

import entities.auxiliary.BetGameId;
import jakarta.persistence.*;

@Entity
@Table(name = "bet_games")
public class BetGame {
    @EmbeddedId
    private BetGameId betGameId;

    @OneToOne(optional = false)
    @JoinColumn(name = "result_prediction")
    private ResultPrediction resultPrediction;

    public BetGame(){}

    public BetGameId getBedGameId() {
        return betGameId;
    }

    public void setBedGameId(BetGameId betGameId) {
        this.betGameId = betGameId;
    }

    public ResultPrediction getPredictionResult() {
        return resultPrediction;
    }

    public void setPredictionResult(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }
}
