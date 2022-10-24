package Queries;

public enum RemoveVillainQueries {
    ;
    public static final String GET_VILLAIN_BY_ID = "SELECT name FROM villains WHERE id = ?";
    public static final String GET_MINION_COUNT_BY_VILLAINS_ID = "SELECT COUNT(minion_id) as count FROM minions_villains WHERE villain_id =?";
    public static final String DELETE_VILLAIN_FROM_MINIONS_VILLAINS = "DELETE FROM minions_villains WHERE villain_id = ?";
    public static final String DELETE_VILLAIN = "DELETE FROM villains WHERE id = ?";
}
