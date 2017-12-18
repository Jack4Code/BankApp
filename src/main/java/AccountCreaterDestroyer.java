import static java.util.UUID.randomUUID;

public class AccountCreaterDestroyer {

    public static BankAccountInformationHolder createNewAccount() throws Exception{
        BankAccountInformationHolder account = new BankAccountInformationHolder(String.valueOf(randomUUID()), 500);
        SQLConnector.insertQuery(account.getAccountNumber(), account.getAccountBalance(), account.getInterestRate());
        return account;
    }

}
