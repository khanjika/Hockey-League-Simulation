package database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallStoredProcedure {

    private String storedProcedureName;
    private Connection connection;
    private CallableStatement statement;

    public CallStoredProcedure(String storedProcedureName) throws SQLException {
        this.storedProcedureName = storedProcedureName;
        connection = null;
        statement = null;
        openConnection();
        createStatement();
    }

    private void openConnection() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        connection = databaseConnection.getConnection();
    }

    private void createStatement() throws SQLException {
        statement = connection.prepareCall("{call " + storedProcedureName + "}");
    }

    public void cleanup() {
        try {
            if (null != statement) {
                statement.close();
            }
            if (null != connection) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void execute() throws SQLException {
        statement.execute();
    }

    public Integer getNumericReturnValue(int index) throws SQLException {
        return statement.getInt(index);
    }

    public void setParameter(int paramIndex, long value) throws SQLException {
        statement.setLong(paramIndex, value);
    }
    public void setParameter(int paramIndex, boolean value) throws SQLException {
        statement.setBoolean(paramIndex, value);
    }

    public void setParameter(int paramIndex, String value) throws SQLException {
        statement.setString(paramIndex, value);
    }

    public void registerOutParameter(int index) throws SQLException {
        statement.registerOutParameter(index, java.sql.Types.VARCHAR);
    }

    public ResultSet getResultSetObject() throws SQLException {
        if (statement.execute()) {
            return statement.getResultSet();
        }
        return null;
    }

}
