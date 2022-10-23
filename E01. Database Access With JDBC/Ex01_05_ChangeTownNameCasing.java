import Enums.Constants;
import Enums.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01_05_ChangeTownNameCasing {
    private static final String CHANGE_TOWN_CASING = "UPDATE towns AS t Set name = UPPER(name) WHERE t.country = ?";
    private static final String SELECT_COUNTRIES_TOWNS = "SELECT t.name FROM towns AS t WHERE t.country = ?";

    private static final String NO_TOWNS_AFFECTED_MESSAGE = "No town names were affected.";
    private static final String COUNT_OF_TOWNS_AFFECTED_FORMAT = "%d town names were affected.%n";
    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getSQLConnection();

        final String town_name = new Scanner(System.in).nextLine();

        final PreparedStatement statement = connection.prepareStatement(CHANGE_TOWN_CASING);
        statement.setString(1, town_name);

        final int updatedCount = statement.executeUpdate();

        if(updatedCount == 0){
            System.out.println(NO_TOWNS_AFFECTED_MESSAGE);
            connection.close();
            return;
        }
        System.out.printf(COUNT_OF_TOWNS_AFFECTED_FORMAT, updatedCount);

        final PreparedStatement selectAllTowns = connection.prepareStatement(SELECT_COUNTRIES_TOWNS);
        selectAllTowns.setString(1, town_name);
        final ResultSet allTownsResult = selectAllTowns.executeQuery();

        List<String> towns = new ArrayList<>();

        while(allTownsResult.next()) {
            towns.add(allTownsResult.getString(Constants.COLUMN_LABEL_NAME));
        }

        System.out.println(towns);
        connection.close();
    }

}
