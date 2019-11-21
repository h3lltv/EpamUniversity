import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("shopping");
        dataSource.setServerTimezone("UTC");
        dataSource.setUser("root");
        dataSource.setPassword("1488");
        dataSource.setServerName("localhost");
        connect = dataSource.getConnection();
        statement = connect.createStatement();
    }

    public void getAllGoods() throws SQLException {
        resultSet = statement.executeQuery("select * from shopping.product");
        writeResultSet(resultSet);
    }

    public void getAvailableGoods(ArrayList<String> list) throws SQLException {
        System.out.println("\n" + "Bought: ");
        for (String s : list) {
            resultSet = statement
                    .executeQuery("select product.name, product.price from shopping.product " +
                            "where product.name=" + "'" + s + "'");
            writeResultSet(resultSet);
        }
    }

    public void getTotalCost(ArrayList<String> list) throws SQLException {
        System.out.println("\n" + "Total: ");
        for (String s : list) {
            resultSet = statement
                    .executeQuery("select SUM(shopping.product.price) from shopping.product " +
                            "where product.name=" + "'" + s + "'");
            getPrice(resultSet);
        }
    }

    private void getPrice(ResultSet resultSet) throws SQLException {
        double result = 0d;
        while (resultSet.next()) {
            result += resultSet.getDouble(1);
        }
        System.out.println(result);
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String price = resultSet.getString("price");
            System.out.println(name + " - " + price + "$");
        }
    }

    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
        }
    }
}