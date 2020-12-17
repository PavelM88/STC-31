package part1.lesson19;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class Request {
    private static Logger logger = LoggerFactory.getLogger(Request.class);
    private ConnectionDB connectionDB;
    public static String SELECT_QUERY = "select  id, nickname, age from animal where age = ?";
    public static String INSERT_SQL1 = "insert into animal values (4, 'Bobik', 8)";
    public static String INSERT_SQL2 = "insert into animal values (5, 'Markiza', 3)";
    public static String SELECT_BATCHING = "select id, nickname, age from animal";
    public static String UPDATE_SQL = "UPDATE person SET age = ? WHERE id = ?";
    public static String SAVEPOINT_UPDATE = "UPDATE person SET age = ? WHERE id = ?";
    public static String SAVEPOINT_DELETE = "DELETE FROM person WHERE id = ?";
    public static String ROL_DELETE = "DELETE FROM person WHERE id = ?";

    public Request(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    public Request() {

    }

    /**
     * параметризованный запрос
     *
     * @param connection входной параметр подключения
     * @throws SQLException
     */
    public void parameterizedQuery(Connection connection) throws SQLException {

        logger.info("Параметризованный запрос");
        PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
        ps.setInt(1, 5);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String table = "id = " + rs.getInt("id") + "\t" +
                    "nickname = " + rs.getString("nickname") + "\t"
                    + "age = " + rs.getInt("age");
            logger.info(table);
        }
    }

    /**
     * батчинг
     *
     * @param connection входной параметр подключения
     * @throws SQLException
     */
    public void batching(Connection connection) throws SQLException {
        logger.info("Батчинг");
        Statement statement = connection.createStatement();

        statement.addBatch(INSERT_SQL1);
        statement.addBatch(INSERT_SQL2);

        statement.executeBatch();

        ResultSet resultSet = statement.executeQuery(SELECT_BATCHING);
        while (resultSet.next()) {
            String table = "id = " + resultSet.getInt("id") + "\t" +
                    "nickname = " + resultSet.getString("nickname") + "\t" +
                    "age = " + resultSet.getInt("age");
            logger.info(table);
        }
    }

    /**
     * ручное управление транзакциями
     *
     * @param connection входной параметр подключения
     * @throws SQLException
     */
    public void manualTransaction(Connection connection) throws SQLException {
        logger.info("Ручное управление транзакциями.");
        connection.setAutoCommit(false);
        PreparedStatement ps = connection.prepareStatement(UPDATE_SQL);
        int age = 61;
        ps.setInt(1, age);
        int id = 1;
        ps.setInt(2, id);
        ps.executeUpdate();
        connection.commit();
    }

    /**
     * использование savepoint при выполнении логики из нескольких запросов
     *
     * @param connection входной параметр подключения
     * @throws SQLException
     */
    public void savepoint(Connection connection) throws SQLException {
        logger.info("Использование savepoint.");
        connection.setAutoCommit(false);
        Savepoint savepoint = connection.setSavepoint();

        PreparedStatement ps = connection.prepareStatement(SAVEPOINT_UPDATE);
        int age = 44;
        ps.setInt(1, age);
        int id = 2;
        ps.setInt(2, id);
        ps.executeUpdate();

        ps = connection.prepareStatement(SAVEPOINT_DELETE);
        ps.setInt(1, 3);
        ps.executeUpdate();

        connection.rollback(savepoint);
        connection.commit();

    }

    /**
     * rollback операций при ошибках
     *
     * @param connection входной параметр подключения
     * @throws SQLException
     */
    public void rollbackOperations(Connection connection) throws SQLException {
        logger.info("Rollback операции при ошибках.");
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(ROL_DELETE);
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
            logger.error("rollbackOperations: " + e);
            connection.rollback();
        }
    }
}
