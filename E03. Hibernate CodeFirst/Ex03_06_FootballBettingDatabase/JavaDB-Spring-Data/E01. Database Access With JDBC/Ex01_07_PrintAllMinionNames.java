import Enums.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Queries.PrintAllMinionNamesQueries.ASCENDING_NAMES_QUERY;
import static Queries.PrintAllMinionNamesQueries.DESCENDING_NAMES_QUERY;

public class Ex01_07_PrintAllMinionNames {

    public static void main(String[] args) throws SQLException {
        Connection connection = Utils.getSQLConnection();

        List<String> minions = getNamesFromDB(connection, ASCENDING_NAMES_QUERY);
        List<String> minionsDesc = getNamesFromDB(connection, DESCENDING_NAMES_QUERY);

        for (int i = 0; i <= minions.size() / 2 - 1; i++) {
            System.out.println(minions.get(i));
            System.out.println(minionsDesc.get(i));
        }
        connection.close();

    }

    private static List<String> getNamesFromDB(Connection connection, String ascendingNamesQuery) throws SQLException {
        PreparedStatement ascendingNames = connection.prepareStatement(ascendingNamesQuery);

        ResultSet minionList = ascendingNames.executeQuery();

        List<String> minions = new ArrayList<>();

        while (minionList.next()) {
            String name = minionList.getString("name");
            minions.add(name);
        }
        return minions;
    }
}
