import Enums.Constants;
import Enums.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex01_03_GetMinionNames {
    private static String GET_MINIONS_NAME_AND_AGE_BY_VILLAIN_ID = "SELECT m.name, m.age\n" +
            "FROM minions AS m\n" +
            "JOIN minions_villains AS mv ON m.id = mv.minion_id\n" +
            "WHERE mv.villain_id = ?";

    private static final String GET_VILLAIN_NAME_BY_ID = "SELECT v.name FROM villains AS v WHERE v.id = ?";
    private static final String COLUMN_LABEL_AGE = "age";
    private static final String VILLAIN_FORMAT = "Villain: %s%n";
    private static final String MINION_FORMAT = "%d. %s %d%n";
    private static String NO_VILLAIN_FORMAT = "No villain with ID %d exists in the database.";


    public static void main(String[] args) throws SQLException {

        final Connection connection = Utils.getSQLConnection();

        final PreparedStatement villainStatement = connection.prepareStatement(GET_VILLAIN_NAME_BY_ID);

        final int villainId = new Scanner(System.in).nextInt();

        villainStatement.setInt(1, villainId);

        final ResultSet villainSet = villainStatement.executeQuery();


        if (!villainSet.next()) {
            System.out.printf(NO_VILLAIN_FORMAT, villainId);
            connection.close();
            return;
        }
        final String villainName = villainSet.getString(Constants.COLUMN_LABEL_NAME);

        System.out.printf(VILLAIN_FORMAT, villainName);

        final PreparedStatement minionsStatement = connection.prepareStatement(GET_MINIONS_NAME_AND_AGE_BY_VILLAIN_ID);
        minionsStatement.setInt(1, villainId);
        final ResultSet minionSet = minionsStatement.executeQuery();

       for (int index = 1; minionSet.next(); index++) {
            final String minionName = minionSet.getString(Constants.COLUMN_LABEL_NAME);
            final int minionAge = minionSet.getInt(COLUMN_LABEL_AGE);

            System.out.printf(MINION_FORMAT, index, minionName, minionAge);
        }
        connection.close();

    }

    }



