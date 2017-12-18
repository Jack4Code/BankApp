public class AccountTransactionManager {

    public static void makeDeposit(BankAccountInformationHolder account, double amount){
        double oldBalance = account.getAccountBalance();
        double newBalance = oldBalance + amount;
        account.setAccountBalance(newBalance);
    }

    public static void makeWithdrawl(BankAccountInformationHolder account, double amount){
        double oldBalance = account.getAccountBalance();
        double newBalance = oldBalance - amount;
        account.setAccountBalance(newBalance);
    }


}
