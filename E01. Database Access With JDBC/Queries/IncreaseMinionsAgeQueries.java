package Queries;

public enum IncreaseMinionsAgeQueries {
    ;
    public static final String UPDATE_MINIONS = "UPDATE minions SET name = LOWER(name), age = age + 1 WHERE id IN (%s)";
    public static final String SELECT_ALL_MINIONS = "SELECT name, age FROM minions";
}
