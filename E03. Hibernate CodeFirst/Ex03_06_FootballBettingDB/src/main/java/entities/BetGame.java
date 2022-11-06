package entities;

import entities.auxiliary.BedGameId;
import jakarta.persistence.*;

@Entity
@Table(name = "bet_games")
public class BetGame {
    @EmbeddedId
    private BedGameId bedGameId;

    @OneToOne(optional = false)
    @JoinColumn(name = "result_prediction")
    private ResultPrediction resultPrediction;

    public BetGame(){}

    public BedGameId getBedGameId() {
        return bedGameId;
    }

    public void setBedGameId(BedGameId bedGameId) {
        this.bedGameId = bedGameId;
    }

    public ResultPrediction getPredictionResult() {
        return resultPrediction;
    }

    public void setPredictionResult(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }
}
