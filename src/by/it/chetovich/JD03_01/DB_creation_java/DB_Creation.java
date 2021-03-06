package by.it.chetovich.JD03_01.DB_creation_java;

import java.sql.*;


/**
 * DB Creation
 */
public class DB_Creation {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement()) {

            QueriesForDB_Creation.createTable(statement);
            QueriesForDB_Creation.insertData(statement);
            //QueriesForDB_Creation.showTables(statement);
            System.out.println("Database searchhost_java was created");


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
