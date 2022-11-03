package Queries;

public enum AddMinionsQueries {
    ;
    public static final String GET_TOWN_BY_NAME = "SELECT t.id FROM towns AS t WHERE t.name = ?";
    public static final String GET_MINION_BY_NAME = "SELECT m.id FROM minions AS m WHERE m.name = ?";
    public static final String GET_VILLAIN_BY_NAME = "SELECT v.id FROM villains AS v WHERE v.name = ?";

    public static final String INSERT_INTO_TOWNS = "INSERT INTO towns(name) values(?)";
    public static final String INSERT_INTO_VILLAINS = "INSERT INTO villains(name, evilness_factor) values(?, 'evil')";
    public static final String ADD_MINION = "INSERT INTO minions (name, age, town_id) values(?,?,?)";
    public static final String ASSIGN_MINION_TO_VILLAIN = "INSERT INTO minions_villains (minion_id, villain_id) VALUES (?, ?)";
}
