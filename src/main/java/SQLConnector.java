import java.sql.*;

public class SQLConnector {

    private static Connection con = null;

    public static void openConnection(String dbType) throws Exception{
        if(dbType.equalsIgnoreCase("SQL")){
            openSQLConnection();
        }
    }

    //should not be hard coded...do system environment vairbales in docker
    public static void openSQLConnection() throws Exception {
        try{
            //Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=bankapp","jgiannini", "password");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void insertAccounts(String accountNumber, String firstName, String lastName, double balance) throws Exception{
        openSQLConnection();
        String query = String.format("insert into accounts (accountNumber, firstName, lastName, balance) values ('" + accountNumber + "', '" + firstName + "', '" + lastName + "', " + balance + ")");
        Statement stmt = con.createStatement();
        stmt.execute(query);
        stmt.close();
        con.close();
    }

    public static void insertTransactions(String accountNumber, String description, double amount, String transactionType) throws Exception{
        openSQLConnection();
        String query = String.format("insert into transactions (accountNumber, description, amount, transactionType) values ('" + accountNumber + "', '" + description + "', " + amount + ", '" + transactionType + "')");
        Statement stmt = con.createStatement();
        stmt.execute(query);
        stmt.close();
        con.close();
    }

    public static ResultSet basicQuery() throws Exception{
        String query = String.format("select * from accounts");
        Statement stmt = con.createStatement();
        return stmt.executeQuery(query);
    }

    public static void closeConnection()throws Exception{
        try{
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
