package entities;

import entities.auxiliary.AutoId;
import entities.auxiliary.ResultPredictionEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "result_predictions")
public class ResultPrediction extends AutoId {
    @Enumerated(EnumType.STRING)
    private ResultPredictionEnum prediction;
}
