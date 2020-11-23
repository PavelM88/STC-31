package part1.lesson19;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectorDB.getConnect();
        ConnectorDB.getDropTable(connection);
        ConnectorDB.createTable(connection);
        ConnectorDB.addObjectSql(connection);
        parameterizedQuery(connection);
        batching(connection);
        manualTransaction(connection);
        savepoint(connection);
        rollbackOperations(connection);
    }

    /**
     * параметризованный запрос
     *
     * @param connection входной параметр подключения
     * @throws SQLException
     */
    public static void parameterizedQuery(Connection connection) throws SQLException {
        System.out.println("параметризованный запрос:");
        String sql = "select  id, nickname, age from animal where age = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, 5);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String table = "id = " + rs.getInt("id") + "\t" +
                    "nickname = " + rs.getString("nickname") + "\t"
                    + "age = " + rs.getInt("age");
            System.out.println(table);
        }
    }

    /**
     * батчинг
     *
     * @param connection входной параметр подключения
     * @throws SQLException
     */
    public static void batching(Connection connection) throws SQLException {
        System.out.println("Батчинг:");
        Statement statement = connection.createStatement();

        String insertSql1 = "insert into animal values (4, 'Bobik', 8)";
        statement.addBatch(insertSql1);
        String insertSql2 = "insert into animal values (5, 'Markiza', 3)";
        statement.addBatch(insertSql2);

        statement.executeBatch();

        String sqlAnimal = "select id, nickname, age from animal";

        ResultSet resultSet = statement.executeQuery(sqlAnimal);
        while (resultSet.next()) {
            String table = "id = " + resultSet.getInt("id") + "\t" +
                    "nickname = " + resultSet.getString("nickname") + "\t" +
                    "age = " + resultSet.getInt("age");
            System.out.println(table);
        }
    }

    /**
     * ручное управление транзакциями
     *
     * @param connection входной параметр подключения
     * @throws SQLException
     */
    public static void manualTransaction(Connection connection) throws SQLException {
        System.out.println("Ручное управление транзакциями.");
        connection.setAutoCommit(false);
        String updateSql = "UPDATE person SET age = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(updateSql);
        int age = 61;
        ps.setInt(1, age);
        int id = 1;
        ps.setInt(2, id);
        ps.executeUpdate();
        connection.commit();
    }

    /**
     * использование savepoint при выполнении логики из нескольких запросов
     * @param connection входной параметр подключения
     * @throws SQLException
     */
    public static void savepoint(Connection connection) throws SQLException {
        System.out.println("Использование savepoint.");
        connection.setAutoCommit(false);
        Savepoint savepoint = connection.setSavepoint();

        String updateSql = "UPDATE person SET age = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(updateSql);
        int age = 44;
        ps.setInt(1, age);
        int id = 2;
        ps.setInt(2, id);
        ps.executeUpdate();

        String deleteSql = "DELETE FROM person WHERE id = ?";
        ps = connection.prepareStatement(deleteSql);
        ps.setInt(1, 3);
        ps.executeUpdate();

        connection.rollback(savepoint);
        connection.commit();

    }

    /**
     *  rollback операций при ошибках
     * @param connection входной параметр подключения
     * @throws SQLException
     */
    public static void rollbackOperations(Connection connection) throws SQLException {
        try {
            connection.setAutoCommit(false);
            String deleteSQL = "DELETE FROM person WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(deleteSQL);
            ps.setInt(1, 3);
            ps.execute();

            String updateSql = "UPDATE person SET age_person = ? WHERE id = ?";
            ps = connection.prepareStatement(updateSql);
            int age = 15;
            ps.setInt(1, age);
            int id = 3;
            ps.setInt(2, id);
            ps.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
    }
}
