import Enums.Constants;
import Enums.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static Queries.RemoveVillainQueries.*;

public class Ex01_06_RemoveVillain {

    private static final String COLUMN_LABEL_MINION_COUNT = "count";
    private static final String NO_SUCH_VILLAIN_MESSAGE = "No such villain was found";
    private static final String VILLAIN_NAME_DELETED = "%s was deleted%n";
    private static final String COUNT_OF_MINIONS_RELEASED = "%d minions released%n";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getSQLConnection();

        final int villainId = new Scanner(System.in).nextInt();

        final PreparedStatement selectedVillain = connection.prepareStatement(GET_VILLAIN_BY_ID);
        selectedVillain.setInt(1, villainId);

        final ResultSet villainSet = selectedVillain.executeQuery();

        if(!villainSet.next()){
            System.out.println(NO_SUCH_VILLAIN_MESSAGE);
            connection.close();
            return;
        }

        final String villainName = villainSet.getString(Constants.COLUMN_LABEL_NAME);

       final PreparedStatement selectAllMinions = connection.prepareStatement(GET_MINION_COUNT_BY_VILLAINS_ID);
        selectAllMinions.setInt(1, villainId);

        ResultSet countOfMinionsSet = selectAllMinions.executeQuery();

        countOfMinionsSet.next();
        final int countOfDeletedMinions = countOfMinionsSet.getInt(COLUMN_LABEL_MINION_COUNT);

        connection.setAutoCommit(false);

        try{
            PreparedStatement releaseMinions = connection.prepareStatement(DELETE_VILLAIN_FROM_MINIONS_VILLAINS);
            releaseMinions.setInt(1, villainId);
            releaseMinions.executeUpdate();

            PreparedStatement deleteVillain = connection.prepareStatement(DELETE_VILLAIN);
            deleteVillain.setInt(1, villainId);
            deleteVillain.executeUpdate();

            System.out.printf(VILLAIN_NAME_DELETED, villainName);
            System.out.printf(COUNT_OF_MINIONS_RELEASED, countOfDeletedMinions);

            connection.commit();

        } catch (SQLException e){

            e.printStackTrace();
            connection.rollback();
        }
        connection.close();

    }
}

