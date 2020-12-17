package part1.lesson19;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.stream.Collectors;

/**
 * Класс для подключения к БД.
 * Создания и наполнения таблицы данными.
 * Удаление таблиц с БД.
 */
public class ConnectorDB implements ConnectionDB {

    /**
     * Метод для подключения к БД.
     *
     * @return соединение с БД.
     * @throws SQLException выбрасывается исключение если нет подключения к БД.
     */
    private static Logger logger = LoggerFactory.getLogger(ConnectorDB.class);

    //    public static Connection getConnect() throws SQLException {
//        String url = "jdbc:postgresql://localhost:5432/stc31jdbc";
//        logger.trace("Подключение к " + url);
//        String username = "postgres";
//        String password = "1988";
//        logger.info("Соединение с БД.");
//        return DriverManager.getConnection(url, username, password);
//    }
    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stc31jdbc",
                    "postgres", "1988");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Ошибка в методе getConnection: " + e);
        }
        return connection;
    }

    /**
     * Метод для создания таблиц в БД.
     *
     * @param connection входной параметр подключения
     */
    public static void createTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS public");
            connection.setSchema("public");
            String sql = new BufferedReader(new FileReader(
                    "D:\\stc-31\\src\\main\\java\\part1\\lesson19\\CreateTable.sql")).lines()
                    .collect(Collectors.joining("\n"));
            statement.executeUpdate(sql);
            logger.info(sql);
        } catch (SQLException | FileNotFoundException e) {
            logger.error("createTable: " + e);
            e.printStackTrace();
        }
    }

    /**
     * Метод наполнения таблиц данными
     *
     * @param connection входной параметр подключения
     */
    public static void addObjectSql(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            String sql = new BufferedReader(new FileReader(
                    "D:\\stc-31\\src\\main\\java\\part1\\lesson19\\CreateObject.sql")).lines()
                    .collect(Collectors.joining("\n"));
            statement.executeUpdate(sql);
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    /**
     * Метод удаления таплиц из БД.
     *
     * @param connection входной параметр подключения
     */
    public static void getDropTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            String sql = new BufferedReader(new FileReader(
                    "D:\\stc-31\\src\\main\\java\\part1\\lesson19\\dropTable.sql")).lines()
                    .collect(Collectors.joining("\n"));
            statement.executeUpdate(sql);
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}
