package entities.auxiliary;

public enum ResultPredictionEnum {

    HOME_TEAM_WIN("1"),
    DRAW_GAME("x"),
    AWAY_TEAM_WIN("2");

    private String result;

    ResultPredictionEnum(String result) {
        this.result = result;
    }

}
