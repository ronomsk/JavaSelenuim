package ru.raif.cources.preparedstatement;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch {
    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_CONNECTION = "jdbc:postgresql://127.0.0.1:5432/testdb";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "123456";


    public static void main(String[] argv) {

        try {

            batchInsertRecordsIntoTable();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    private static void batchInsertRecordsIntoTable() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO DBUSER"
                + "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) VALUES"
                + "(?,?,?,?)";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            dbConnection.setAutoCommit(false);

            preparedStatement.setInt(1, 101);
            preparedStatement.setString(2, "mkyong101");
            preparedStatement.setString(3, "system");
            preparedStatement.setTimestamp(4, getCurrentTimeStamp());
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 102);
            preparedStatement.setString(2, "mkyong102");
            preparedStatement.setString(3, "system");
            preparedStatement.setTimestamp(4, getCurrentTimeStamp());
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 103);
            preparedStatement.setString(2, "mkyong103");
            preparedStatement.setString(3, "system");
            preparedStatement.setTimestamp(4, getCurrentTimeStamp());
            preparedStatement.addBatch();

            preparedStatement.executeBatch();

            dbConnection.commit();

            System.out.println("Record is inserted into DBUSER table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            dbConnection.rollback();

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }

    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }
}
