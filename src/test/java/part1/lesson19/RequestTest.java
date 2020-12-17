package part1.lesson19;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.*;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class RequestTest {
    @InjectMocks
    private Request request;
    @Mock
    Connection connection;
    @Mock
    ConnectorDB connectorDB;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private Statement statement;
    @Mock
    private Savepoint savepoint;


    @BeforeEach
    void setUp() {
        openMocks(this);
        connection = mock(Connection.class);
        connectorDB = mock(ConnectorDB.class);
        when(connectorDB.getConnection()).thenReturn(connection);
        request = spy(new Request(connectorDB));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("параметризованный запрос parameterizedQuery")
    void parameterizedQuery() throws SQLException {
        when(connection.prepareStatement(Request.SELECT_QUERY)).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(resultSet.getInt("id")).thenReturn(1).thenReturn(2);
        when(resultSet.getString("nickname")).thenReturn("nick");
        when(resultSet.getInt("age")).thenReturn(23);
        request.parameterizedQuery(connection);
        //connection = null;
        request.parameterizedQuery(connection);

    }

    @Test
    void batching() throws SQLException {
       when(connection.createStatement()).thenReturn(statement);
       when(statement.executeUpdate(Request.INSERT_SQL1)).thenReturn(1);
       when(statement.executeUpdate(Request.INSERT_SQL2)).thenReturn(2);
       when(connection.prepareStatement(Request.SELECT_BATCHING)).thenReturn(preparedStatement);
       when(preparedStatement.executeQuery()).thenReturn(resultSet);
       when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
       when(resultSet.getInt("id")).thenReturn(1).thenReturn(2);
       when(resultSet.getString("nickname")).thenReturn("name");
       when(resultSet.getInt("age")).thenReturn(5);
       request.batching(connection);

    }

    @Test
    void manualTransaction() throws SQLException {
        when(connection.prepareStatement(Request.UPDATE_SQL)).thenReturn(preparedStatement);

        when(resultSet.getInt("age")).thenReturn(18);
        when(resultSet.getInt("id")).thenReturn(3);
        when(preparedStatement.executeUpdate()).thenReturn(1);
        request.manualTransaction(connection);
    }

    @Test
    void savepoint() throws SQLException {
        when(connection.setSavepoint()).thenReturn(savepoint);
        when(connection.prepareStatement(Request.SAVEPOINT_UPDATE)).thenReturn(preparedStatement);
        when(resultSet.getInt("age")).thenReturn(30);
        when(resultSet.getInt("id")).thenReturn(4);
        when(preparedStatement.executeUpdate()).thenReturn(5);
        when(connection.prepareStatement(Request.SAVEPOINT_DELETE)).thenReturn(preparedStatement);
        when(resultSet.getInt("id")).thenReturn(1);
        when(preparedStatement.executeUpdate()).thenReturn(1);
        when(connection.setSavepoint()).thenReturn(savepoint);
        request.savepoint(connection);
    }

    @Test
    void rollbackOperations() throws SQLException {
        when(connection.prepareStatement(Request.ROL_DELETE)).thenReturn(preparedStatement);
        request.rollbackOperations(connection);
    }
}