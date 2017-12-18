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

    public static void insertQuery(String accountNumber, double balance, double interestRate) throws Exception{
        openSQLConnection();
        String query = String.format("insert into accounts (accountNumber, balance, interestRate) values ('" + accountNumber + "', " + balance + ", " + interestRate + ")");
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
