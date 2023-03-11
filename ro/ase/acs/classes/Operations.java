package ro.ase.acs.classes;

import java.sql.*;

public class Operations extends SQLException{
    private static final String SQL_DROP ="DROP TABLE IF EXISTS employees";
    private static final String SQL_CREATE="CREATE TABLE employees(id INTEGER PRIMARY KEY,"
            + "name TEXT, address TEXT, salary REAL)";
    private static final String SQL_INSERT="INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)";
    private static final String SQL_INSERT_PARAMS="INSERT INTO employees VALUES (?,?,?,?)";
    private static final String SQL_SELECT="SELECT * FROM employees";
    private static final String NAME="Ionescu Vasile";
    private static final String CITY="Brasov";
    private static final Integer SALARY=4500;

    public static void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(SQL_DROP);
        statement.executeUpdate(SQL_CREATE);
        statement.close();
        connection.commit();
    }

    public static void insertData(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        statement.executeUpdate(SQL_INSERT);
        statement.close();

        PreparedStatement preparedStatement =
                connection.prepareStatement(SQL_INSERT_PARAMS);
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, NAME);
        preparedStatement.setString(3, CITY);
        preparedStatement.setDouble(4, SALARY);
        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.commit();
    }

    public static void readData(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(SQL_SELECT);
        while(rs.next()) {
            int id = rs.getInt("id");
            System.out.println("id: " + id);
            String name = rs.getString(2);
            System.out.println("name: " + name);
            String address = rs.getString("address");
            System.out.println("address: " + address);
            double salary = rs.getDouble("salary");
            System.out.println("salary: " + salary);
        }
        rs.close();
        statement.close();
    }
}
