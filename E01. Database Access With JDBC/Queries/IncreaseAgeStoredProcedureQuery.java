package Queries;

public enum IncreaseAgeStoredProcedureQuery {
    ;
    public static final String CREATE_PROCEDURE = "CALL usp_get_older(?)";
    public static final String GET_UPDATED_MINION = "SELECT name, age FROM minions WHERE id = ?";
}
