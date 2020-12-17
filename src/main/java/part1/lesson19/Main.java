package part1.lesson19;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;


public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        logger.info("Start Main class");

        Connection connection = new ConnectorDB().getConnection();
        ConnectorDB.getDropTable(connection);
        ConnectorDB.createTable(connection);
        ConnectorDB.addObjectSql(connection);

        Request request = new Request();
        request.parameterizedQuery(connection);
        request.batching(connection);
        request.manualTransaction(connection);
        request.savepoint(connection);
        request.rollbackOperations(connection);
    }
}
