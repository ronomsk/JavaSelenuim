package ru.raif.cources.preparedstatement;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_CONNECTION = "jdbc:postgresql://127.0.0.1:5432/testdb";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "123456";

    public static void main(String[] argv) {

        try {

            selectRecordsFromTable();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    private static void selectRecordsFromTable() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL = "SELECT USER_ID, USERNAME FROM DBUSER WHERE USER_ID = ?";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, 1001);

            // execute select SQL stetement
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                String userid = rs.getString("USER_ID");
                String username = rs.getString("USERNAME");

                System.out.println("userid : " + userid);
                System.out.println("username : " + username);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

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
}
