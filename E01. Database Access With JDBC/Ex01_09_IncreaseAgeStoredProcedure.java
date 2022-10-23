import Enums.Utils;

import java.sql.*;
import java.util.Scanner;

import static Queries.IncreaseAgeStoredProcedureQuery.CREATE_PROCEDURE;
import static Queries.IncreaseAgeStoredProcedureQuery.GET_UPDATED_MINION;

public class Ex01_09_IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        final int minion_id = Integer.parseInt(scanner.nextLine());

        Connection connection = Utils.getSQLConnection();

        CallableStatement callProcedure = connection.prepareCall(CREATE_PROCEDURE);
        callProcedure.setInt(1, minion_id);

        callProcedure.executeUpdate();

        PreparedStatement getUpdatedMinion = connection.prepareStatement(GET_UPDATED_MINION);
        getUpdatedMinion.setInt(1, minion_id);
        ResultSet result = getUpdatedMinion.executeQuery();

        if (result.next()) {
            String name = result.getString("name");
            int age = result.getInt("age");
            System.out.printf("%s %d", name, age);
        }
        connection.close();
    }
}
