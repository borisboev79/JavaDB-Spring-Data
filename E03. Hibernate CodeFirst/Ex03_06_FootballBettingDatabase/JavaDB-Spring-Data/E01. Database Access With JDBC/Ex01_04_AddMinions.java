import Enums.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static Queries.AddMinionsQueries.*;

public class Ex01_04_AddMinions {
    private static final String TOWN_ADDED_FORMAT = "Town %s was added to the database.%n";
    private static final String VILLAIN_ADDED_FORMAT = "Villain %s was added to the database.%n";
    private static final String COLUMN_LABEL_ID = "id";

    public static void main(String[] args) throws SQLException {

        //01. CREATE THE CONNECTION TO DATABASE minions

        final Connection connection = Utils.getSQLConnection();

        final Scanner scanner = new Scanner(System.in);

        final String[] minionInfo = scanner.nextLine().split(" ");

        final String minionName = minionInfo[1];
        final int minionAge = Integer.parseInt(minionInfo[2]);
        final String minionTown = minionInfo[3];

        final String villainName = scanner.nextLine().split(" ")[1];

        //02. CHECK IF TOWN EXISTS AND ADD IT IF NOT
        final int townId = getFromDatabase(connection, minionTown, GET_TOWN_BY_NAME, INSERT_INTO_TOWNS, TOWN_ADDED_FORMAT);

        //03. CHECK IF VILLAIN EXISTS AND ADD IT IF NOT
        final int villainId = getFromDatabase(connection, villainName, GET_VILLAIN_BY_NAME, INSERT_INTO_VILLAINS, VILLAIN_ADDED_FORMAT);

        //04. CHECK IF MINION EXISTS AND ADD IT IF NOT
        final PreparedStatement minionStatement = connection.prepareStatement(GET_MINION_BY_NAME);
        minionStatement.setString(1, minionName);

        ResultSet minionResult = minionStatement.executeQuery();

        if (!minionResult.next()) {

            final PreparedStatement addMinionStatement = connection.prepareStatement(ADD_MINION);
            addMinionStatement.setString(1, minionName);
            addMinionStatement.setInt(2, minionAge);
            addMinionStatement.setInt(3, townId);

            addMinionStatement.executeUpdate();
        }

        minionResult = minionStatement.executeQuery();
        if (!minionResult.next()) {
            throw new SQLException("No such minion ID in database");
        }
        final int minionId = minionResult.getInt(COLUMN_LABEL_ID);

        //05. FINALLY ASSIGN MINION TO VILLAIN

        final PreparedStatement minionToVillainStatement = connection.prepareStatement(ASSIGN_MINION_TO_VILLAIN);
        minionToVillainStatement.setInt(1, minionId);
        minionToVillainStatement.setInt(2, villainId);

        minionToVillainStatement.executeUpdate();

        System.out.printf("Successfully added %s to be minion of %s.", minionName, villainName);
        connection.close();

    }

    private static int getFromDatabase(Connection connection, String name, String selectQuery, String updateQuery, String printFormat) throws SQLException {
        final PreparedStatement townStatement = connection.prepareStatement(selectQuery);
        townStatement.setString(1, name);

        ResultSet townSet = townStatement.executeQuery();

        if (!townSet.next()) {
            final PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.setString(1, name);

            statement.executeUpdate();
            System.out.printf(printFormat, name);
        }
        townSet = townStatement.executeQuery();

        if (!townSet.next()) {
            throw new SQLException("No such ID in database");
        }
        return townSet.getInt(COLUMN_LABEL_ID);
    }
}
