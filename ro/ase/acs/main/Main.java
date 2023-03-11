package ro.ase.acs.main;

import ro.ase.acs.classes.Operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);
            Operations operations=new Operations();
           operations.createTable(connection);
            operations.insertData(connection);
            operations.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}