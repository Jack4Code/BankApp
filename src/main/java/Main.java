import java.sql.Connection;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) throws Exception{
        BankAccountInformationHolder account = AccountCreaterDestroyer.createNewAccount();
//        SQLConnector.openSQLConnection();
//        ResultSet rs = SQLConnector.basicQuery();
//        String account = "";
//        while(rs.next()){
//            account = rs.getString("accountNumber");
//        }
//        System.out.println(account);
//        rs.close();
//        SQLConnector.closeConnection();

    }

}
