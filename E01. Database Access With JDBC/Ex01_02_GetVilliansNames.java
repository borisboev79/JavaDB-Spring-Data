import Enums.Constants;
import Enums.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex01_02_GetVilliansNames {
    private static final String GET_VILLAIN_NAMES = "SELECT v.name, count(DISTINCT mv.minion_id) AS minions_count FROM villains AS v\n" +
            "            JOIN minions_villains mv on v.id = mv.villain_id\n" +
            "            GROUP BY mv.villain_id\n" +
            "            HAVING minions_count > ?\n" +
            "             ORDER BY minions_count;";
    private static final String COLUMN_LABEL_COUNT = "minions_count";


    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getSQLConnection();

        final PreparedStatement statement = connection.prepareStatement(GET_VILLAIN_NAMES);

        statement.setInt(1, 15);

        final ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            final String villainName = resultSet.getString(Constants.COLUMN_LABEL_NAME);
            final int villainCount = resultSet.getInt(COLUMN_LABEL_COUNT);
            System.out.printf("%s %d", villainName, villainCount);

        }

    }
}

