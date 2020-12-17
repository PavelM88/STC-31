package part1.lesson19;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class ConnectorDBTest {
    private ConnectorDB connector;
    @Mock
    private ConnectorDB connectorDB;
    @Mock
    private Connection connection;
    @Mock
    Statement statement;
    @Mock
    BufferedReader reader;
    @Mock
    private FileReader fileReader;
    private String sql;
    @Mock
    File file;



    @BeforeEach
    void setUp() {
        openMocks(this);
        connection = mock(Connection.class);
        connectorDB = mock(ConnectorDB.class);
        when(connectorDB.getConnection()).thenReturn(connection);
        spy(connector = new ConnectorDB()).getConnection();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createTable() throws SQLException {
        fileReader = mock(FileReader.class);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeUpdate(sql)).thenReturn(1);
        when(file.listFiles()).thenReturn(null);
        ConnectorDB.createTable(connection);
        ConnectorDB.addObjectSql(connection);
        ConnectorDB.getDropTable(connection);
    }

    @Test
    void addObjectSql() throws SQLException {
        fileReader = mock(FileReader.class);
        when(connection.createStatement()).thenReturn(statement);
    }

    @Test
    void getDropTable() {
    }
}