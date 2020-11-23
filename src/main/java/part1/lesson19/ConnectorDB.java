package part1.lesson19;

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
public class ConnectorDB {

    /**
     * Метод для подключения к БД.
     *
     * @return соединение с БД.
     * @throws SQLException выбрасывается исключение если нет подключения к БД.
     */
    public static Connection getConnect() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/stc31jdbc";
        String username = "postgres";
        String password = "1988";
        System.out.println("Соединение с БД.");
        return DriverManager.getConnection(url, username, password);
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
        } catch (SQLException | FileNotFoundException e) {
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
        }
    }
}
