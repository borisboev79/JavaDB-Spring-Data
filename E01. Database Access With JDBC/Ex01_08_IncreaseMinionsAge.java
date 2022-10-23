import Enums.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static Queries.IncreaseMinionsAgeQueries.*;

public class Ex01_08_IncreaseMinionsAge {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = Utils.getSQLConnection();

        final String[] input = scanner.nextLine().split(" ");

        String minionIds = String.join(", ", input);

        PreparedStatement updateMinions = connection.prepareStatement(String.format(UPDATE_MINIONS, minionIds));

        updateMinions.executeUpdate();

        PreparedStatement getAllMinions = connection.prepareStatement(SELECT_ALL_MINIONS);

        ResultSet allNames = getAllMinions.executeQuery();

        while (allNames.next()) {
            final String name = allNames.getString("name");
            final int age = allNames.getInt("age");

            System.out.printf("%s %d%n", name, age);
        }
        connection.close();


    }
}
