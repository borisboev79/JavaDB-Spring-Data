package Queries;

public enum PrintAllMinionNamesQueries {
    ;
    public static final String ASCENDING_NAMES_QUERY = "SELECT id, name FROM minions ORDER BY id";
    public static final String DESCENDING_NAMES_QUERY = "SELECT id, name FROM minions ORDER BY id DESC";
}
