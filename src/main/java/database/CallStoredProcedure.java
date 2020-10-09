package database;

import java.sql.*;

public class CallStoredProcedure {

    private String storedProcedureName;
    private Connection connection;
    private CallableStatement statement;

    public CallStoredProcedure(String storedProcedureName) throws SQLException {
        this.storedProcedureName = storedProcedureName;
        connection = null;
        statement = null;
        openConnection ();
        createStatement ();
    }

    private void openConnection() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection ();
        connection = databaseConnection.getConnection ();
    }

    private void createStatement() throws SQLException {
        String callProcedure = "{call " + storedProcedureName + "}";
        statement = connection.prepareCall (callProcedure);
    }

    public void clean() {
        try {
            if (statement != null) {
                statement.close ();
            }
            if (connection != null) {
                connection.close ();
            }
        } catch (Exception e) {
            System.out.println (e);
        }
    }

    public void execute() throws SQLException {
        statement.executeQuery ();
    }

    public Integer getNumericReturnValue(int index) throws SQLException {
        return statement.getInt (index);
    }

    public String getStringReturnValue(int index) throws SQLException {
        return statement.getString (index);
    }

    public void setParameter(int paramIndex, long value) throws SQLException {
        statement.setLong (paramIndex, value);
    }

    public void setParameter(int paramIndex, boolean value) throws SQLException {
        statement.setBoolean (paramIndex, value);
    }

    public void setParameter(int paramIndex, String value) throws SQLException {
        statement.setString (paramIndex, value);
    }

    public void registerOutParameter(int index) throws SQLException {
        statement.registerOutParameter (index, Types.INTEGER);
    }

    public void registerOutParameterString(int index) throws SQLException {
        statement.registerOutParameter (index, java.sql.Types.VARCHAR);
    }

    public ResultSet getResultSetObject() throws SQLException {
        if (statement.execute ()) {
            return statement.getResultSet ();
        }
        return null;
    }

}
