import static java.util.UUID.randomUUID;

public class AccountCreaterDestroyer {

    public static BankAccountInformationHolder createNewAccount(String firstName, String lastName, double balance) throws Exception{
        BankAccountInformationHolder account = new BankAccountInformationHolder(String.valueOf(randomUUID()), firstName, lastName, balance);
        SQLConnector.insertAccounts(account.getAccountNumber(), firstName, lastName, balance);
        SQLConnector.insertTransactions(account.getAccountNumber(), "Initial Deposit", balance, "Credit");
        return account;
    }

}
